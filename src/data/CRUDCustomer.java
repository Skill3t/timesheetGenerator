/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbcon.ConnectionSingelton;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lars
 */
public class CRUDCustomer {

    /**
     * *
     *
     * @param CT
     * @return Integer id of the new Customer -1 = error
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int insertCustomerTrack(Customer CT) {
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "INSERT INTO Customer ("
                + " id,"
                + " name"
                + ") VALUES ("
                + "null, ?)";

        try {
            // set all the preparedstatement parameters
            PreparedStatement ps = dbcon.prepareStatement(query);
            ps.setString(1, CT.getCustomername());

            int executeUpdate = ps.executeUpdate();
            ps.close();
            if (executeUpdate == 1) {
                Customer customerByName = this.getCustomerByName(CT.getCustomername());
                return customerByName.getId();
            } else {
                return -1;
            }

        } catch (SQLException se) {
            // log exception
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, se);
        }
        return -1;
    }

    public Customer getCustomerByID(int id) {
        Customer ct = null;
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "SELECT * FROM Customer WHERE id = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct = new Customer(rs.getString("name"));
                ct.setId(rs.getInt("id"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ct;
    }

    public Customer getCustomerByName(String name) {
        Customer ct = null;
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "SELECT * FROM Customer WHERE name = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ct = new Customer(rs.getString("name"));
                ct.setId(rs.getInt("id"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ct;
    }

    public List<Customer> getCustomerListe() {
        try {
            List<Customer> customerListe = new ArrayList<Customer>();
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            PreparedStatement ps = dbcon
                    .prepareStatement("SELECT * FROM Customer");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // item = new TrackedTimeItem();
                Customer CT = new Customer(rs.getString("name"));
                CT.setId(rs.getInt("id"));
                customerListe.add(CT);
            }
            rs.close();
            ps.close();
            return customerListe;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
        Customer customerByID = getCustomerByID(id);
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
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

}
