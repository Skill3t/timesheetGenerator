/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
        long difftotal = 0;
        for (TrackedTimeItem items : customeritems) {
            difftotal = difftotal + items.getEndTime().getTime() - items.getStartTime().getTime();

        }
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(difftotal);
        long toHours = TimeUnit.MILLISECONDS.toHours(difftotal);
        long round = Math.round(((toMinutes / 60.0) - toHours) * 100);
        String houers = String.format("%01d,%02d",
                toHours,
                round);
        return customername + "  (" + houers + ")";
    }

}
