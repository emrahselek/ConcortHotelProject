package concortHotel.tests;

import concortHotel.pages.GoogleMain;
import concortHotel.pages.LoginPage;
import concortHotel.pages.MainPage;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class US003_Huseyin {

    MainPage mainPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        loginPage = new LoginPage();
        mainPage.logInLink.click();
        loginPage.createNewAccount.click();
    }

    @Test
    public void tc_0001(){



    }

}
