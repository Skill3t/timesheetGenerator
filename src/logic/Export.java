/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;

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

    public boolean convertXls() throws IOException, FileNotFoundException, IllegalArgumentException {
        FileInputStream file = new FileInputStream(templatePath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet;
        XSSFSheet sheet2;
        Cell cell = null;
        ConvertData cd = new ConvertData();
        for (int i = 0; i < cd.getSheetnames().size(); i++) {
            sheet2 = workbook.cloneSheet(0, cd.sheetnames.get(i));
            System.out.println(sheet2.getSheetName());
            sheet = workbook.getSheetAt(i + 1);
            cell = sheet.getRow(0).getCell(1);
            cell.setCellValue(cd.sheetnames.get(i));
            ArrayList<String[]> convert = cd.convert(cd.sheetnames.get(i));
            for (int Row = 0; Row < convert.size(); Row++) {
                for (int Cell = 0; Cell < convert.get(Row).length; Cell++) {
                    if (Cell == 3 || Cell == 4){
                        continue;
                    }
                    cell = sheet.getRow(9 + Row).getCell(Cell + 1);
                    cell.setCellValue(convert.get(Row)[Cell]);
                }
            }
        }
        workbook.removeSheetAt(0);
        file.close();

        FileOutputStream outFile = new FileOutputStream(new File(newPath));
        workbook.write(outFile);
        outFile.close();
        file.close();
        return true;

    }
}
