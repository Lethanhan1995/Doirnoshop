/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advance.dev.data.driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDriver {

    final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    final String USER = "root";
    final String PASS = "";
    private static MySQLDriver instance;

    private MySQLDriver() {
    }

    public static MySQLDriver getInstance() {
        if (instance == null) {
            instance = new MySQLDriver();
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
