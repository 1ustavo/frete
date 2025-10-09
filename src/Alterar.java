import modelo.Encomendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Alterar {
    public static void alterarEncomenda(int id){
        Scanner sc = new Scanner(System.in);

        String sql = "SELECT * FROM objetos WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, id);
            java.sql.ResultSet rs = stmt.executeQuery();
            System.out.println("Qual campo você quer alterar : ");
            boolean achou = false;

            while (rs.next()) {
                achou = true;
                System.out.println("==== Encomenda ====");
                System.out.println("1 - Código: " + rs.getString("codigo"));
                System.out.println("2 - Cliente: " + rs.getString("nome_cliente"));
                System.out.println("3 - Telefone: " + rs.getString("telefone"));
                System.out.println("4 - Email: " + rs.getString("email"));
                System.out.println("5 - Documento: " + rs.getString("documento"));
                System.out.println("6 - Descrição: " + rs.getString("descricao"));
                System.out.println("7 - Transportadora: " + rs.getString("transportadora"));
                System.out.println("8 - Status: " + rs.getString("status"));
                System.out.println("9 - Observação: " + rs.getString("observacoes"));
                System.out.println("====================");
            }
            int alte = sc.nextInt();
            sc.nextLine();
            switch (alte){
                case 1 :
                    System.out.println("Novo Codigo : ");
                    String novo_codigo = sc.nextLine();
                    String altera = "UPDATE objetos SET codigo = ? WHERE id = ?";
                    PreparedStatement stmtt = conn.prepareStatement(altera);

                    stmtt.setString(1, novo_codigo);
                    stmtt.setInt(2, id);
                    stmtt.executeUpdate();
                    //
                    System.out.println("Alterado com sucesso");
                    break;

            }
        }catch (Exception ez){
            ez.printStackTrace();
        }

    }
}
