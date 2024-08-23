import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBC {

    public static void testJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo_bicho?useSSL=false", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM tb_apostador");

            while (resultSet.next()){
                System.out.println(resultSet.getInt("id_apostador") + " - " + resultSet.getString("nome"));
            }
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }
}
