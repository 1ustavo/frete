import modelo.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExibFuncionario {
    public static void exibeFuncionario(String nome){

        String sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";

        try(Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "%" + nome + "%");
            java.sql.ResultSet rs = stmt.executeQuery();

            boolean achou = false;

            while(rs.next()) {
                achou = true;
                System.out.println("=== Funcionario ===");
                System.out.println("ID : "+ rs.getInt("id"));
                System.out.println("Nome : "+ rs.getString("nome"));
                System.out.println("Email : "+ rs.getString("email"));
                System.out.println("Documento RG ou CPF : "+ rs.getString("documento"));
                System.out.println("Idade : "+ rs.getInt("idade"));
            }
            if (!achou){
                System.out.println("Nenhum funcionario encontrado com o nome: " + nome);
            }
        }catch (Exception ez){
            ez.printStackTrace();
        }
    }
}
