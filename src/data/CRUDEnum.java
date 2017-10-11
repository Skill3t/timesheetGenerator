/*
 * The MIT License
 *
 * Copyright 2017 Lars.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package data;

import dbcon.ConnectionSingelton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lars
 */
public class CRUDEnum {

    public HashMap<Integer, String> getIndustryListe() {
        try {
            HashMap<Integer, String> hmap = new HashMap<Integer, String>();
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            PreparedStatement ps = dbcon
                    .prepareStatement("SELECT * FROM industry");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("number");
                String user = rs.getString("description");
                hmap.put(number, user);
            }
            rs.close();
            ps.close();
            return hmap;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public HashMap<Integer, String> getCompanyStageListe() {
        try {
            HashMap<Integer, String> hmap = new HashMap<Integer, String>();
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            PreparedStatement ps = dbcon
                    .prepareStatement("SELECT * FROM companyStage");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("number");
                String user = rs.getString("description");
                hmap.put(number, user);
            }
            rs.close();
            ps.close();
            return hmap;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public HashMap<Integer, String> getChannelListe() {
        try {
            HashMap<Integer, String> hmap = new HashMap<Integer, String>();
            ConnectionSingelton cst = null;
            cst = ConnectionSingelton.getInstance();
            Connection dbcon = cst.getDbcon();
            PreparedStatement ps = dbcon
                    .prepareStatement("SELECT * FROM Channel");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int number = rs.getInt("number");
                String user = rs.getString("description");
                hmap.put(number, user);
            }
            rs.close();
            ps.close();
            return hmap;
        } catch (SQLException ex) {
            Logger.getLogger(CRUDCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
