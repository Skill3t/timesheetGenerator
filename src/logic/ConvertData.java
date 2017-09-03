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
            retline = new String[7];

            Calendar cal = Calendar.getInstance();
            long time = tti.getStartTime().getTime();
            int itoMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(time);
            cal.setTimeInMillis((long) itoMinutes * 60 * 1000);

            retline[0] = "" + cal.get(Calendar.DAY_OF_MONTH) + "." + (cal.get(Calendar.MONTH) + 1) + "." + cal.get(Calendar.YEAR);
            retline[1] = String.format("%01d:%02d", cal.get(Calendar.HOUR_OF_DAY), +cal.get(Calendar.MINUTE));
            Calendar calolder = Calendar.getInstance();

            time = tti.getEndTime().getTime();
            itoMinutes = (int) TimeUnit.MILLISECONDS.toMinutes(time);
            calolder.setTimeInMillis((long) itoMinutes * 60 * 1000);

            retline[2] = String.format("%01d:%02d", calolder.get(Calendar.HOUR_OF_DAY), +calolder.get(Calendar.MINUTE));
            /*
            long diff = calolder.getTimeInMillis() - cal.getTimeInMillis();
            
            retline[3] = String.format("%02d", TimeUnit.MILLISECONDS.toMinutes(diff));
            long toMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
            long toHours = TimeUnit.MILLISECONDS.toHours(diff);
            long round = Math.round(((toMinutes / 60.0) - toHours) * 100);
            String houers = String.format("%01d,%02d",
                    toHours,
                    round);

            retline[4] = houers;
             */
            retline[3] = ""+tti.getMarkInExport();
            retline[4] = "";
            retline[5] = tti.getKindOfAction();
            retline[6] = tti.getKommand();
            allreturn.add(retline);

        }
        return allreturn;
    }
}
