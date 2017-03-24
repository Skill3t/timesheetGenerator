/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Lars
 */
public class CustomerTracks implements Serializable{
    private ArrayList<TrackedTimeItem> customeritems = new ArrayList<TrackedTimeItem>() ;
    private String customername;

    public CustomerTracks(String customername) {
        this.customername = customername;
    }

    public ArrayList<TrackedTimeItem> getCustomeritems() {
        return customeritems;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomeritems(ArrayList<TrackedTimeItem> customeritems) {
        this.customeritems = customeritems;
    }
    
    
    @Override
    public String toString() {
        // then you can avoid using toString
        return customername;
    }
    
}
