/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Test;

import com.UI.Login;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assume;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Admin
 */
@RunWith(Parameterized.class)
public class LoginTest {
    enum Type{SAIMATKHAU,TKCHUADANGKY,DANGNHAPDUNG,EMPTYTAIKHOAN,EMPTYMATKHAU,EMPTYBOTH}
    private String userName;
    private String password;
    private Login login;
    private Type type;
    private String actualResult;
    private String expected;
    
    
        LoginTest(Type type,String userName, String password) {
        this.type = type;
        this.userName = userName;
        this.password = password;
    }
       
    @Parameterized.Parameters
    public static Collection valueAccount(){
        return Arrays.asList(new Object[][]{
            {Type.SAIMATKHAU,"MI","conrua123"},
            {Type.SAIMATKHAU,"TU","conbo123"},
            {Type.SAIMATKHAU,"Admin","conruabo123"},
            
            {Type.EMPTYBOTH,"",""},
            
            {Type.TKCHUADANGKY,"ngoc234","ng6457"},
            
            {Type.DANGNHAPDUNG,"Admin","1234a"},
            {Type.DANGNHAPDUNG,"MI","1234"},
            {Type.DANGNHAPDUNG,"TU","1234"},
            
            {Type.EMPTYTAIKHOAN,"","1234"},
            
            {Type.EMPTYMATKHAU,"MI",""},
        });
    }
    
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testMatkhauSai(){       
        Assume.assumeTrue(type == Type.SAIMATKHAU);
        actualResult = login.login(userName,password).get("ErrorPass").toLowerCase();
        expected = "mật khẩu không chính xác";
        assertEquals(expected.toLowerCase(),actualResult);
    }
    
    @Test
    public void testTKChuaDangKy(){
        Assume.assumeTrue(type == Type.TKCHUADANGKY);
        actualResult = login.login(userName, password).get("ErrorUser").toLowerCase();
        expected = "Tài khoản không tồn tại";
        assertEquals(expected.toLowerCase(),actualResult);
    }
    
    @Test
    public void testDangNhapDung(){
        Assume.assumeTrue(type == Type.DANGNHAPDUNG);
        actualResult = login.login(userName, password).get("loginSuccess").toLowerCase();
        expected = "Trang chủ";
        assertEquals(expected.toLowerCase(),actualResult);
    }
    
    @Test
    public void testTrongTK(){
        Assume.assumeTrue(type == Type.EMPTYTAIKHOAN);
        actualResult = login.login(userName, password).get("ErrorUser").toLowerCase();
        expected = "Không để trống tên đăng nhập";
        assertEquals(expected.toLowerCase(),actualResult);
    }
    
    @Test
    public void testTrongMK(){
        Assume.assumeTrue(type == Type.EMPTYMATKHAU);
        actualResult = login.login(userName, password).get("ErrorPass").toLowerCase();
        expected = "Không để trống mật khẩu";
        assertEquals(expected.toLowerCase(),actualResult);
    }
    
    @Before
    public void setUp() {
        actualResult = "";
        expected = "";
        login = new Login();
    }

    @After
    public void tearDown() {
    }

}
