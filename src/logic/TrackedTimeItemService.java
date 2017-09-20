/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CRUDTrackedTimeItem;
import entity.TrackedTimeItem;

/**
 *
 * @author Lars
 */
public class TrackedTimeItemService {
    public void saveTrack(TrackedTimeItem TTI, Integer CustomerID){
        CRUDTrackedTimeItem CRUD = new CRUDTrackedTimeItem();
        CRUD.insertTrackedTimeItem(TTI, CustomerID);
        
    }
}
