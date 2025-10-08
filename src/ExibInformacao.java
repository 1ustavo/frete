import modelo.Encomendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ExibInformacao {
    public static void exibeEncomenda(String nome){

        String sql = "SELECT * FROM objetos WHERE nome_cliente LIKE ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            //pesquisar no sql
            stmt.setString(1, "%" + nome + "%");
             java.sql.ResultSet rs = stmt.executeQuery();

            boolean achou = false;

            while (rs.next()) {
                achou = true;
                System.out.println("==== Encomenda ====");
                System.out.println("Código: " + rs.getString("codigo"));
                System.out.println("Cliente: " + rs.getString("nome_cliente"));
                System.out.println("Telefone: " + rs.getString("telefone"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Documento: " + rs.getString("documento"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("Transportadora: " + rs.getString("transportadora"));
                System.out.println("Status: " + rs.getString("status"));
                System.out.println("Observação: " + rs.getString("observacoes"));
                System.out.println("====================");
            }

            if (!achou) {
                System.out.println("Nenhum cliente encontrado com o nome: " + nome);
            }


        }catch (Exception ez){
            ez.printStackTrace();
        }
    }

}