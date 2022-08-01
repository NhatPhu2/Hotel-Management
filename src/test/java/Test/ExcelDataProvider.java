/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;


/**
 *
 * @author Admin
 */
public class ExcelDataProvider {
    
    public static List<Integer> rows;
   
    public static Object[][] testData(File pathFile, String sheetName, String testCaseName) {
        rows = new ArrayList<>();
        ExcelUtils excel = new ExcelUtils(pathFile, sheetName);
        //lấy vị trí hàng theo testname
        int row = excel.getRowTestCaseName(testCaseName, 0);
        //số hàng của một testName
        int rowCount = excel.getRowCount(testCaseName, 0);
        //lấy toàn bộ cột trong file excel
        int colCount = excel.getColCount();
        Object[][] data = new Object[rowCount][colCount - 3];
        int index = 0;

        
        //nếu cellmergred khác 1 thì row hiện tại cộng 1
        for (int i = row - 1; i < (rowCount != 1 ? (row - 1) + rowCount : row); i++) {
            for (int j = 1; j < colCount - 2; j++) {
                int s = excel.checkTypeValue(i, j).getCellType();
                switch (s) {
                    case Cell.CELL_TYPE_STRING:
                        //kiểm tra kiểu dữ liệu
                        data[index][j - 1] = excel.getCellDataString(i, j);
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if(DateUtil.isCellDateFormatted(excel.checkTypeValue(i, j))){
                            data[index][j - 1] = excel.getCellDataDate(i, j);
                        }else
                            data[index][j - 1] = excel.getCellDataNumber(i, j);
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        data[index][j - 1] = excel.getCellDataBoolean(i, j);
                        break;
                    default:
                        break;
                }

            }
            rows.add(i);
            index++;
            
        }

        return data;
    }

}
