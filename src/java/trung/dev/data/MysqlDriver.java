package trung.dev.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDriver {

    final String DB_URL = "jdbc:mysql://localhost:3306/eshoper";
    final String USER = "root";
    final String PASS = "123456";
    private static MysqlDriver instance;

    private MysqlDriver() {
    }

    public static MysqlDriver getInstance() {
        if (instance == null) {
            instance = new MysqlDriver();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
