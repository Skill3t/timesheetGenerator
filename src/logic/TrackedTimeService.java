/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CRUDTrackedTimeItem;
import entity.Customer;
import entity.TrackedTimeItem;

/**
 *
 * @author Lars
 */
public class TrackedTimeService {

    public boolean updateTrackedTime(TrackedTimeItem TTI) {
        CRUDTrackedTimeItem CRUDTTI = new CRUDTrackedTimeItem();
        int editTrackedTimeItem = CRUDTTI.editTrackedTimeItem(TTI);
        if (editTrackedTimeItem == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean removeTrackedTime(TrackedTimeItem TTI) {
        CRUDTrackedTimeItem CRUDTTI = new CRUDTrackedTimeItem();
        int editTrackedTimeItem = CRUDTTI.deleteTrackedTimeItem(TTI.getId());
        if (editTrackedTimeItem == 1) {
            return true;
        } else {
            return false;
        }
    }

}
