package ChallengeTehnic;

import java.sql.*;

/**
 *
 * @author Bogdan
 */
public class DBConnection {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/testul?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conn;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            try {
                conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Conectare esuata la baza de date.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        return conn;
    }
}
