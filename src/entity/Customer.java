/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Lars
 */
public class Customer implements Serializable {
    public static final String IDENTIFIER = "entity.Customer";
    private TreeMap<Long, TrackedTimeItem> customeritems = new TreeMap<Long, TrackedTimeItem>();
    private int id;
    private String customername;
    private int industryNumber;
    private int companyStageNumber;
    private int Channel;
    private boolean internal;

    public Customer(String customername) {
        this.customername = customername;    
    }

    public Customer(String customername, int industryNumber, int companyStageNumber, int Channel, boolean internal) {
        this.customername = customername;
        this.industryNumber = industryNumber;
        this.companyStageNumber = companyStageNumber;
        this.Channel = Channel;
        this.internal = internal;
    }
    
    
    public String getCustomername() {
        return customername;
    }

    public TreeMap<Long, TrackedTimeItem> getCustomeritems() {
        return customeritems;
    }

    public void setCustomeritems(TreeMap<Long, TrackedTimeItem> customeritems) {
        this.customeritems = customeritems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public int getIndustryNumber() {
        return industryNumber;
    }

    public void setIndustryNumber(int industryNumber) {
        this.industryNumber = industryNumber;
    }

    public int getCompanyStageNumber() {
        return companyStageNumber;
    }

    public void setCompanyStageNumber(int companyStageNumber) {
        this.companyStageNumber = companyStageNumber;
    }
    public int getChannel() {
        return Channel;
    }

    public void setChannel(int Channel) {
        this.Channel = Channel;
    }

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    
    @Override
    public String toString() {
        // then you can avoid using toString
        long difftotal = 0;
        for (Map.Entry<Long, TrackedTimeItem> items : customeritems.entrySet()) {
            difftotal = difftotal + items.getValue().getEndTime().getTime() - items.getValue().getStartTime().getTime();

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
