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
    private int numer;
    private String name;
    private String tamplatePath;

    public User(int numer, String name, String tamplatePath) {
        this.numer = numer;
        this.name = name;
        this.tamplatePath = tamplatePath;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
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
