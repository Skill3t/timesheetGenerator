/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lars
 */
public class ConnectionSingelton {
      // Eine (versteckte) Klassenvariable vom Typ der eigenen Klasse
    private static ConnectionSingelton instance;
    // Verhindere die Erzeugung des Objektes über andere Methoden

    private ConnectionSingelton() {
    }
    private static Connection dbcon;

    public static Connection getDbcon() {
        return dbcon;
    }
    
    // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes 
    // Objekt erzeugt und dieses zurückliefert.

    public static ConnectionSingelton getInstance() throws SQLException, ClassNotFoundException {
       
        if (ConnectionSingelton.instance == null) {
            ConnectionSingelton.instance = new ConnectionSingelton();
             dbcon = SQLiteCon.connect();
        }
        return ConnectionSingelton.instance;
    }
}
