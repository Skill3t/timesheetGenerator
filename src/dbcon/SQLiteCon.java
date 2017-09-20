/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;




/**
 *
 * @author Lars
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteCon {

    public static Connection connect() throws SQLException, ClassNotFoundException {
       Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+System.getProperty("user.dir") + "/test.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
