/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lars
 */
public class User {
    private int id;
    private String name;
    private String tamplatePath;

    public User(int id, String name, String tamplatePath) {
        this.id = id;
        this.name = name;
        this.tamplatePath = tamplatePath;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTamplatePath() {
        return tamplatePath;
    }

    public void setTamplatePath(String tamplatePath) {
        this.tamplatePath = tamplatePath;
    }
    
    
}
