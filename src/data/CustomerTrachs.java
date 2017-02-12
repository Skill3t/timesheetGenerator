/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lars
 */
public class CustomerTrachs implements Serializable{
    private ArrayList<TrackedTimeItem> customeritems = new ArrayList<TrackedTimeItem>() ;
    private String customername;

    public CustomerTrachs(String customername) {
        this.customername = customername;
    }

    public ArrayList<TrackedTimeItem> getCustomeritems() {
        return customeritems;
    }

    public String getCustomername() {
        return customername;
    }
    
    
}
