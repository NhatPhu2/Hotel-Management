/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Test;

import com.UI.ThuePhongUI;
import java.io.File;
import java.util.Date;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author Admin
 */
public class ThuephongTest {

    public ThuephongTest() {
    }
    private boolean expected;
    File path = new File("E:\\testdata.xlsx");
    
    String sheet = "Thuê phòng";
    private ThuePhongUI thuePhong;
    ExcelUtils ex = new ExcelUtils(path, sheet);

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @DataProvider(name = "themDung")
    public Object[][] dataMatkhauSai() {

        Object data[][] = ExcelDataProvider.testData(path, sheet, "Thuê Phòng nhập đúng");
        return data;
    }

    int index = 0;

    @Test(dataProvider = "themDung")
    public void test1(String manv,
            String hoten,
            String CMND,
            Date ngaySinh,
            String diaChi,
            String soDT,
            Boolean gioiTinh,
            String soPhong,
            String soNgayThue) {
        expected = true;
        thuePhong.valueAdd(diaChi, hoten, CMND, soNgayThue, soDT, ngaySinh, soPhong, manv, gioiTinh);
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index));
        assertEquals(thuePhong.add(),expected);//hoặc dùng assertTrue
        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index));

        index++;
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        thuePhong = new ThuePhongUI();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        if (ExcelDataProvider.rows.size() - 1 < index) {
            index = 0;
        }

    }
}
