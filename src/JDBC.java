import java.lang.reflect.Field;
import java.sql.*;
import java.util.Arrays;


public class JDBC {

    private static Connection initialize() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jogo_bicho?useSSL=false", "root", "");
            return conn;
        } catch (Exception error) {
            System.out.println("Error: " + error);
            throw new RuntimeException(error);
        }
    }

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

    public static void insert(Object object){
        Class<?> clazz = object.getClass();

        StringBuilder sql =  new StringBuilder();
        StringBuilder binders = new StringBuilder();

        binders.append(") VALUES ( null, ");
        sql.append("INSERT INTO tb_"+ clazz.getName().toLowerCase() + "(");

        Field[] objectProps = clazz.getDeclaredFields();

        for (int i = 0; i < objectProps.length; i++) {
            objectProps[i].setAccessible(true);
            String column = objectProps[i].getName();
            sql.append(column);

            if (i > 0) {
                binders.append("?");
            }

            if (i < objectProps.length-1){
                sql.append(", ");
                if (i > 0){
                    binders.append(", ");
                }
            }
        }

        sql.append(binders);
        sql.append(");");

        try {
            Connection conn = initialize();
            PreparedStatement stmt = conn.prepareStatement(sql.toString());

            for (int i = 1; i < objectProps.length; i++) {
                Object values = objectProps[i].get(object);
                stmt.setObject(i, values);
            }
            System.out.println(stmt);


            int resultSet = stmt.executeUpdate();

            if(resultSet > 0){
                System.out.println(object.toString());
                System.out.println(clazz.getName() + " cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar " + clazz.getName());
            }
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
