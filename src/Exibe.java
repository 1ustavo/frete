import conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Exibe {
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
                System.out.println("ID :"+ rs.getInt("id"));
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

