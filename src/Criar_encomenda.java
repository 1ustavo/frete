import modelo.Encomendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Criar_encomenda {
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

    }catch (Exception error){
        error.printStackTrace();
    }
    }

}
