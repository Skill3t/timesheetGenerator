/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbcon.SQLiteCon;
import entity.CustomerTracks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lars
 */
public class CRUDCustomerTrack {
        public List<CustomerTracks> getCustomerListe() throws SQLException, ClassNotFoundException {
        List<CustomerTracks> customerListe = null;
         Connection dbcon = SQLiteCon.connect();
        PreparedStatement ps = dbcon
                .prepareStatement("SELECT * FROM Mandanten");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           // item = new TrackedTimeItem();
            System.out.println(rs.getString(1) + "\n" + rs.getString(2));
        }
        ps.close();
        dbcon.close();
        return customerListe;
    }

}
