/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Test;

import utils.ExcelDataProvider;
import utils.ExcelUtils;
import com.DAO.PhongDAO;
import com.UI.QuanLyPhong;
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
public class QuanLyPhongTest {

    public QuanLyPhongTest() {
    }

    File path = new File("E:\\testdata.xlsx");
    String sheet = "Phòng";
    private QuanLyPhong qlPhong;
    ExcelUtils ex = new ExcelUtils(path, sheet);
    int index = 0;
    PhongDAO pDao;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @DataProvider(name = "themPhongDeTrongID")
    public Object[][] themPhongTrongID() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Thêm phòng để trống số phòng");
        return data;
    }

    @DataProvider(name = "themPhongDaTonTai")
    public Object[][] themPhongTonTai() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Thêm phòng đã tồn tại");
        return data;
    }

    @DataProvider(name = "themPhongDung")
    public Object[][] themPhongDung() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Thêm phòng nhập đủ thông tin");
        return data;
    }

    @DataProvider(name = "xoaPhongDung")
    public Object[][] xoaPhongDung() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Xoá phòng đúng");
        return data;
    }

    @DataProvider(name = "xoaPhongTrongID")
    public Object[][] xoaPhongTrongID() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Xóa phòng trống số phòng");
        return data;
    }

    @DataProvider(name = "capNhatTrongID")
    public Object[][] capNhatTrongID() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Cập nhật phòng trống số phòng");
        return data;
    }

    @DataProvider(name = "capNhatTinhTrangPhong")
    public Object[][] capNhatTinhTrangPhong() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Cập nhập tình trạng phòng");
        return data;
    }

    @DataProvider(name = "capNhatLoaiPhong")
    public Object[][] capNhatLoaiPhong() {
        Object data[][] = ExcelDataProvider.testData(path, sheet, "Cập nhập loại phòng");
        return data;
    }

    int expected;

    @Test(dataProvider = "themPhongDeTrongID")
    public void themPhongTrongID(String soPhong, String maLP, String tinhTrang) {
        index++;
        expected = -1;
        qlPhong.value(soPhong, maLP, tinhTrang);
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(qlPhong.insertRoom(), expected);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }

    @Test(dataProvider = "themPhongDaTonTai")
    public void themPhongTonTai(String soPhong, String maLP, String tinhTrang) {
        index++;
        expected = -1;
        qlPhong.value(soPhong, maLP, tinhTrang);
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(qlPhong.insertRoom(), expected);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }
    int actual;

    @Test(dataProvider = "themPhongDung")
    public void themPhongDung(String soPhong, String maLP, String tinhTrang) {
        index++;
        expected = pDao.selectAll().size();

        qlPhong.value(soPhong, maLP, tinhTrang);
        actual = qlPhong.insertRoom();
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(actual, expected + 1);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }

    @Test(dataProvider = "xoaPhongDung", priority = 2)
    public void xoaPhongDung(String soPhong,String maLP, String tinhTrang) {
        index++;
        expected = pDao.selectAll().size();

        qlPhong.idDelete(soPhong);
        actual = qlPhong.deleteRoom();
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(actual, expected - 1);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }

    @Test(dataProvider = "xoaPhongTrongID", priority = 2)
    public void xoaPhongTrongID(String soPhong,String maLP, String tinhTrang) {
        index++;
        expected = -1;

        qlPhong.idDelete(soPhong);
        actual = qlPhong.deleteRoom();
        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(actual, expected);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }

    Object expectedCapNhat;

    @Test(dataProvider = "capNhatTrongID", priority = 1)
    public void capNhatTrongID(String soPhong, String maLP, String tinhTrang) {
        index++;
        expectedCapNhat = null;
        qlPhong.value(soPhong, maLP, tinhTrang);

        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(qlPhong.updateRoom(), expectedCapNhat);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }

    @Test(dataProvider = "capNhatTinhTrangPhong", priority = 1)
    public void capNhatTinhTrangPhong(String soPhong, String maLP, String tinhTrang) {
        index++;
        expectedCapNhat = tinhTrang;
        qlPhong.value(soPhong, maLP, tinhTrang);

        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(qlPhong.updateRoom().getTinhTrang(), expectedCapNhat);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }

    @Test(dataProvider = "capNhatLoaiPhong", priority = 1)
    public void capNhatLoaiPhong(String soPhong, String maLP, String tinhTrang) {
        index++;
        expectedCapNhat = maLP;
        qlPhong.value(soPhong, maLP, tinhTrang);

        ex.updateExcel(path, "Fail", ExcelDataProvider.rows.get(index - 1));

        assertEquals(qlPhong.updateRoom().getMaLP(), expectedCapNhat);

        ex.updateExcel(path, "Pass", ExcelDataProvider.rows.get(index - 1));
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        qlPhong = new QuanLyPhong();
        pDao = new PhongDAO();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        if (ExcelDataProvider.rows.size() - 1 < index) {
            index = 0;
        }
    }
}
