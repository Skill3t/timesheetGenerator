/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CRUDCustomerTrack;
import entity.CustomerTracks;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Lars
 */
public class CustomerTracksService {

    private TreeMap<String, CustomerTracks> allCustomers = new TreeMap<String, CustomerTracks>(String.CASE_INSENSITIVE_ORDER);

    public TreeMap<String, CustomerTracks> getAllCustomers() {
        allCustomers = new TreeMap<String, CustomerTracks>(String.CASE_INSENSITIVE_ORDER);
        CRUDCustomerTrack CRUDCT = new CRUDCustomerTrack();
        List<CustomerTracks> customerListe = CRUDCT.getCustomerListe();
        for (CustomerTracks CT : customerListe) {
            allCustomers.put(CT.getCustomername(), CT);
        }
        return allCustomers;
    }
    
}
