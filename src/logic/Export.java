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
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Lars
 */
public class Export {

    private JFileChooser newPath;
    private String templatePath;

    public Export(JFileChooser path, String templatePath) {
        this.newPath = path;
        this.templatePath = templatePath;
    }

    public boolean convertXls() throws IOException, FileNotFoundException, IllegalArgumentException, ParseException {
        FileInputStream tamplateFile = new FileInputStream(templatePath);
        XSSFWorkbook workbook = new XSSFWorkbook(tamplateFile);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("#,##"));
        double hours = 0.0;
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number;
        XSSFSheet sheet;
        XSSFSheet sheet2;
        Cell cell = null;
        ConvertData cd = new ConvertData();
        for (int i = 0; i < cd.getSheetnames().size(); i++) {
            sheet2 = workbook.cloneSheet(0, cd.sheetnames.get(i));
            sheet = workbook.getSheetAt(i + 1);
            //formate sheets
            sheet.getPrintSetup().setLandscape(true);
            sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);

            cell = sheet.getRow(0).getCell(1);
            cell.setCellValue(cd.sheetnames.get(i));
            ArrayList<String[]> convert = cd.convert(cd.sheetnames.get(i));
            for (int Row = 0; Row < convert.size(); Row++) {
                workbook.setPrintArea(
                        i + 1, //sheet index
                        0, //start column Spalte
                        9, //end column
                        0, //start row zeile
                        convert.size() + 8 //end row
                );
                for (int Cell = 0; Cell < convert.get(Row).length; Cell++) {
                    cell = sheet.getRow(9 + Row).getCell(Cell + 1);
                    cell.setCellValue(convert.get(Row)[Cell]);
                }
            }
        }

        workbook.removeSheetAt(0);
        tamplateFile.close();
        File exportFile = newPath.getSelectedFile();
        if (FilenameUtils.getExtension(exportFile.getName()).equalsIgnoreCase("xlsx")) {

        } else {
            exportFile = new File(exportFile.getParentFile(), FilenameUtils.getBaseName(exportFile.getName()) + ".xlsx");
        }

        FileOutputStream outFile = new FileOutputStream(exportFile);
        workbook.write(outFile);
        outFile.close();
        tamplateFile.close();
        return true;

    }

    public boolean convertXls2() throws IOException, FileNotFoundException, IllegalArgumentException, ParseException {
        FileInputStream tamplateFile = new FileInputStream(templatePath);
        XSSFWorkbook workbook = new XSSFWorkbook(tamplateFile);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("#,##"));
        double hours = 0.0;
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number;
        XSSFSheet sheet;
        XSSFSheet sheet2;
        Cell cell = null;
        ConvertData cd = new ConvertData();
        for (int i = 0; i < cd.getSheetnames().size(); i++) {
            sheet2 = workbook.cloneSheet(0, cd.sheetnames.get(i));
            sheet = workbook.getSheetAt(i + 1);
            cell = sheet.getRow(0).getCell(1);
            cell.setCellValue(cd.sheetnames.get(i));
            ArrayList<String[]> convert = cd.convert(cd.sheetnames.get(i));
            for (int Row = 0; Row < convert.size(); Row++) {
                for (int Cell = 0; Cell < convert.get(Row).length; Cell++) {
                    cell = sheet.getRow(9 + Row).getCell(Cell + 1);
                    String name;
                    switch (Cell) {
                        case 3:
                            name = convert.get(Row)[Cell];
                            int parseInt = Integer.parseInt(name);
                            cell.setCellValue(parseInt);
                            cell.setCellType(CellType.NUMERIC);
                            break;
                        case 4:
                            number = format.parse(convert.get(Row)[Cell]);
                            cell.setCellValue(number.doubleValue());
                            //  cell.setCellStyle(cellStyle);
                            cell.setCellType(CellType.NUMERIC);

                            break;
                        default:
                            cell.setCellValue(convert.get(Row)[Cell]);
                            break;
                    }
                }
            }

            for (String[] sa : convert) {
                number = format.parse(sa[4]);
                hours = hours + number.doubleValue();
            }
            cell = sheet.getRow(6).getCell(5);
            cell.setCellValue(hours);
            cell = sheet.getRow(2).getCell(8);
            XSSFCell cellHourlyRate = sheet.getRow(1).getCell(8);
            double numericCellValue = cellHourlyRate.getNumericCellValue();
            cell.setCellValue(hours * numericCellValue);
        }
        workbook.removeSheetAt(0);
        tamplateFile.close();
        File exportFile = newPath.getSelectedFile();
        if (FilenameUtils.getExtension(exportFile.getName()).equalsIgnoreCase("xlsx")) {

        } else {
            exportFile = new File(exportFile.getParentFile(), FilenameUtils.getBaseName(exportFile.getName()) + ".xlsx");
        }

        FileOutputStream outFile = new FileOutputStream(exportFile);
        workbook.write(outFile);
        outFile.close();
        tamplateFile.close();
        return true;

    }
}
