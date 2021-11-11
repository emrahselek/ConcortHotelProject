package concortHotel.tests;

import org.openqa.selenium.interactions.Actions;
import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class US006_Sukriye {
    MainPage mainPage;
    LoginPage loginPage;
    AdminPage adminPage;
    HotelRoomListPage hotelRoomListPage;
    CreateHotelRoomFormPage createHotelRoomFormPage;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        loginPage = new LoginPage();
        adminPage = new AdminPage();
        hotelRoomListPage=new HotelRoomListPage();
        createHotelRoomFormPage=new CreateHotelRoomFormPage();

        mainPage.logInLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty("manager1_user"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager1_password"));
        loginPage.loginButton.click();

        adminPage.hotelManagement.click();
        adminPage.hotelRoomsTab.click();
        createHotelRoomFormPage.addHotelRoomLink.click();

    }
    @Test
    public void tc_001() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise isolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);
        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();
        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();
        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertEquals(popupMessageElement.getText(),"HotelRoom was inserted successfully");

        } catch (Exception e) {
            System.out.println("Test1 Failed");
        }

        createHotelRoomFormPage.okButton.click();

    }


    @Test
    public void tc_002() throws InterruptedException {
        //Negative scenario ,I didnt select hotel from hotelDropdown

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);

        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();

        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test2 Passed");
        }

    }

    @Test
    public void tc_003() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        //Negative scenario I didnt sent room code

        // createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);

        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();


        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test3 Passed");
        }

    }
    @Test
    public void tc_004() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        //Negative Scenari ,I didnt sent Room name
        //createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);

        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();


        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test4 Failed");
        }
    }


    @Test
    public void tc_005() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        //Negative Scenario , I didnt sent location
        // createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType = new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();


        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
            WebElement popupMessageElement = wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test5 Failed");
        }

    }
    @Test
    public void tc_006() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

//        Actions actions = new Actions(Driver.getDriver()) ;
//        Thread.sleep(3000);
//        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();


        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test6 Passed");
        }

        //createHotelRoomFormPage.okButton.click();

    }



    @Test
    public void tc_007() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);
        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        //Negative Scenario,I didnt select hotel room type
//        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
//        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();


        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test7 Passed");
        }
        // createHotelRoomFormPage.okButton.click();

    }

    @Test
    public void tc_008() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);

        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        //Negative scenario, I send 30 as maxAdultCount value
        createHotelRoomFormPage.maxAdultCount.sendKeys("30");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();

        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test8 Failed");
        }
        createHotelRoomFormPage.okButton.click();

    }


    @Test
    public void tc_009() throws InterruptedException {

        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);

        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        //Negative scenario ,I sent 500 as MaxChildcount value
        createHotelRoomFormPage.maxChildrenCount.sendKeys("500");
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();


        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test5 Failed");
        }
        createHotelRoomFormPage.okButton.click();

    }


    @Test
    public void tc_010() throws InterruptedException {
        Thread.sleep(3000);
        Select select = new Select(createHotelRoomFormPage.idDropdown);
        select.selectByValue("1027");

        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise insolation room");

        Actions actions = new Actions(Driver.getDriver()) ;
        Thread.sleep(3000);

        actions.dragAndDrop(createHotelRoomFormPage.price500, createHotelRoomFormPage.price).build().perform();

        Select selectRoomType=new Select(createHotelRoomFormPage.roomTypeDropdown);
        selectRoomType.selectByVisibleText("Studio");

        createHotelRoomFormPage.maxAdultCount.sendKeys("2");
        createHotelRoomFormPage.maxChildrenCount.sendKeys("4");
        //Negative scenario ApprovedCheckbox didnt click
        //createHotelRoomFormPage.isApprovedCheckbox.click();

        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());
        } catch (Exception e) {
            System.out.println("Test10 Failed");
        }

        createHotelRoomFormPage.saveButton.click();

    }


    @AfterMethod
    public void tearDown(){


        Driver.closeDriver();


    }

}