/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.AllTracks;
import data.CustomerTrachs;
import data.TrackedTimeItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
            CustomerTrachs cusomer = (CustomerTrachs) mentry.getValue();
            sheetnames.add(cusomer.getCustomername());
        }

    }

    public ArrayList<String> getSheetnames() {
        return sheetnames;
    }

    public ArrayList<String[]> convert(String customername) {
        AllTracks instance = AllTracks.getInstance();
        CustomerTrachs ti = instance.getAllCustomers().get(customername);
        String[] retline;
        ArrayList<String[]> allreturn = new ArrayList();

        for (TrackedTimeItem tti : ti.getCustomeritems()) {
            retline = new String[8];

            Calendar cal = Calendar.getInstance();
            cal.setTime(tti.getStartTime());
            retline[0] = "" + cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
            retline[1] = "" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);
            cal.setTime(tti.getEndTime());
            retline[2] = "" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);
            retline[3] = "";
            retline[4] = "";
            retline[5] = ti.getCustomername();
            retline[6] = tti.getKindOfAction();
            retline[7] = tti.getKommand();
            allreturn.add(retline);
        }
        return allreturn;
    }
}
