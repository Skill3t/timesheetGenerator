/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author Lars
 */
public class TrackedTimeItem {
    private Date startTime;
    private Date endTime;
    private String kommand;

    public Date getStartTime() {
        return startTime;
    }

    public TrackedTimeItem(Date startTime, Date endTime, String kommand) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.kommand = kommand;
    }
    
    
}
