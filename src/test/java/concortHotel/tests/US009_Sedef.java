package concortHotel.tests;

import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class US009_Sedef {

    LoginPage loginPage;
    MainPage mainPage;
    AdminPage adminPage;
    RoomReservationPage roomReservationPage;
    EditRoomReservationPage editRoomReservationPage;


     @BeforeMethod
    public void roomReservationUpdate() {

        Driver.getDriver().get(ConfigReader.getProperty("app_url_Prod"));

        mainPage = new MainPage();
        mainPage.mainPageLoginLink.click();

        loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("admin_user"));
        loginPage.passWord.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();

        adminPage = new AdminPage();
        adminPage.hotelManagementTab.click();
        adminPage.roomReservationsLink.click();

        ReusableMethods.waitFor(3);

        roomReservationPage = new RoomReservationPage();
        roomReservationPage.details.click();


    }
    @Test
    public void US009_testCase1() {


        editRoomReservationPage = new EditRoomReservationPage();

        Select select = new Select(editRoomReservationPage.idHotelRoom);
        select.selectByIndex(5);

        ReusableMethods.waitFor(1);
        editRoomReservationPage.saveButton.click();
        Driver.closeDriver();

    }
    @Test
    public void US009_testCase2() {


        editRoomReservationPage = new EditRoomReservationPage();

        Select select1 = new Select(editRoomReservationPage.idUser);
        select1.selectByIndex(14);

        ReusableMethods.waitFor(1);
        editRoomReservationPage.saveButton.click();
        Driver.closeDriver();
    }

    @Test
    public void US009_testCase3() {

        editRoomReservationPage = new EditRoomReservationPage();

        editRoomReservationPage.price.clear();

        editRoomReservationPage.price.sendKeys("375");

        ReusableMethods.waitFor(1);
        editRoomReservationPage.saveButton.click();
        Driver.closeDriver();

    }

    @Test
    public void US009_testCase4() {

         editRoomReservationPage = new EditRoomReservationPage();

         editRoomReservationPage.dateEnd.clear();
         editRoomReservationPage.dateEnd.sendKeys("12/20/2020");

        ReusableMethods.waitFor(1);
        editRoomReservationPage.saveButton.click();
        Driver.closeDriver();

    }

    @Test
    public void US009_testCase5() {

         editRoomReservationPage = new EditRoomReservationPage();
         editRoomReservationPage.contactNameSurname.clear();

         editRoomReservationPage.contactNameSurname.sendKeys("Sedef Gunerhan");

         ReusableMethods.waitFor(1);
         editRoomReservationPage.saveButton.click();
         Driver.closeDriver();

    }

    @Test
    public void US009_testCase6() {

         editRoomReservationPage = new EditRoomReservationPage();

         editRoomReservationPage.contactEmail.clear();
         editRoomReservationPage.contactEmail.sendKeys("SedefGnrhan@gmail.com");

         ReusableMethods.waitFor(1);
         editRoomReservationPage.saveButton.click();
         Driver.closeDriver();

    }

    @Test
    public void US009_testCase7() {

         editRoomReservationPage = new EditRoomReservationPage();

         ReusableMethods.waitFor(2);

         editRoomReservationPage.notes.clear();
         editRoomReservationPage.notes.sendKeys("Please bring extra mattress to the room");

         ReusableMethods.waitFor(1);
         editRoomReservationPage.saveButton.click();
         Driver.closeDriver();



    }


}