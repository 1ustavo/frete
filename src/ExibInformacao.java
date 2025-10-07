import modelo.Encomendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ExibInformacao {
    public static void exibeEncomenda(String nome){
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o nome do cliente :");
        String nome_cliente = sc.nextLine();

        String sql = "SELECT * FROM objetos WHERE nome_cliente LIKE ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            //pesquisar no sql
            stmt.setString(1, "%" + nome_cliente + "%");
             java.sql.ResultSet rs = stmt.executeQuery();
            System.out.println("Escolhido" + rs);
        }catch (Exception ez){
            ez.printStackTrace();
        }
    }

}