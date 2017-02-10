/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;

/**
 *
 * @author Lars
 */
public class AllTracks {

    private AllTracks exempla;
    private List allCustomers;

    private AllTracks() {
    }

    public AllTracks getInstance() {
        if (exempla == null) {
            exempla = new AllTracks();
            return exempla;
        } else {
            return exempla;
        }
    }

    public List getAllCustomers() {
        return allCustomers;
    }

    public void setAllCustomers(List allCustomers) {
        this.allCustomers = allCustomers;
    }
    
    

}
