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
                    String alteraCodigo = "UPDATE objetos SET codigo = ? WHERE id = ?";
                    PreparedStatement stmtt = conn.prepareStatement(alteraCodigo);

                    stmtt.setString(1, novo_codigo);
                    stmtt.setInt(2, id);
                    stmtt.executeUpdate();
                    //
                    System.out.println("Alterado com sucesso");
                    break;
                case 2 :
                    System.out.println("Novo nome : ");
                    String novo_nome = sc.nextLine();
                    String alteraNome = "UPDATE objetos SET nome_cliente = ? WHERE id = ?";
                    PreparedStatement stmtnome = conn.prepareStatement(alteraNome);

                    stmtnome.setString(1, novo_nome);
                    stmtnome.setInt(2, id);
                    stmtnome.executeUpdate();
                    //
                    System.out.println("Alterado com sucesso");
                    break;

                case 3 :
                    System.out.println("Novo numero :");
                    String novo_numero = sc.nextLine();
                    String alteraNumero = "UPDATE objetos SET telefone = ? WHERE id = ?";
                    PreparedStatement stmtnumero = conn.prepareStatement(alteraNumero);

                    stmtnumero.setString(1, novo_numero);
                    stmtnumero.setInt(2, id);
                    stmtnumero.executeUpdate();
                    System.out.println("Alterado com sucesso");
                    break;

                case 4 :
                    System.out.println("Novo Email :");
                    String novo_email = sc.nextLine();
                    String alteraEmail = "UPDATE objetos SET email = ? WHERE id = ?";
                    PreparedStatement stmtemail = conn.prepareStatement(alteraEmail);

                    stmtemail.setString(1, novo_email);
                    stmtemail.setInt(2, id);
                    stmtemail.executeUpdate();
                    System.out.println("Alterado com sucesso");
                    break;

                case 5:
                    System.out.println("Novo CPF ou RG");
                    String novo_documento = sc.nextLine();
                    String alteraDocumento = "UPDATE objetos SET documento = ? WHERE id = ?";
                    PreparedStatement stmtdocumento = conn.prepareStatement(alteraDocumento);

                    stmtdocumento.setString(1, novo_documento);
                    stmtdocumento.setInt(2, id);
                    stmtdocumento.executeUpdate();
                    System.out.println("Alterado com sucesso");
                    break;

                case 6 :
                    System.out.println("Nova descrição :");
                    String novo_descricao = sc.nextLine();
                    String alteraDescricao = "UPDATE objetos SET descricao = ? WHERE id = ?";
                    PreparedStatement stmtdescricao = conn.prepareStatement(alteraDescricao);

                    stmtdescricao.setString(1, novo_descricao);
                    stmtdescricao.setInt(2, id);
                    stmtdescricao.executeUpdate();
                    System.out.println("Alterado com sucesso");
                    break;

                case 7 :
                    System.out.println("Nova transportadora :");
                    String novo_trans = sc.nextLine();
                    String alteraTrans = "UPDATE objetos SET transportadora = ? WHERE id = ?";
                    PreparedStatement stmttrans = conn.prepareStatement(alteraTrans);

                    stmttrans.setString(1, novo_trans);
                    stmttrans.setInt(2, id);
                    stmttrans.executeUpdate();
                    System.out.println("Alterado com sucesso");
                    break;

                case 8 :
                    System.out.println("Novo Status :");
                    String novo_status = sc.nextLine();
                    String alteraStatus = "UPDATE objetos SET status = ? WHERE id = ?";
                    PreparedStatement stmtstatus = conn.prepareStatement(alteraStatus);

                    stmtstatus.setString(1, novo_status);
                    stmtstatus.setInt(2, id);
                    stmtstatus.executeUpdate();
                    System.out.println("Alterado com sucesso");
                    break;

                case 9 :
                    System.out.println("Nova observação : ");
                    String novo_observa = sc.nextLine();
                    String alteraObserva = "UPDATE objetos SET observacoes = ? WHERE id = ?";
                    PreparedStatement stmtobserva = conn.prepareStatement(alteraObserva);

                    stmtobserva.setString(1, novo_observa);
                    stmtobserva.setInt(2, id);
                    stmtobserva.executeUpdate();
                    System.out.println("Alterado com sucesso");

                    break;

                default:
                    System.out.println("Você escolheu sair...");
            }

        }catch (Exception ez){
            ez.printStackTrace();
        }

    }
    public static void alterarFuncionario(int id){
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            java.sql.ResultSet rs = stmt.executeQuery();
            System.out.println("a "+ rs);

    }catch (Exception ez){
            ez.printStackTrace();
        }
    }
}
