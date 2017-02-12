/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lars
 */
public class AllTracks {

    private static AllTracks exempla;
    private ArrayList<CustomerTrachs> allCustomers = new ArrayList<CustomerTrachs>();

    private AllTracks() {
    }

    public static AllTracks getInstance() {
        if (exempla == null) {
            exempla = new AllTracks();
            return exempla;
        } else {
            return exempla;
        }
    }

    public ArrayList<CustomerTrachs> getAllCustomers() {
        return allCustomers;
    }

    public void setAllCustomers(ArrayList<CustomerTrachs> allCustomers) {
        this.allCustomers = allCustomers;
    }
    
    

}
