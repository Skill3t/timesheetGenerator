/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CRUDCustomer;
import data.CRUDTrackedTimeItem;
import entity.Customer;
import entity.TrackedTimeItem;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Lars
 */
public class CustomerService {

    private TreeMap<String, Customer> allCustomers = new TreeMap<String, Customer>(String.CASE_INSENSITIVE_ORDER);

    public TreeMap<String, Customer> getAllCustomers() {
        allCustomers = new TreeMap<String, Customer>(String.CASE_INSENSITIVE_ORDER);
        CRUDCustomer CRUDCT = new CRUDCustomer();
        List<Customer> customerListe = CRUDCT.getCustomerListe();
        for (Customer CT : customerListe) {
            allCustomers.put(CT.getCustomername(), CT);
            CRUDTrackedTimeItem CRUDTTI = new CRUDTrackedTimeItem();
            List<TrackedTimeItem> trackedTimeItemListe = CRUDTTI.getTrackedTimeItemListe(CT.getId());
            for (TrackedTimeItem TTI : trackedTimeItemListe) {
                CT.getCustomeritems().put(TTI.getStartTimeS(), TTI);
            }
        }
        return allCustomers;
    }

    public int saveCustomer(Customer CT) {
        CRUDCustomer CRUDCT = new CRUDCustomer();
        Customer customerByID = CRUDCT.getCustomerByID(CT.getId());
        if (customerByID == null) { // neuer Customer
            return CRUDCT.insertCustomerTrack(CT);
        }else{
            return CRUDCT.editCustomerByID(CT.getId(), CT.getCustomername());
        }
    }

    public boolean removeCustomer(Customer CT) {
        CRUDCustomer CRUDCT = new CRUDCustomer();
        int anzahl = CRUDCT.deleteCustomerByID(CT.getId());
        if (anzahl == 1) {
            return true;
        } else {
            return false;

        }
    }

    public void removeAllTimeTracks() {
        CRUDCustomer CRUDCT = new CRUDCustomer();
        List<Customer> customerListe = CRUDCT.getCustomerListe();
        for (Customer CT : customerListe) {
            CRUDTrackedTimeItem CRUDTTI = new CRUDTrackedTimeItem();
            List<TrackedTimeItem> trackedTimeItemListe = CRUDTTI.getTrackedTimeItemListe(CT.getId());
            for (TrackedTimeItem TTI : trackedTimeItemListe) {
                CRUDTTI.deleteTrackedTimeItem(TTI.getId());
            }
        }
    }

}
