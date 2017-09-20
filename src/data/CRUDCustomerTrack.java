/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbcon.ConnectionSingelton;
import dbcon.SQLiteCon;
import entity.AllTracks;
import entity.CustomerTracks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lars
 */
public class CRUDCustomerTrack {

    public Integer insertCustomerTrack(CustomerTracks CT) throws SQLException, ClassNotFoundException {
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "INSERT INTO Customer ("
                + " id,"
                + " name,"
                + ") VALUES ("
                + "null, ?)";

        try {
            // set all the preparedstatement parameters
            PreparedStatement ps = dbcon.prepareStatement(query);
            ps.setString(1, CT.getCustomername());

            int executeUpdate = ps.executeUpdate();
            ps.close();
            return executeUpdate;

        } catch (SQLException se) {
            // log exception
            throw se;
        }

    }

    public CustomerTracks getCustomerByID(int id) {
        CustomerTracks ct = null;
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "SELECT * FROM Customer WHRE id = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct = new CustomerTracks(rs.getString("name"));
                ct.setId(rs.getInt("id"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomerTrack.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ct;
    }

    public List<CustomerTracks> getCustomerListe() {
        try {
            List<CustomerTracks> customerListe = null;
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            PreparedStatement ps = dbcon
                    .prepareStatement("SELECT * FROM Customer");
            ResultSet rs = ps.executeQuery();
            AllTracks instance = AllTracks.getInstance();

            while (rs.next()) {
                // item = new TrackedTimeItem();
                CustomerTracks CT = new CustomerTracks(rs.getString("name"));
                CT.setId(rs.getInt("id"));
                customerListe.add(CT);
                instance.addCustomer(CT);
            }
            rs.close();
            ps.close();
            return customerListe;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomerTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * *
     *
     * @param id id of the Customer
     * @param name new name ot the Customer
     * @return -1 Customer did not exist 1 update sucsess 0 Error
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int editCustomerByID(int id, String name) {
        CustomerTracks customerByID = getCustomerByID(id);
        if (customerByID == null) {
            return -1;
        }
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();

        String query = "UPDATE Customer SET name = ? WHERE id = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);
            int executeUpdate = ps.executeUpdate();
            ps.close();
            return executeUpdate;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomerTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int deleteCustomerByID(int id) {
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "DELETE FROM Customer WHERE id = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setInt(1, id);
            int executeUpdate = ps.executeUpdate();
            ps.close();
            return executeUpdate;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomerTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

}
