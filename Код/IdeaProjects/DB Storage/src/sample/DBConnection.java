package sample;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    private final String host = "std-mysql.ist.mospolytech.ru";
    private final String port = "3306";
    private final String name = "std_1607_sklad_3";
    private final String login = "std_1607_sklad_3";
    private final String password = "12345678";

    private Connection connection = null;

    // Метод для подключения к БД с использованием значений выше
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + host + ":" + port + "/" + name;
        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(connStr, login, password);
        return connection;
    }

    public ArrayList<String> getSchedule() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Clients";

        Statement statement = getConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> tasks = new ArrayList<>();
        while(res.next())
            tasks.add(res.getString("bank_details"));

        return tasks;
    }

    public ArrayList<String> getDBСlients() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Clients";

        Statement statement = getConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        ArrayList<String> tasks = new ArrayList<>();
        while(res.next())
            tasks.add(res.getString("Number"));

        return tasks;
    }

    void loadInfo() {
        try {
// Сначала очищаем от прошлых значений
            all_tasks.getChildren().clear();

// Получаем все задания из базы данных
            ArrayList<String> tasks = db.getSchedule();
            for(int i = 0; i < tasks.size(); i++) // Перебираем их через цикл
// Добавляем каждое задание в объект VBox (all_tasks)
                all_tasks.getChildren().add( new Label( tasks.get(i)));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}