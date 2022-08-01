/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Test;

import com.UI.Login;
import java.io.File;
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
public class LoginTest {
    
    private Login login;
    private String actualResult;
    private String expected;
    File path = new File("E:\\testdata.xlsx");
    String sheet = "Đăng nhập";
    ExcelUtils ex = new ExcelUtils(path, sheet);
    int index = 0;
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @DataProvider(name = "saiMatKhau")
    public Object[][] dataMatkhauSai() {
        
        Object data[][] = ExcelDataProvider.testData(path,sheet,"sai mật khẩu");
        return data;
    }
    
    @DataProvider(name = "taikhoanchuadangky")
    public Object[][] dataTKChuaDangKy() {
      
        Object data[][] = ExcelDataProvider.testData(path,sheet,"Tài khoản chưa đăng ký");
        return data;
    }
    
    @DataProvider(name = "dangNhapDung")
    public Object[][] dataDangNhapDung() {
    
        Object data[][] = ExcelDataProvider.testData(path,sheet,"tài khoản đúng");
        return data;
    }
    
    @DataProvider(name = "tkRong")
    public Object[][] dataRongTK() {
  
        Object data[][] = ExcelDataProvider.testData(path,sheet,"trống tài khoản");
        return data;
    }
    
    @DataProvider(name = "mkRong")
    public Object[][] dataRongMK() {

        Object data[][] = ExcelDataProvider.testData(path,sheet,"trống mật khẩu");
        return data;
    }
    
    @DataProvider(name = "tkRongVaMKRong")
    public Object[][] dataRongTKVaMK() {
 
        Object data[][] = ExcelDataProvider.testData(path,sheet,"trống đăng nhập");
        return data;
    }
    
    @Test(dataProvider = "saiMatKhau")
    public void testMatkhauSai(String userName,String password){       
        actualResult = login.login(userName,password).get("ErrorPass").toLowerCase();
        expected = "mật khẩu không chính xác";
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index));
        assertEquals(actualResult,expected.toLowerCase());//nếu fail dừng tại đây.
        
        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index));
        index++;//index là vị trí row trong excel
    }
    
    @Test(dataProvider = "taikhoanchuadangky")
    public void testTKChuaDangKy(String userName,String password){
        actualResult = login.login(userName, password).get("ErrorUser").toLowerCase();
        expected = "Tài khoản không tồn tại";
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index));
        assertEquals(actualResult,expected.toLowerCase());
        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index));
        index++;
    }
    
    @Test(dataProvider = "dangNhapDung")
    public void testDangNhapDung(String userName,String password){
        actualResult = login.login(userName,password.replaceAll("['']","")).get("loginSuccess").toLowerCase();
        expected = "Trang chủ";
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index));
        assertEquals(actualResult,expected.toLowerCase());
        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index));
        index++;
    }
    
    @Test(dataProvider = "tkRong")
    public void testRongTK(String userName,String password){
     
        actualResult = login.login("", password.trim()).get("ErrorUser").toLowerCase();
        expected = "Không để trống tên đăng nhập";
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index));
        assertEquals(actualResult,expected.toLowerCase());
        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index));
        index++;
    }
    
    @Test(dataProvider = "mkRong")
    public void testRongMK(String userName,String password){
       
        actualResult = login.login(userName.trim(), "").get("ErrorPass").toLowerCase();
        expected = "Không để trống mật khẩu";
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index));
        assertEquals(actualResult,expected.toLowerCase());
        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index));
        index++;
    }
    
    @Test(dataProvider = "tkRongVaMKRong")
    public void testRongTaiKhoanVaMatKhau(String userName,String password){
     
        actualResult = login.login(userName, password).get("ErrorUser").toLowerCase() +
              " và "  + login.login(userName, password).get("ErrorPass").toLowerCase();
        expected = "Không để trống tên đăng nhập và Không để trống mật khẩu";
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index));
        assertEquals(actualResult,expected.toLowerCase());
        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index));
        index++;
    }
    
    
    @BeforeMethod
    public void setUpMethod() throws Exception {
        actualResult = "";
        expected = "";
        login = new Login();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        if(ExcelDataProvider.rows.size() - 1 < index)
        index = 0;
    }
}
