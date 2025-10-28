import conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete {
    public static int deleteEncomenda(int id){

        String sql = "DELETE FROM objetos WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Encomenda deletada com sucesso!");
            System.out.println("pablo");

        }catch (Exception ez){
            ez.printStackTrace();
        }
        return 0;
    }

    public static int deleteFuncionario(int id){
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmtfunci = conn.prepareStatement(sql)){

            stmtfunci.setInt(1, id);
            stmtfunci.executeUpdate();
            System.out.println("Funcionario deletado com sucesso!");
        }catch (Exception ez){
            ez.printStackTrace();
        }
        return 0;
    }
}
