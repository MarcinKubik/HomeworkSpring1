package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/homeworkSpring1?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "coderslab";


    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

    }
}
