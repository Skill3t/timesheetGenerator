/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author Lars
 */
public class Export {

    private String path;


    public Export(String path) {
        this.path = path;
    }

    public boolean convert(ArrayList<String[]> exportData) throws IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + "/export2.csv"), "iso-8859-1"));
        if (exportData.get(0) == null) {
            return false;
        }
        try {
            for (String[] entry : exportData) {
                for (String text : entry) {
                    out.write(text);
                    if (!text.contentEquals(entry[entry.length - 1])) {
                        out.write(";");
                    }
                }
                out.write("\n");
                out.flush();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
