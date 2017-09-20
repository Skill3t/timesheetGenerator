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
import java.util.Date;
import java.util.List;
import entity.TrackedTimeItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lars
 */
public class CRUDTrackedTimeItem {

    public Integer insertTrackedTimeItem(TrackedTimeItem TTI, Integer CustomerID) throws SQLException, ClassNotFoundException {
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "INSERT INTO TrackedTimeItem ("
                + " id,"
                + " id_Customer,"
                + " kindOfAction,"
                + " startTime,"
                + " endTime,"
                + " kommand,"
                + " markInExport,"
                + ") VALUES ("
                + "null, ?,?,?,?,?,?)";

        try {
            // set all the preparedstatement parameters
            PreparedStatement ps = dbcon.prepareStatement(query);
            ps.setInt(1, CustomerID);
            ps.setString(2, TTI.getKindOfAction());
            ps.setInt(3, (int) TTI.getStartTime().getTime());
            ps.setInt(4, (int) TTI.getEndTime().getTime());
            ps.setString(5, TTI.getKommand());
            ps.setInt(6, TTI.getMyInt());
            int executeUpdate = ps.executeUpdate();
            ps.close();
            return executeUpdate;

        } catch (SQLException se) {
            // log exception
            throw se;
        }

    }
/*
    public CustomerTracks getCustomerByID(int id) throws SQLException, ClassNotFoundException {
        CustomerTracks ct = null;
        Connection dbcon = SQLiteCon.connect();
        String query = "SELECT * FROM Customer WHRE id = ?";
        PreparedStatement ps = dbcon
                .prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ct = new CustomerTracks(rs.getString("name"));
            ct.setId(rs.getInt("id"));
        }
        ps.close();
        dbcon.close();
        return ct;
    }

    public List<CustomerTracks> getCustomerListe() throws SQLException, ClassNotFoundException {
        List<CustomerTracks> customerListe = null;
        Connection dbcon = SQLiteCon.connect();
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
        ps.close();
        dbcon.close();
        return customerListe;
    }
*/
    /**
     * *
     *
     * @param id id of the Customer
     * @param name new name ot the Customer
     * @return -1 Customer did not exist 1 update sucsess
     * @throws SQLException
     * @throws ClassNotFoundException
     */
 /*   public int editCustomerByID(int id, String name) throws SQLException, ClassNotFoundException {
        CustomerTracks customerByID = getCustomerByID(id);
        if (customerByID == null) {
            return -1;
        }
        Connection dbcon = SQLiteCon.connect();

        String query = "UPDATE Customer SET name = ? WHERE id = ?";
        PreparedStatement ps = dbcon
                .prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, id);
        int executeUpdate = ps.executeUpdate();
        ps.close();
        dbcon.close();
        return executeUpdate;
    }

    public int deleteCustomerByID(int id) throws SQLException, ClassNotFoundException {
        Connection dbcon = SQLiteCon.connect();

        String query = "DELETE FROM Customer WHERE id = ?";
        PreparedStatement ps = dbcon
                .prepareStatement(query);
        ps.setInt(1, id);
        int executeUpdate = ps.executeUpdate();
        ps.close();
        dbcon.close();
        return executeUpdate;
    }*/
}
