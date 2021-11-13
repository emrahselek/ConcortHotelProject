package concortHotel.tests;

import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US007_Merve {

    MainPage mainPage;
    LoginPage loginpage;
    AdminPage adminPage;
    HotelRoomListPage hotelRoomListPage;
    EditHotelRoomPage editHotelRoomPage;


    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        loginpage = new LoginPage();
        adminPage = new AdminPage();
        mainPage.logInLink.click();
        loginpage.username.sendKeys(ConfigReader.getProperty("manager1_user"));
        loginpage.password.sendKeys(ConfigReader.getProperty("manager1_password"));
        loginpage.loginButton.click();
        adminPage.hotelManagement.click();
        adminPage.hotelRoomsLink.click();
        ReusableMethods.waitFor(3);
        hotelRoomListPage = new HotelRoomListPage();
        hotelRoomListPage.details2.click();


    }
    @Test
    public void us007_tc01(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.code.clear();
        editHotelRoomPage.code.sendKeys("2021");
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());

    }
    @Test
    public void us007_tc02(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.name.clear();
        editHotelRoomPage.name.sendKeys("Prince");
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());

    }
    @Test
    public void us007_tc03(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.location.clear();
        editHotelRoomPage.location.sendKeys("Canada");
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());
    }
    @Test
    public void us007_tc04(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.descriptionBox.clear();
        editHotelRoomPage.descriptionBox.sendKeys("Very comfort room");
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());

    }
    @Test
    public void us007_tc05() throws InterruptedException {
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.price.clear();
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(10000);
        actions.dragAndDrop(editHotelRoomPage.price700,editHotelRoomPage.price).build().perform();
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());
    }
    @Test
    public  void us007_tc06(){
        editHotelRoomPage = new EditHotelRoomPage();
        Select roomTypeDropdown = new Select(editHotelRoomPage.roomTypeDropdown);
        roomTypeDropdown.selectByVisibleText("King");
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());
    }
    @Test
    public void us007_tc07(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.adultCount.clear();
        editHotelRoomPage.adultCount.sendKeys("2");
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());
    }
    @Test
    public void us007_tc08(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.childCount.clear();
        editHotelRoomPage.childCount.sendKeys("3");
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());

    }
    @Test
    public void us007_tc09(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.available.click();
        editHotelRoomPage.save.click();
        ReusableMethods.waitFor(3);
        Boolean successfullymessage = Driver.getDriver().getPageSource().contains("HotelRoom was updated successfully");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(successfullymessage.booleanValue());
    }
    @Test
    public void us007_tc10(){
        editHotelRoomPage = new EditHotelRoomPage();
        editHotelRoomPage.deleteBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement popupMessageElement = wait.until(ExpectedConditions.visibilityOf(editHotelRoomPage.popupMessage));
        Assert.assertEquals(editHotelRoomPage.popupMessage.getText(),"Would you like to continue?");
        editHotelRoomPage.okBtn.click();
        Boolean errorMessage = Driver.getDriver().getPageSource().contains("Error");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(errorMessage.booleanValue());
        editHotelRoomPage.okButton.click();

    }
    @AfterMethod
    public void teardown(ITestResult result){
//            if (ITestResult.FAILURE == result.getStatus()) {
//                ReusableMethods.getScreenshot(US007_Merve);
//            }
        Driver.closeDriver();

    }}