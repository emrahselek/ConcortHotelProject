package concortHotel.tests;


import concortHotel.pages.AdminPage;
import concortHotel.pages.CreateRoomReservationPage;
import concortHotel.pages.LoginPage;
import concortHotel.pages.MainPage;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.*;
import static org.testng.Assert.*;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class US008_Tugce {

    CreateRoomReservationPage createRoomReservationPage;
    AdminPage adminPage;
    LoginPage loginPage;
    MainPage mainPage;


    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage();
        mainPage = new MainPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage.logInLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager1_user"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager1_password"));
        loginPage.loginButton.click();
    }

    @Test (priority = 0)
    public void us08_TC001() throws InterruptedException {
        createRoomReservationPage = new CreateRoomReservationPage();
        adminPage = new AdminPage();
        adminPage.hotelManagement.click();
        adminPage.roomReservationsLink.click();
        createRoomReservationPage.addRoomReservation.click();
        ReusableMethods.selectFromDropDown(createRoomReservationPage.firstSelectIdUSer, "manager");
        ReusableMethods.seletFromDropDown(createRoomReservationPage.secondSelectIdUSer, "63");
        createRoomReservationPage.price.sendKeys("3000");
        createRoomReservationPage.dateStart.sendKeys("11/17/2021");
        createRoomReservationPage.dataEnd.sendKeys("11/26/2021");
        createRoomReservationPage.adultAmount.sendKeys("2");
        createRoomReservationPage.childrenAmount.sendKeys("2");
        createRoomReservationPage.contactNameSurname.sendKeys("Violet Vivaldi");
        createRoomReservationPage.contactPhone.sendKeys("477-432-4466");
        createRoomReservationPage.contactEmail.sendKeys("violetvivaldi@gmail.com");
        createRoomReservationPage.notes.sendKeys("This is a notes");
        createRoomReservationPage.approved.click();
        createRoomReservationPage.isPaid.click();
        ReusableMethods.waitFor(2);
        createRoomReservationPage.saveButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(createRoomReservationPage.popupMessage));
        assertTrue(createRoomReservationPage.popupMessage.isDisplayed());
        createRoomReservationPage.clickOk.click();
    }
    @Test (priority = 1)
    public void us08_TC002(){
        createRoomReservationPage = new CreateRoomReservationPage();
        adminPage = new AdminPage();
        adminPage.hotelManagement.click();
        adminPage.roomReservationsLink.click();
        createRoomReservationPage.addRoomReservation.click();
        ReusableMethods.selectFromDropDown(createRoomReservationPage.firstSelectIdUSer, "manager");
        ReusableMethods.seletFromDropDown(createRoomReservationPage.secondSelectIdUSer, "63");
        createRoomReservationPage.price.sendKeys("3000");
        createRoomReservationPage.dateStart.sendKeys("11/17/2021");
        createRoomReservationPage.dataEnd.sendKeys("11/26/2021");
        createRoomReservationPage.adultAmount.sendKeys("2");
        createRoomReservationPage.childrenAmount.sendKeys("2");
        createRoomReservationPage.contactNameSurname.sendKeys("Violet Vivaldi");
        createRoomReservationPage.contactPhone.sendKeys("477-432-4466");
        createRoomReservationPage.contactEmail.sendKeys("");
        createRoomReservationPage.notes.sendKeys("This is a notes");
        createRoomReservationPage.approved.click();
        createRoomReservationPage.isPaid.click();
        ReusableMethods.waitFor(2);
        createRoomReservationPage.saveButton.click();
        WebDriverWait emailwait = new WebDriverWait(Driver.getDriver(), 10);
        emailwait.until(ExpectedConditions.visibilityOf(createRoomReservationPage.emailError));
        assertTrue(createRoomReservationPage.emailError.isDisplayed());
    }
    @Test (priority = 2)
    public void us08_TC003(){
        createRoomReservationPage = new CreateRoomReservationPage();
        adminPage = new AdminPage();
        adminPage.hotelManagement.click();
        adminPage.roomReservationsLink.click();
        createRoomReservationPage.addRoomReservation.click();
        ReusableMethods.selectFromDropDown(createRoomReservationPage.firstSelectIdUSer, "manager");
        ReusableMethods.seletFromDropDown(createRoomReservationPage.secondSelectIdUSer, "63");
        createRoomReservationPage.price.sendKeys("3000");
        createRoomReservationPage.dateStart.sendKeys("11/17/2021");
        createRoomReservationPage.dataEnd.sendKeys("11/26/2021");
        createRoomReservationPage.adultAmount.sendKeys("2");
        createRoomReservationPage.childrenAmount.sendKeys("2");
        createRoomReservationPage.contactNameSurname.sendKeys("Violet Vivaldi");
        createRoomReservationPage.contactPhone.sendKeys("11122");
        createRoomReservationPage.contactEmail.sendKeys("violetvivaldi@gmail.com");
        createRoomReservationPage.notes.sendKeys("This is a notes");
        createRoomReservationPage.approved.click();
        createRoomReservationPage.isPaid.click();
        ReusableMethods.waitFor(2);
        createRoomReservationPage.saveButton.click();
        WebDriverWait phoneWait = new WebDriverWait(Driver.getDriver(), 10);
        phoneWait.until(ExpectedConditions.visibilityOf(createRoomReservationPage.contactPhoneError));
        assertTrue(createRoomReservationPage.contactPhoneError.isDisplayed());

    }
    @Test (priority = 3)
    public void us08_TC004(){
        createRoomReservationPage = new CreateRoomReservationPage();
        adminPage = new AdminPage();
        adminPage.hotelManagement.click();
        adminPage.roomReservationsLink.click();
        createRoomReservationPage.addRoomReservation.click();
        ReusableMethods.selectFromDropDown(createRoomReservationPage.firstSelectIdUSer, "manager");
        ReusableMethods.seletFromDropDown(createRoomReservationPage.secondSelectIdUSer, "63");
        createRoomReservationPage.price.sendKeys("3000");
        createRoomReservationPage.dateStart.sendKeys("11/17/2021");
        createRoomReservationPage.dataEnd.sendKeys("11/26/2021");
        createRoomReservationPage.adultAmount.sendKeys("-2");
        createRoomReservationPage.childrenAmount.sendKeys("-2");
        createRoomReservationPage.contactNameSurname.sendKeys("Violet Vivaldi");
        createRoomReservationPage.contactPhone.sendKeys("477-432-4466");
        createRoomReservationPage.contactEmail.sendKeys("violetvivaldi@gmail.com");
        createRoomReservationPage.notes.sendKeys("This is a notes");
        createRoomReservationPage.approved.click();
        createRoomReservationPage.isPaid.click();
        ReusableMethods.waitFor(2);
        createRoomReservationPage.saveButton.click();
        WebDriverWait amountError = new WebDriverWait(Driver.getDriver(), 10);
        amountError.until(ExpectedConditions.visibilityOf(createRoomReservationPage.popupMessage));
        assertTrue(createRoomReservationPage.popupMessage.isDisplayed());

    }

    @Test (priority = 4)
    public void us08_TC005(){
        createRoomReservationPage = new CreateRoomReservationPage();
        adminPage = new AdminPage();
        adminPage.hotelManagement.click();
        adminPage.roomReservationsLink.click();
        createRoomReservationPage.addRoomReservation.click();
        ReusableMethods.selectFromDropDown(createRoomReservationPage.firstSelectIdUSer, "manager");
        ReusableMethods.seletFromDropDown(createRoomReservationPage.secondSelectIdUSer, "63");
        createRoomReservationPage.price.sendKeys("3000");
        createRoomReservationPage.dateStart.sendKeys("11/17/2021");
        createRoomReservationPage.dataEnd.sendKeys("11/26/2021");
        createRoomReservationPage.adultAmount.sendKeys("2");
        createRoomReservationPage.childrenAmount.sendKeys("2");
        createRoomReservationPage.contactNameSurname.sendKeys("Violet Vivaldi");
        createRoomReservationPage.contactPhone.sendKeys("477-432-4466");
        createRoomReservationPage.contactEmail.sendKeys("violetvivaldi@gmail.com");
        createRoomReservationPage.notes.sendKeys("This is a notes");
        createRoomReservationPage.approved.click();
        createRoomReservationPage.isPaid.click();
        ReusableMethods.waitFor(2);
        createRoomReservationPage.saveButton.click();
        WebDriverWait amountError = new WebDriverWait(Driver.getDriver(), 10);
        amountError.until(ExpectedConditions.visibilityOf(createRoomReservationPage.popupMessage));
        assertTrue(createRoomReservationPage.popupMessage.isDisplayed());
        ReusableMethods.waitFor(3);

    }



    @AfterMethod()
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            ReusableMethods.getScreenshot("US008_Tugce");
        }
        Driver.closeDriver();
    }

}