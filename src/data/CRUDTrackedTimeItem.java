/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbcon.ConnectionSingelton;
import java.util.Date;
import java.util.List;
import entity.TrackedTimeItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author Lars
 */
public class CRUDTrackedTimeItem {

    public Integer insertTrackedTimeItem(TrackedTimeItem TTI, Integer CustomerID) {
        try {
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            String query = "INSERT INTO TrackedTimeItem ("
                    + " id,"
                    + " id_Customer,"
                    + " kindOfAction,"
                    + " startTime,"
                    + " endTime,"
                    + " kommand,"
                    + " markInExport"
                    + ") VALUES ("
                    + "null, ?,?,?,?,?,?)";

            // set all the preparedstatement parameters
            PreparedStatement ps = dbcon.prepareStatement(query);

            ps.setInt(1, CustomerID);
            ps.setString(2, TTI.getKindOfAction());
            ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(TTI.getEndTime().getTime()),
                    ZoneId.systemDefault());
            ps.setString(3, zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(TTI.getStartTime().getTime()),
                    ZoneId.systemDefault());
            ps.setString(4, zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            ps.setString(5, TTI.getKommand());
            int aint;
            if (TTI.getMarkInExport()) {
                aint = 1;
            } else {
                aint = 0;
            }
            ps.setInt(6, aint);
            int executeUpdate = ps.executeUpdate();
            ps.close();
            return executeUpdate;

        } catch (SQLException ex) {
            // log exception
            Logger.getLogger(CRUDCustomerTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<TrackedTimeItem> getTrackedTimeItemListe(int CustomerID) {
        try {
            List<TrackedTimeItem> ListTTI = new ArrayList<TrackedTimeItem>();
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            PreparedStatement ps = dbcon
                    .prepareStatement("SELECT * FROM TrackedTimeItem WHERE id_Customer = ?");
            ps.setInt(1, CustomerID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // item = new TrackedTimeItem();
                int aInt = rs.getInt("markInExport");
                boolean b;
                if (aInt == 0) {
                    b = false;
                } else {
                    b = true;
                }
                Calendar parseDateTime = javax.xml.bind.DatatypeConverter.parseDateTime(rs.getString("startTime"));
                Date startTime = parseDateTime.getTime();
                parseDateTime = javax.xml.bind.DatatypeConverter.parseDateTime(rs.getString("endTime"));
                Date endTime = parseDateTime.getTime();
                TrackedTimeItem TTI = new TrackedTimeItem(startTime, endTime, rs.getString("kommand"), rs.getString("kindOfAction"), b);
                TTI.setId(rs.getInt("id"));
                ListTTI.add(TTI);
            }
            rs.close();
            ps.close();
            return ListTTI;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomerTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*
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
    public int editTrackedTimeItem(TrackedTimeItem TTI) {

        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();

        String query = "UPDATE TrackedTimeItem SET kindOfAction = ?, startTime = ?, endTime = ?, kommand = ? , markInExport = ? WHERE id = ?";
        PreparedStatement ps;
        try {
            ps = dbcon
                    .prepareStatement(query);
            ps.setString(1, TTI.getKindOfAction());
            ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(TTI.getStartTime().getTime()),
                    ZoneId.systemDefault());
            ps.setString(2, zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(TTI.getEndTime().getTime()),
                    ZoneId.systemDefault());
            ps.setString(3, zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            ps.setString(4, TTI.getKommand());
            int aint;
            if (TTI.getMarkInExport()) {
                aint = 1;
            } else {
                aint = 0;
            }
            ps.setInt(5, aint);
            ps.setInt(6, TTI.getId());
            int executeUpdate = ps.executeUpdate();
            ps.close();
            return executeUpdate;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomerTrack.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public int deleteTrackedTimeItem(int id) {
        ConnectionSingelton cst = ConnectionSingelton.getInstance();
        Connection dbcon = cst.getDbcon();
        String query = "DELETE FROM TrackedTimeItem WHERE id = ?";
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
