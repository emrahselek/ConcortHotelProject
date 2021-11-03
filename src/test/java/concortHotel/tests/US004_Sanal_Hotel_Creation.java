package concortHotel.tests;

import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class US004_Sanal_Hotel_Creation {

    MainPage mainPage;
    LoginPage loginPage;
    AdminPage adminPage;
    HotelListPage hotelListPage;
    CreateHotelFormPage createHotelFormPage;
    Select select;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        hotelListPage = new HotelListPage();
        createHotelFormPage = new CreateHotelFormPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.logInLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager1_user"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager1_password"));
        loginPage.loginButton.click();
    }

    @Test(priority = 0)
    public void us04_tc001() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        createHotelFormPage.code.sendKeys("777");
        createHotelFormPage.name.sendKeys("Hilton");
        createHotelFormPage.address.sendKeys("345 6th Avenue, New York, NY");
        createHotelFormPage.phone.sendKeys("347-347-7777");
        createHotelFormPage.email.sendKeys("john.snow@gmail.com");
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(createHotelFormPage.successMessage));
        Assert.assertTrue(createHotelFormPage.successMessage.isDisplayed());
    }

    @Test(priority = 1)
    public void us04_tc002() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        //do not enter text in "Code" text box
        createHotelFormPage.name.sendKeys("Hilton");
        createHotelFormPage.address.sendKeys("345 6th Avenue, New York, NY");
        createHotelFormPage.phone.sendKeys("347-347-7777");
        createHotelFormPage.email.sendKeys("john.snow@gmail.com");
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        Assert.assertTrue(createHotelFormPage.codeMessage.isDisplayed());
    }

    @Test(priority = 2)
    public void us04_tc003() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        createHotelFormPage.code.sendKeys("777");
        //Do not enter name in "Name" text box
        createHotelFormPage.address.sendKeys("345 6th Avenue, New York, NY");
        createHotelFormPage.phone.sendKeys("347-347-7777");
        createHotelFormPage.email.sendKeys("john.snow@gmail.com");
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        Assert.assertTrue(createHotelFormPage.addressMessage.isDisplayed());
    }

    @Test(priority = 3)
    public void us04_tc004() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        createHotelFormPage.code.sendKeys("777");
        createHotelFormPage.name.sendKeys("Hilton");
        //Do not enter address in "Address" text box
        createHotelFormPage.phone.sendKeys("347-347-7777");
        createHotelFormPage.email.sendKeys("john.snow@gmail.com");
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        Assert.assertTrue(createHotelFormPage.addressMessage.isDisplayed());
    }

    @Test(priority = 4)
    public void us04_tc005() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        createHotelFormPage.code.sendKeys("777");
        createHotelFormPage.name.sendKeys("Hilton");
        createHotelFormPage.address.sendKeys("345 6th Avenue, New York, NY");
        //Do not enter phone number in "Phone" text box
        createHotelFormPage.email.sendKeys("john.snow@gmail.com");
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        Assert.assertTrue(createHotelFormPage.phoneMessage.isDisplayed());
    }

    @Test(priority = 5)
    public void us04_tc006() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        createHotelFormPage.code.sendKeys("777");
        createHotelFormPage.name.sendKeys("Hilton");
        createHotelFormPage.address.sendKeys("345 6th Avenue, New York, NY");
        createHotelFormPage.phone.sendKeys("347-347-7777");
        //Do not enter email address in "Email" text box
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        Assert.assertTrue(createHotelFormPage.emailMessage.isDisplayed());
    }

    @Test(priority = 6)
    public void us04_tc007() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        createHotelFormPage.code.sendKeys("777");
        createHotelFormPage.name.sendKeys("Hilton");
        createHotelFormPage.address.sendKeys("345 6th Avenue, New York, NY");
        createHotelFormPage.phone.sendKeys("347-347-7777");
        createHotelFormPage.email.sendKeys("john.snow@gmail.com");
        //Select hotel type in "IDGroup" dropdown as by default
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(0);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        Assert.assertTrue(createHotelFormPage.selectGroupMessage.isDisplayed());
    }

    @Test(priority = 8)
    public void us04_tc008() {
        adminPage.hotelManagement.click();
        adminPage.hotelListLink.click();
        hotelListPage.addHotel.click();
        createHotelFormPage.code.sendKeys("777");
        createHotelFormPage.name.sendKeys("Hilton");
        createHotelFormPage.address.sendKeys("345 6th Avenue, New York, NY");
        createHotelFormPage.phone.sendKeys("347-347-7777");
        createHotelFormPage.email.sendKeys("john.snow@gmail.com");
        select = new Select(createHotelFormPage.idGroupDropdown);
        select.selectByIndex(2);
        ReusableMethods.waitFor(2);
        createHotelFormPage.saveButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(createHotelFormPage.fakeDuplicateMessage));
        Assert.assertTrue(createHotelFormPage.fakeDuplicateMessage.isDisplayed());
    }

    @AfterMethod()
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            ReusableMethods.getScreenshot("screenshot");
        }
        Driver.closeDriver();
    }
}
