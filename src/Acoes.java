import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Acoes {

    public void alterarStatusEncomenda(int id, String novoStatus){
        String sql = "UPDATE objetos SET status = ? WHERE id = ?";
        try(Connection conn = Conexao.getConnection();
        PreparedStatement up = conn.prepareStatement(sql)){
            up.setString(1, novoStatus);
            up.setInt(2, id);
            up.executeUpdate();
            System.out.println("Status Alterado para "+ novoStatus);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void retirarEncomenda(int idFuncionario, int idEncomenda) {
        Connection conn = null;
        try {
            conn = Conexao.getConnection();
            conn.setAutoCommit(false);

            String sqlFuncionario = "UPDATE funcionarios SET recebeid = ? WHERE id = ?";

            try (PreparedStatement stmtFuncionario = conn.prepareStatement(sqlFuncionario)) {
                stmtFuncionario.setInt(1, idEncomenda);
                stmtFuncionario.setInt(2, idFuncionario);
                stmtFuncionario.executeUpdate();
            }

            String sqlObjeto = "UPDATE objetos SET status = 'Em Rota para o Cliente', retirado_por = ?, data_retirada = NOW() WHERE id = ?";

            try (PreparedStatement stmtObjeto = conn.prepareStatement(sqlObjeto)) {
                stmtObjeto.setInt(1, idFuncionario);
                stmtObjeto.setInt(2, idEncomenda);
                stmtObjeto.executeUpdate();
            }

            conn.commit();
            System.out.println("✅ Retirada registrada com sucesso! Ambas as tabelas foram atualizadas.");

        } catch (SQLException e) {

            if (conn != null) {
                try {
                    conn.rollback();
                    System.err.println("❌ Erro na retirada. Transação desfeita.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {

            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
