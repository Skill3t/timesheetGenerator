/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Lars
 */
public class TrackedTimeItem implements Serializable {
    private int id;
    private Date startTime;
    private Date endTime;
    private String kommand;
    private String kindOfAction;
    private Boolean markInExport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
   
    
    
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

    public Boolean getMarkInExport() {
        return markInExport;
    }

    public Long getStartTimeS() {
        long time = this.getStartTime().getTime();
        return time;
    }

    public void setMarkInExport(Boolean markInExport) {
        this.markInExport = markInExport;
    }

    public TrackedTimeItem(Date startTime, Date endTime, String kommand, String kindOfAction, boolean markInExport) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.kommand = kommand;
        this.kindOfAction = kindOfAction;
        this.markInExport = markInExport;
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
        Calendar cal = Calendar.getInstance();
        long time = this.getStartTime().getTime();
        int itoMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(time);
        cal.setTimeInMillis((long) itoMinutes * 60 * 1000);
        String Sdate = "" + cal.get(Calendar.DAY_OF_MONTH) + "." + (cal.get(Calendar.MONTH) + 1) + "." + cal.get(Calendar.YEAR);
        long diff = this.getEndTime().getTime() - this.getStartTime().getTime();
        long toMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        long toHours = TimeUnit.MILLISECONDS.toHours(diff);
        long round = Math.round(((toMinutes / 60.0) - toHours) * 100);
        String houers = String.format("%01d,%02d",
                toHours,
                round);
        // then you can avoid using toString
        return Sdate + "    " + kommand + "    " + houers;
    }

}
