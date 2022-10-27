import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection connection;

    public DBConnection() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Storage",
                    "root", "rosebud5600");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}