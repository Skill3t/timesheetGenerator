/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lars
 */
public class TrackedTimeItem implements Serializable{

    private Date startTime;
    private Date endTime;
    private String kommand;
    private String kindOfAction;

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getKommand() {
        return kommand;
    }

    public String getKindOfAction() {
        return kindOfAction;
    }
    

    public TrackedTimeItem(Date startTime, Date endTime, String kommand, String kindOfAction) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.kommand = kommand;
        this.kindOfAction = kindOfAction;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setKommand(String kommand) {
        this.kommand = kommand;
    }

    public void setKindOfAction(String kindOfAction) {
        this.kindOfAction = kindOfAction;
    }

    @Override
    public String toString() {
        // then you can avoid using toString
        return kommand;
    }

}
