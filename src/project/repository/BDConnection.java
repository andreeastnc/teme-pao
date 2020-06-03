package project.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
    public static Connection getBDConnection()  {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spectacol", "root", "m7lc5w67");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeBDConnection(Connection connection)  {
        try {
            if(connection != null) {
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
