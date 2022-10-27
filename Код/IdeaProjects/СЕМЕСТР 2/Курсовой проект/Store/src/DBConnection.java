import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private Connection connection;

    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1620_staff",
                    "std_1620_staff", "qwerty");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}