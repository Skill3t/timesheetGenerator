/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CRUDUser;
import entity.User;
import java.util.ArrayList;

/**
 *
 * @author Lars
 */
public class UserService {

    public String getTemplatePathByNumber(int id) {
        CRUDUser crudu = new CRUDUser();
        User userByID = crudu.getUserByNumber(id);
        return userByID.getTamplatePath();
    }

    public void setTemplatePathByNumber(int id, String path) {
        CRUDUser crudu = new CRUDUser();
        crudu.editUserByNumber(id, path);
    }

    public ArrayList<String> getUserNames() {
        CRUDUser crudu = new CRUDUser();
        ArrayList<String> userListe = crudu.getUserListe();
        return userListe;

    }
}
