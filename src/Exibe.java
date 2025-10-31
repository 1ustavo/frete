import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exibe {

    public static void exibeEncomenda(String nome) {
        String sql = "SELECT * FROM objetos WHERE nome_cliente LIKE ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();

            boolean achou = false;

            while (rs.next()) {
                achou = true;
                System.out.println("==== Encomenda ====");
                System.out.println("ID: " + rs.getInt("id"));
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

        } catch (Exception ez) {
            ez.printStackTrace();
        }
    }

    public static void exibeFuncionario(String nome) {
        String sqlFuncionario = "SELECT * FROM funcionarios WHERE nome LIKE ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmtFuncionario = conn.prepareStatement(sqlFuncionario)) {

            stmtFuncionario.setString(1, "%" + nome + "%");
            ResultSet rsFunc = stmtFuncionario.executeQuery();

            boolean achou = false;

            while (rsFunc.next()) {
                achou = true;
                int idFuncionario = rsFunc.getInt("id");

                System.out.println("=== Funcionário ===");
                System.out.println("ID: " + idFuncionario);
                System.out.println("Nome: " + rsFunc.getString("nome"));
                System.out.println("Email: " + rsFunc.getString("email"));
                System.out.println("Documento: " + rsFunc.getString("documento"));
                System.out.println("Idade: " + rsFunc.getInt("idade"));

                String sqlEncomendas = "SELECT * FROM objetos WHERE retirado_por = ?";
                try (PreparedStatement stmtEncomenda = conn.prepareStatement(sqlEncomendas)) {
                    stmtEncomenda.setInt(1, idFuncionario);
                    ResultSet rsEncomenda = stmtEncomenda.executeQuery();

                    System.out.println("📦 Encomendas atribuídas:");

                    boolean temEncomenda = false;
                    while (rsEncomenda.next()) {
                        temEncomenda = true;
                        System.out.println("  - ID: " + rsEncomenda.getInt("id")
                                + " | Cliente: " + rsEncomenda.getString("nome_cliente")
                                + " | Status: " + rsEncomenda.getString("status")
                                + " | Retirada: " + rsEncomenda.getTimestamp("data_retirada"));
                    }

                    if (!temEncomenda) {
                        System.out.println("  (Nenhuma encomenda retirada por este funcionário)");
                    }
                }
                System.out.println("====================\n");
            }

            if (!achou) {
                System.out.println("Nenhum funcionário encontrado com o nome: " + nome);
            }

        } catch (Exception ez) {
            ez.printStackTrace();
        }
    }
}