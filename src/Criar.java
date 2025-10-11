import modelo.Encomendas;
import modelo.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Criar {

    public void salvarFuncionario(Funcionarios f){

    String sql = "INSERT INTO funcionarios (nome, email, documento, senha, idade) VALUES (?, ?, ?, ?, ?)";
    try(Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)){

        stmt.setString(1, f.nome);
        stmt.setString(2, f.email);
        stmt.setString(3, f.documento);
        stmt.setString(4, f.senha);
        stmt.setInt(5, f.idade);
        stmt.executeUpdate();
        System.out.println("✅ Encomenda salva com sucesso!");
    }catch (SQLException ez){
        ez.printStackTrace();
    }

    }
    public void salvarEncomenda(Encomendas e){
        String sql = "INSERT INTO objetos (codigo, nome_cliente, telefone, email, documento, descricao, transportadora, status, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, e.codigo);
            stmt.setString(2, e.nome_cliente);
            stmt.setString(3, e.telefone);
            stmt.setString(4, e.email);
            stmt.setString(5, e.documento);
            stmt.setString(6, e.descricao);
            stmt.setString(7, e.transportadora);
            stmt.setString(8, e.status);
            stmt.setString(9, e.observacoes);

            stmt.executeUpdate();
            System.out.println("✅ Encomenda salva com sucesso!");

        }catch (Exception ez){
            ez.printStackTrace();
        }
    }
}
