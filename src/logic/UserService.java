/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CRUDUser;
import entity.User;

/**
 *
 * @author Lars
 */
public class UserService {

    public String getTemplatePathByID(int id) {
        CRUDUser crudu = new CRUDUser();
        User userByID = crudu.getUserByID(id);
        return userByID.getTamplatePath();
    }

    public void setTemplatePathByID(int id, String path) {
        CRUDUser crudu = new CRUDUser();
        crudu.editUserByID(id,path);
    }
}
