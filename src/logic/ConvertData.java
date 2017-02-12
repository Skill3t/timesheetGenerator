/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.AllTracks;
import data.CustomerTrachs;
import data.TrackedTimeItem;
import java.util.ArrayList;

/**
 *
 * @author Lars
 */
public class ConvertData {

    public ArrayList<String> convert() {
        AllTracks instance = AllTracks.getInstance();
        String[] retline;
        ArrayList<String[]> allreturn = new ArrayList<String[]>();
    
        for (CustomerTrachs ti :instance.getAllCustomers()){
            ArrayList<TrackedTimeItem> customeritems = ti.getCustomeritems();
            
        }
        return null;
    }
}
