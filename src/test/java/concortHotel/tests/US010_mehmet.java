package concortHotel.tests;

import com.github.javafaker.Faker;
import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class US010_mehmet {
    LoginPage loginPage;
    MainPage mainPage;
    RoomReservation roomReservation;
    Faker faker = new Faker();


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        loginPage = new LoginPage();



    }

    @Test
    public void tc_0001() {

        roomReservation = new RoomReservation();
        roomReservation.checkIn.clear();
       roomReservation.checkIn.sendKeys("11/12/2021");

       roomReservation.checkOut.clear();
       roomReservation.checkOut.sendKeys("11/25/2021");


        Select select = new Select(roomReservation.room);
        select.selectByIndex(6);

        Select select1 = new Select(roomReservation.customer);
        select1.selectByIndex(2);


        roomReservation.ava.submit();

    }

    @Test
    public void tc_0002() {
        roomReservation = new RoomReservation();
        roomReservation.checkIn.clear();
        roomReservation.checkIn.sendKeys("11/12/2021");

        roomReservation.checkOut.clear();
        roomReservation.checkOut.sendKeys("11/25/2021");
        Select select = new Select(roomReservation.room);
        select.selectByIndex(6);

        Select select1 = new Select(roomReservation.customer);
        select1.selectByIndex(2);


        roomReservation.ava.submit();

        roomReservation.booking.click();
    }

    @Test
    public void tc_0003() {
        roomReservation = new RoomReservation();
        roomReservation.checkIn.clear();
        roomReservation.checkIn.sendKeys("11/12/2021");

        roomReservation.checkOut.clear();
        roomReservation.checkOut.sendKeys("11/25/2021");
        Select select = new Select(roomReservation.room);
        select.selectByIndex(6);

        Select select1 = new Select(roomReservation.customer);
        select1.selectByIndex(2);


        roomReservation.ava.submit();

        roomReservation.booking.click();

        roomReservation.log.click();
    }

    @Test
    public void tc_0004() {
        roomReservation = new RoomReservation();
        roomReservation.checkIn.clear();
        roomReservation.checkIn.sendKeys("11/12/2021");

        roomReservation.checkOut.clear();
        roomReservation.checkOut.sendKeys("11/25/2021");
        Select select = new Select(roomReservation.room);
        select.selectByIndex(6);

        Select select1 = new Select(roomReservation.customer);
        select1.selectByIndex(2);


        roomReservation.ava.submit();
        roomReservation.booking.click();

        roomReservation.log.click();

        loginPage.username.sendKeys("manager");
        loginPage.password.sendKeys("Manager1!");
        loginPage.loginButton.click();


    }

    @Test
    public void tc_0005() {
        roomReservation = new RoomReservation();
        roomReservation.checkIn.clear();
        roomReservation.checkIn.sendKeys("11/12/2021");

        roomReservation.checkOut.clear();
        roomReservation.checkOut.sendKeys("11/25/2021");

        Select select = new Select(roomReservation.room);
        select.selectByIndex(6);

        Select select1 = new Select(roomReservation.customer);
        select1.selectByIndex(2);


        roomReservation.ava.submit();

        roomReservation.booking.click();

        roomReservation.log.click();

        loginPage.username.sendKeys("manager");
        loginPage.password.sendKeys("Manager1!");
        loginPage.loginButton.click();

        roomReservation.In.clear();
        roomReservation.In.sendKeys("11/12/2021");
        roomReservation.In.click();
        roomReservation.Out.clear();
        roomReservation.Out.sendKeys("11/25/2021");
        roomReservation.Out.click();


        Select select2 = new Select(roomReservation.adult);
        select2.selectByIndex(2);
        Select select3 = new Select(roomReservation.child);
        select3.selectByIndex(2);

        roomReservation.name.clear();
        roomReservation.name.sendKeys(faker.name().fullName());
        roomReservation.email.clear();
        roomReservation.email.sendKeys(faker.internet().emailAddress());
        roomReservation.phone.sendKeys(faker.phoneNumber().cellPhone());
        roomReservation.cardName.sendKeys(faker.name().fullName());
        roomReservation.number.sendKeys("1235647896325478");
        roomReservation.number.click();

        Select select4=new Select(roomReservation.year);
        select4.selectByIndex(4);
        Select select5=new Select(roomReservation.month);
        select5.selectByIndex(4);
        roomReservation.cvv.sendKeys("123");
        roomReservation.cvv.click();
        roomReservation.message.sendKeys("clear room");
        roomReservation.bookThisRoom.click();
    }

    @Test
    public void tc_0006() {
        roomReservation = new RoomReservation();
        roomReservation.checkIn.clear();
        roomReservation.checkIn.sendKeys("11/12/2021");

        roomReservation.checkOut.clear();
        roomReservation.checkOut.sendKeys("11/25/2021");

        Select select = new Select(roomReservation.room);
        select.selectByIndex(6);

        Select select1 = new Select(roomReservation.customer);
        select1.selectByIndex(2);


        roomReservation.ava.submit();

        roomReservation.booking.click();

        roomReservation.log.click();

        loginPage.username.sendKeys("manager");
        loginPage.password.sendKeys("Manager1!");
        loginPage.loginButton.click();

        roomReservation.In.clear();
        roomReservation.In.sendKeys("11/12/2021");
        roomReservation.In.click();
        roomReservation.Out.clear();
        roomReservation.Out.sendKeys("11/25/2021");
        roomReservation.Out.click();


        Select select2 = new Select(roomReservation.adult);
        select2.selectByIndex(2);
        Select select3 = new Select(roomReservation.child);
        select3.selectByIndex(2);

        roomReservation.name.clear();
        roomReservation.name.sendKeys(faker.name().fullName());
        roomReservation.email.clear();
        roomReservation.email.sendKeys(faker.internet().emailAddress());
        roomReservation.phone.sendKeys(faker.phoneNumber().cellPhone());
        roomReservation.cardName.sendKeys(faker.name().fullName());
        roomReservation.number.sendKeys("1235647896325478");
        roomReservation.number.click();

        Select select4=new Select(roomReservation.year);
        select4.selectByIndex(4);
        Select select5=new Select(roomReservation.month);
        select5.selectByIndex(4);
        roomReservation.cvv.sendKeys("123");
        roomReservation.cvv.click();
        roomReservation.message.sendKeys("clear room");
        roomReservation.bookThisRoom.click();

        roomReservation.here.click();
    }
/*
    @AfterMethod
    public void tearDown() throws IOException {
        ReusableMethods.getScreenshot("US003_Huseyin");
        Driver.closeDriver();
    }*/
}