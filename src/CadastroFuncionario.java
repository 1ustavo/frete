import modelo.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroFuncionario {

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
}
