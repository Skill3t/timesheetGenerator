/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.AllTracks;
import data.CustomerTracks;
import data.TrackedTimeItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Lars
 */
public class ConvertData {

    ArrayList<String> sheetnames = new ArrayList();

    public ConvertData() {
        AllTracks instance = AllTracks.getInstance();
        Set set = instance.getAllCustomers().entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            CustomerTracks cusomer = (CustomerTracks) mentry.getValue();
            sheetnames.add(cusomer.getCustomername());
        }

    }

    public ArrayList<String> getSheetnames() {
        return sheetnames;
    }

    public ArrayList<String[]> convert(String customername) {
        AllTracks instance = AllTracks.getInstance();
        CustomerTracks ti = instance.getAllCustomers().get(customername);
        String[] retline;
        ArrayList<String[]> allreturn = new ArrayList();

        for (TrackedTimeItem tti : ti.getCustomeritems()) {
            retline = new String[8];

            Calendar cal = Calendar.getInstance();
            cal.setTime(tti.getStartTime());
            retline[0] = "" + cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
            retline[1] = String.format("%01d:%02d", cal.get(Calendar.HOUR_OF_DAY), +cal.get(Calendar.MINUTE));
            Calendar calolder = Calendar.getInstance();
            calolder.setTime(tti.getEndTime());
            retline[2] = String.format("%01d:%02d", calolder.get(Calendar.HOUR_OF_DAY), +calolder.get(Calendar.MINUTE));

            retline[3] = String.format("%02d", (((calolder.get(Calendar.HOUR_OF_DAY) - cal.get(Calendar.HOUR_OF_DAY)) * 60) + (calolder.get(Calendar.MINUTE) - cal.get(Calendar.MINUTE))));
   

            calolder.set(calolder.get(0), calolder.get(1), calolder.get(2), calolder.get(3), calolder.get(4), 0);
            cal.set(cal.get(0), cal.get(1), cal.get(2), cal.get(3), cal.get(4), 0);

            long diff = tti.getEndTime().getTime() - tti.getStartTime().getTime();

            String houers = String.format("%01d,%02d",
                    (TimeUnit.MILLISECONDS.toHours(diff)),
                    (((TimeUnit.MILLISECONDS.toMinutes(diff) * 100L) / 60L) % 100L));

            retline[4] = houers;
            retline[5] = ti.getCustomername();
            retline[6] = tti.getKindOfAction();
            retline[7] = tti.getKommand();
            allreturn.add(retline);

            /*
                  Calendar cal = Calendar.getInstance();
        java.util.Date now = new java.util.Date();
        cal.setTime(now);
        long diff = now.getTime() - createdDate.getTime();//as given
        String curTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(diff) % 24, TimeUnit.MILLISECONDS.toMinutes(diff) % 60, TimeUnit.MILLISECONDS.toSeconds(diff) % 60);
        return curTime;
             */
        }
        return allreturn;
    }
}
