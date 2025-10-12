import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Alterar {
    public static void alterarEncomenda(int id){
        Scanner sc = new Scanner(System.in);
        String sql = "SELECT * FROM objetos WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            java.sql.ResultSet rs = stmt.executeQuery();

            if (!rs.next()){
                System.out.println("Encomenda não encontrado");
                return;
            }
            System.out.println("==== Encomendas ====");
            System.out.println("1 - Codigo " + rs.getString("codigo"));
            System.out.println("2 - Nome Cliente " + rs.getString("nome_cliente"));
            System.out.println("3 - Phone " + rs.getString("telefone"));
            System.out.println("4 - Documento rg/cpf" + rs.getString("documento"));
            System.out.println("5 - Descrição " + rs.getString("descricao"));
            System.out.println("6 - Transportadora " + rs.getString("transportadora"));
            System.out.println("7 - Status " + rs.getString("status"));
            System.out.println("8 - Observação " + rs.getString("observacoes"));
            System.out.println("=====================");
            System.out.println("Qual campo deja alterar : ");
            int opcao = sc.nextInt();
            sc.nextLine();
            String campo = switch (opcao){
                case 1 -> "codigo";
                case 2 -> "nome_cliente";
                case 3 -> "telefone";
                case 4 -> "documento";
                case 5 -> "descricao";
                case 6 -> "transportadora";
                case 7 -> "status";
                case 8 -> "observacoes";
                default -> null;
            };

            if (campo == null){
                System.out.println("Opção inválida!");
                return;
            }
            System.out.println("Novo valor :");
            String novoValor = sc.nextLine();

            String update = "UPDATE objetos SET " + campo + " = ? WHERE id = ?";
            try (PreparedStatement up = conn.prepareStatement(update)){
                up.setString(1, novoValor);
                up.setInt(2, id);
                up.executeUpdate();
                System.out.println("Alterado com sucesso!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void alterarFuncionario(int id){
        Scanner sc = new Scanner(System.in);
        String sql = "SELECT * FROM funcionarios WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            java.sql.ResultSet rs = stmt.executeQuery();

            if (!rs.next()){
                System.out.println("Funcionario não encontrado!");
                return;
            }
            System.out.println("==== Funcionário ====");
            System.out.println("1 - Nome: " + rs.getString("nome"));
            System.out.println("2 - Email: " + rs.getString("email"));
            System.out.println("3 - Documento: " + rs.getString("documento"));
            System.out.println("4 - Senha: " + rs.getString("senha"));
            System.out.println("5 - Idade: " + rs.getInt("idade"));
            System.out.println("=====================");
            System.out.print("Qual campo deseja alterar: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            String campo = switch (opcao) {
                case 1 -> "nome";
                case 2 -> "email";
                case 3 -> "documento";
                case 4 -> "senha";
                case 5 -> "idade";
                default -> null;
            };

            if (campo == null) {
                System.out.println("Opção inválida!");
                return;
            }

            System.out.print("Novo valor: ");
            String novoValor = sc.nextLine();

            String update = "UPDATE funcionarios SET " + campo + " = ? WHERE id = ?";
            try (PreparedStatement up = conn.prepareStatement(update)) {
                up.setString(1, novoValor);
                up.setInt(2, id);
                up.executeUpdate();
                System.out.println("Alterado com sucesso!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}