/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Admin
 */
public class Test {
    
    WebDriver webDriver;
    String url = "https://lms.poly.edu.vn/";
     String driverPath = "E:\\selenium-webdriver\\chromedriver.exe";
    
    @Test
    public Test() {
    }

    //

    @BeforeClass
    public void setUpClass() throws Exception {
        webDriver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", driverPath);
        webDriver.get(url);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
