/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbcon.ConnectionSingelton;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lars
 */
public class CRUDUser {

    public User getUserByNumber(int number) {
        User user = null;
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "SELECT * FROM User WHERE number = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setInt(1, number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("number"), rs.getString("name"), rs.getString("tamplatePath"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    public int editUserByNumber(int number, String path) {
        User customerByID = getUserByNumber(number);
        if (customerByID == null) {
            return -1;
        }
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();

        String query = "UPDATE User SET tamplatePath = ? WHERE numer = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setString(1, path);
            ps.setInt(2, number);
            int executeUpdate = ps.executeUpdate();
            ps.close();
            return executeUpdate;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
    
        public ArrayList<String> getUserListe() {
        try {
            ArrayList<String> useres = new ArrayList<String>();
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            PreparedStatement ps = dbcon
                    .prepareStatement("SELECT name FROM User");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String user = rs.getString("name");
                useres.add(user);
            }
            rs.close();
            ps.close();
            return useres;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
