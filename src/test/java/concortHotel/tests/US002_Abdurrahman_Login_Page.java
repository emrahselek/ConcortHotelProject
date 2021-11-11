package concortHotel.tests;

import concortHotel.pages.AdminPage;
import concortHotel.pages.LoginPage;
import concortHotel.pages.MainPage;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import static org.testng.Assert.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class US002_Abdurrahman_Login_Page {

    AdminPage adminPage;

    @DataProvider
    public Object[][] userData(){
        String [][] userInfo={
                { "manager1_user","manager1_password"},
                { "manager2_user","manager2_password"},
                { "admin_user","admin_password"},
        };
        return userInfo;
    }



    @Test(dataProvider = "userData")
    public void us_002_testManagerLogin(String userName,String password){
        MainPage.setUp(userName,password);
        adminPage=new AdminPage();
        ReusableMethods.waitFor(2);
        System.out.println(adminPage.usernameRightTop.getText());
        assertEquals(adminPage.usernameRightTop.getText(),ConfigReader.getProperty(userName));

    }
    @AfterMethod()
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            ReusableMethods.getScreenshot("screenshot");
        }
        Driver.closeDriver();
    }



}