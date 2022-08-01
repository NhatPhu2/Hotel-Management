/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class ExcelUtils {

    XSSFWorkbook workBook;
    XSSFSheet sheet;
    XSSFRow mergedRow = null;
    XSSFCell mergedCell = null;
    XSSFRow rowBlank = null;
    XSSFCell cellBlank = null;

    public ExcelUtils(File pathFile, String sheetName) {
        try {
            FileInputStream file = new FileInputStream(pathFile);
            workBook = new XSSFWorkbook(file);
            sheet = workBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Cell checkTypeValue(int row, int cell) {
        return sheet.getRow(row).getCell(cell);
    }

    public int getRowCount() {
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public void updateExcel(File path, String result, int row)  {
        try {

            Cell cell = null;
            //Update the value of cell
            int lastCol = sheet.getRow(row).getLastCellNum() - 1;
            cell = sheet.getRow(row).getCell(lastCol);
            cell.setCellValue(result);
            FileOutputStream outFile = new FileOutputStream(path);
            workBook.write(outFile);
            outFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getColCount() {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return colCount;
    }

    public String getCellDataString(int rowNum, int colNum) {
        String cellData = "";
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellData;
    }

    public boolean getCellDataBoolean(int rowNum, int colNum) {
        boolean cellData = false;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getBooleanCellValue();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellData;
    }

    public double getCellDataNumber(int rowNum, int colNum) {
        double cellData = 0d;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellData;
    }

    public Date getCellDataDate(int rowNum, int colNum) {
        Date cellData = null;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getDateCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellData;
    }

    //trả về vị trí của testname
    public int getRowTestCaseName(String sTestCaseName, int colNum) {

        int i;
        int row = 0;
        try {

            int rowCount = getRowCount();
            for (i = 1; i < rowCount; i++) {
                mergedRow = sheet.getRow(i);
                mergedCell = mergedRow.getCell(0);

                //nếu hàng i cột 0 bằng testName được truyển vào
                if (mergedCell.getStringCellValue().equalsIgnoreCase(sTestCaseName)) {
                    row = i + 1;
                }
                rowBlank = sheet.getRow(row);
                cellBlank = rowBlank.getCell(0);
                //nếu hàng tiếp rỗng (ngĩa là testName đó đã được gộp lại thành 1)
                if (cellBlank.getCellTypeEnum() == CellType.BLANK && row != 0) {
                    row--;
                    row += 1;
                } else {
                    if (row != 0) {

                        break;
                    }
                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return row;
    }

    // trả về số hàng được gộp của testname
    public int getRowCount(String sTestCaseName, int colNum) {

        int i;
        int row = 0;
        int countRow = 0;
        int cellNotMergred = 0;
        try {

            int rowCount = getRowCount();
            for (i = 1; i < rowCount; i++) {
                mergedRow = sheet.getRow(i);
                mergedCell = mergedRow.getCell(0);

                if (mergedCell.getStringCellValue().equalsIgnoreCase(sTestCaseName)) {
                    row = i + 1;
                    countRow += 1;
                }

                if (sheet.getLastRowNum() >= row) {
                    rowBlank = sheet.getRow(row);
                    cellBlank = rowBlank.getCell(0);
                    if (cellBlank.getCellTypeEnum() == CellType.BLANK && row != 0) {
                        row += 1;
                        countRow += 1;

                    } else {
                        if (row != 0) {
                            cellNotMergred = 1;
                            break;
                        }
                    }
                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return (countRow == cellNotMergred ? cellNotMergred : countRow);
    }

}
