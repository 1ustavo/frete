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
    public void listarEncomendasDisponiveis() {
        String sql = "SELECT id, descricao, nome_cliente FROM objetos WHERE status = 'Aguardando retirada' ORDER BY id ASC";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n--- 📦 ENCOMENDAS AGUARDANDO RETIRADA ---");
            System.out.println("ID   | Cliente             | Descrição");
            System.out.println("-----------------------------------------------------------------");

            boolean achou = false;
            while (rs.next()) {
                achou = true;
                int idEncomenda = rs.getInt("id");
                String nomeCliente = rs.getString("nome_cliente");
                String descricao = rs.getString("descricao");

                System.out.printf("%-4d | %-18s | %s%n", idEncomenda, nomeCliente, descricao);
            }

            if (!achou) {
                System.out.println("Nenhuma encomenda disponível para retirada.");
            }
            System.out.println("-----------------------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Erro ao listar encomendas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void retirarEncomenda(int idFuncionario, int idEncomenda) {
        Connection conn = null;
        try {
            conn = Conexao.getConnection();
            conn.setAutoCommit(false);

            String sqlRelacao = """
            INSERT INTO funcionario_encomenda (id_funcionario, id_encomenda)
            VALUES (?, ?)
            ON CONFLICT DO NOTHING
        """;

            try (PreparedStatement stmt = conn.prepareStatement(sqlRelacao)) {
                stmt.setInt(1, idFuncionario);
                stmt.setInt(2, idEncomenda);
                stmt.executeUpdate();
            }

            String sqlObjeto = """
            UPDATE objetos
            SET status = 'Em Rota para o Cliente',
                retirado_por = ?,
                data_retirada = NOW()
            WHERE id = ?
        """;

            try (PreparedStatement stmtObjeto = conn.prepareStatement(sqlObjeto)) {
                stmtObjeto.setInt(1, idFuncionario);
                stmtObjeto.setInt(2, idEncomenda);
                stmtObjeto.executeUpdate();
            }

            conn.commit();
            System.out.println("✅ Encomenda atribuída ao funcionário com sucesso!");

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
