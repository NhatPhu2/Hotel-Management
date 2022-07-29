/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Test;

import com.UI.ThuePhongUI;
import java.util.Date;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Admin
 */
public class ThuephongTest {

    public ThuephongTest() {
    }
    private String actualResult;
    private String expected;
    String path = "E:\\testdata.xlsx";
    String sheet = "Thuê phòng";
    private ThuePhongUI thuePhong;

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

        Object data[][] = ExcelDataProvider.testData(path, sheet, "Thêm nhân viên bằng tài khoản Admin với đầy đủ thông tin");
        return data;
    }
    
    @Test(dataProvider = "themDung")
    public void test1(String manv,
                      String hoten,
                      String CMND,
                      Date ngaySinh,
                      String diaChi,
                      String soDT,
                      Boolean gioiTinh,
                      String soPhong,
                      String soNgayThue){
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
