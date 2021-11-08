package concortHotel.tests;

import com.github.javafaker.Faker;
import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class US005_Emrah {

    MainPage mainPage;
    LoginPage loginPage;
    AdminPage adminPage;
    HotelListPage hotelListPage;
    EditHotelPage editHotelPage;
    Select select;
    Faker faker = new Faker();
    String window1Handle;
    String window2Handle;


    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        hotelListPage = new HotelListPage();
        editHotelPage = new EditHotelPage();
        mainPage.logInLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager1_user"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager1_password"));
        loginPage.loginButton.click();
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.details.click();
        ReusableMethods.waitFor(1);
        window1Handle = Driver.getDriver().getWindowHandle();
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for(String eachWindowsHandle:allWindowHandles){
            if(!eachWindowsHandle.equals(window1Handle)){
                Driver.getDriver().switchTo().window(eachWindowsHandle);
                break;
            }
        }
        window2Handle = Driver.getDriver().getWindowHandle();
    }

    @Test
    public void us005_tc001() {
        editHotelPage.code.clear();
        editHotelPage.code.sendKeys(faker.number().digits(4));
        editHotelPage.save.click();
        ReusableMethods.waitFor(1);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("Hotel was updated successfully");
        Assert.assertTrue(successfullymessage.booleanValue());
    }

    @Test
    public void us005_tc002() {
        editHotelPage.name.clear();
        editHotelPage.name.sendKeys(faker.name().fullName());
        editHotelPage.save.click();
        ReusableMethods.waitFor(1);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("Hotel was updated successfully");
        Assert.assertTrue(successfullymessage.booleanValue());
    }

    @Test
    public void us005_tc003() {
        editHotelPage.address.clear();
        editHotelPage.address.sendKeys(faker.address().fullAddress());
        editHotelPage.save.click();
        ReusableMethods.waitFor(1);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("Hotel was updated successfully");
        Assert.assertTrue(successfullymessage.booleanValue());
    }

    @Test
    public void us005_tc004() {
        editHotelPage.phone.clear();
        editHotelPage.phone.sendKeys(faker.phoneNumber().phoneNumber());
        editHotelPage.save.click();
        ReusableMethods.waitFor(1);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("Hotel was updated successfully");
        Assert.assertTrue(successfullymessage.booleanValue());
    }

    @Test
    public void us005_tc005() {
        editHotelPage.email.clear();
        editHotelPage.email.sendKeys(faker.internet().emailAddress());
        editHotelPage.save.click();
        ReusableMethods.waitFor(1);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("Hotel was updated successfully");
        Assert.assertTrue(successfullymessage.booleanValue());
    }

    @Test
    public void us005_tc006() {
        Driver.getDriver().switchTo().window(window1Handle);
        select = new Select(hotelListPage.idGroupDropdown);
        select.selectByIndex(2);
        hotelListPage.searchButton.click();
        ReusableMethods.waitFor(1);
        hotelListPage.details.click();
        Driver.getDriver().switchTo().window(window2Handle);
        select = new Select(editHotelPage.idGroupDropdown);
        select.selectByIndex(1);
        editHotelPage.save.click();
        ReusableMethods.waitFor(1);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("Hotel was updated successfully");
        Assert.assertTrue(successfullymessage.booleanValue());

    }

    @Test
    public void us005_tc007() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.id("btnDelete")).click();
        ReusableMethods.waitFor(1);
        Driver.getDriver().findElement(By.xpath("//button[normalize-space()='OK']")).click();
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("Error");
        Assert.assertTrue(successfullymessage.booleanValue());

    }

    @AfterMethod()
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            ReusableMethods.getScreenshot("US005_Emrah");
        }
        Driver.closeDriver();
    }

}
