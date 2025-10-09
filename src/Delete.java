import modelo.Encomendas;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete {
    public static int deleteEncomenda(int id){

        String sql = "DELETE FROM objetos WHERE id = ?";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Encomenda deletada com sucesso!");

        }catch (Exception ez){
            ez.printStackTrace();
        }
        return 0;
    }
}
