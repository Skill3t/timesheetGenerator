/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dbcon.ConnectionSingelton;
import dbcon.SQLiteCon;
import java.util.Date;
import java.util.List;
import entity.TrackedTimeItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lars
 */
public class CRUDTrackedTimeItem {

    public TrackedTimeItem getTrackedTimeItemByID(int tid) throws SQLException, ClassNotFoundException {
        TrackedTimeItem item = null;
        Connection dbcon = SQLiteCon.connect();
        PreparedStatement ps = dbcon
                .prepareStatement("SELECT * FROM task WHERE id=?");
        ps.setInt(1, tid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
           // item = new TrackedTimeItem();
            System.out.println(rs.getString(1) + "\n" + rs.getString(2));
        }
        ps.close();
        dbcon.close();
        return item;
    }
/*
    public List<TrackedTimeItem> getSachListe() {
        List<Sachbearbeiter> sachListe = null;
        Query q = em.createNativeQuery("SELECT * FROM Sachbearbeiter", Sachbearbeiter.class);
        sachListe = q.getResultList();
        return sachListe;
    }

    @Override
    public boolean insertSach(Sachbearbeiter sach) {
        boolean status = false;
        if (sach.getSid() == null) {
            em.persist(sach);
            status = true;
        }
        return status;
    }

    @Override
    public boolean editSach(Sachbearbeiter sach) {
        boolean status = false;

        sach = em.find(Sachbearbeiter.class, sach.getSid());
        if (sach == null) {
            return false;
        }

        String name = null;
        String vorname = null;
        Integer nsid = null;
        Date geburtsdatum = null;
        List<Antrag> antragList = null;
        String geschlecht = null;
        String telefon = null;

        sach.getSid();
        sach.getTitel();
        sach.getVorname();
        sach.getName();
        sach.getGeschlecht();
        sach.getTelefon();
        sach.getGeburtsdatum();
        sach.getAbteilung();
        sach.getAdresse();
        sach.getAntragList();

        //sach.setSid(nsid);
        sach.setTitel(name);
        sach.setVorname(vorname);
        sach.setName(name);
        sach.setGeschlecht(geschlecht);
        sach.setTelefon(telefon);
        sach.setGeburtsdatum(geburtsdatum);
        sach.setAbteilung(name);
        sach.setAdresse(vorname);
        sach.setAntragList(antragList);

        em.merge(sach);
        status = true;
        return status;
    }

    @Override
    public boolean deleteSach(int sid) {
        Sachbearbeiter sach = em.find(Sachbearbeiter.class, sid);
        if (sach != null) {
            em.remove(sach);
            return true;
        }
        return false;
    }*/
}
