/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Lars
 */
public class Export {

    private String newPath;
    private String templatePath;

    public Export(String path, String templatePath) {
        this.newPath = path;
        this.templatePath = templatePath;
    }

    public boolean convert(ArrayList<String[]> exportData) throws IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newPath + "/export2.csv"), "iso-8859-1"));
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

    public boolean convertXls() throws IOException {
        try {
            FileInputStream file = new FileInputStream(templatePath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet;
            Cell cell = null;
            ConvertData cd = new ConvertData();
            for (int i = 0; i < cd.getSheetnames().size(); i++) {
                workbook.cloneSheet(0, cd.sheetnames.get(i));
                sheet = workbook.getSheetAt(i + 1);
                cell = sheet.getRow(0).getCell(1);
                cell.setCellValue(cd.sheetnames.get(i));
                ArrayList<String[]> convert = cd.convert(cd.sheetnames.get(i));
                for (int Row = 0; Row < convert.size(); Row++) {
                    for (int Cell = 0; Cell < convert.get(Row).length; Cell++) {
                        cell = sheet.getRow(9 + Row).getCell(Cell + 1);
                        cell.setCellValue(convert.get(Row)[Cell]);
                    }
                }
            }

            file.close();

            FileOutputStream outFile = new FileOutputStream(new File(newPath + "/TimeSheetExport.xlsx"));
            workbook.write(outFile);
            outFile.close();
            file.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        return true;
    }
}
