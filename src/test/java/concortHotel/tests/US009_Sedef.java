package concortHotel.tests;

import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
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

    @Test
    // @BeforeMethod
    public void roomReservationUpdate() {

        Driver.getDriver().get(ConfigReader.getProperty("app_url_Prod"));

        MainPage mainPage = new MainPage();
        mainPage.mainPageLoginLink.click();

        LoginPage loginPage = new LoginPage();
        loginPage.userName.sendKeys(ConfigReader.getProperty("admin_user"));
        loginPage.passWord.sendKeys(ConfigReader.getProperty("admin_password"));
        loginPage.loginButton.click();

        AdminPage adminPage = new AdminPage();
        adminPage.hotelManagementTab.click();
        adminPage.roomReservationsLink.click();

        RoomReservationPage roomReservationPage = new RoomReservationPage();
        roomReservationPage.details.click();






//    }
//    @Test
//    public void testCase1() {
//
//
//
//     driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

//       RoomReservationPage roomReservationPage = new RoomReservationPage();
//        roomReservationPage.detailbutton.click();
//
//        EditRoomReservationPage editRoomReservationPage= new EditRoomReservationPage();
//
//        Select select = new Select(editRoomReservationPage.idHotelRoom);
//        select.selectByIndex(5);
//
//       Select select1 = new Select(editRoomReservationPage.idUser);
//       select1.selectByIndex(14);
//
//        editRoomReservationPage.price.sendKeys("375");
//        editRoomReservationPage.dateEnd.sendKeys("12/20/2020");
//        editRoomReservationPage.contactNameSurname.sendKeys("Sedef Gnrhan");
//        editRoomReservationPage.contactEmail.sendKeys("SedefGnrhan@gmail.com");
//        editRoomReservationPage.notes.sendKeys("Please bring extra mattress to the room!");
//        editRoomReservationPage.saveButton.click();

        // Driver.closeDriver();



    }


}