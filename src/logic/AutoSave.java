/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.AllTracks;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.*;

/**
 *
 * @author Lars
 */
public class AutoSave {
/*
    public boolean saved;

    private final ScheduledExecutorService scheduler
            = Executors.newScheduledThreadPool(1);

    public boolean autoSave() {    
        final Runnable saver = new Runnable() {
            @Override
            public void run() {
                System.out.println("saved");
                 save();

            }
        };

        final ScheduledFuture<?> saverHandle
                = scheduler.scheduleAtFixedRate(saver, 100, 100, SECONDS);
        return true;
    }

    public boolean save() {
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(System.getProperty("user.dir") + "/saveState");
            ObjectOutputStream o = new ObjectOutputStream(fos);
            AllTracks instance = AllTracks.getInstance();
            o.writeObject(instance.getAllCustomers());
            o.writeObject(instance.getTamplatePath());
            //o.writeObject(jLTemplatePath);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
*/
}
