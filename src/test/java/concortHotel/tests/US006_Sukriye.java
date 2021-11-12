package concortHotel.tests;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import concortHotel.pages.*;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
    public void tc_001()  {
        ReusableMethods.waitFor(3);
        ReusableMethods.seletFromDropDown(createHotelRoomFormPage.idDropdown,"1027");
        createHotelRoomFormPage.code.sendKeys("RC001");
        createHotelRoomFormPage.name.sendKeys("Sweat Dream");
        createHotelRoomFormPage.location.sendKeys("Downtown-Philadelphia");
        createHotelRoomFormPage.description.sendKeys("Noise isolation room");
        ReusableMethods.actionDragDrop(createHotelRoomFormPage.price500,createHotelRoomFormPage.price);
        ReusableMethods.selectFromDropDown(createHotelRoomFormPage.roomTypeDropdown,"Studio");
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

    @DataProvider
    public Object[][] getData(){
        String [][] roomCreatingData={
                //{Select room,code,name,location,description,roomPrice,roomTypeDropdown,maxAdult,maxChild}
                {"Select Hotel","RC001","Sweat Dream","Downtown-Philadelpia","Noise isolation room","Studio","2","4"},
                {"Cizgi Dusler Hotel","","Sweat Dream","Downtown-Philadelpia","Noise isolation room","Studio","2","4"},
                {"Cizgi Dusler Hotel","RC001","","Downtown-Philadelpia","Noise isolation room","Studio","2","4"},
                {"Cizgi Dusler Hotel","RC001","Sweat Dream","","Noise isolation room","Studio","2","4"},
                {"Cizgi Dusler Hotel","RC001","Sweat Dream","Downtown-Philadelpia","","Studio","2","4"},
                {"Cizgi Dusler Hotel","RC001","Sweat Dream","Downtown-Philadelpia","Noise isolation room","","2","4"},
                {"Cizgi Dusler Hotel","RC001","Sweat Dream","Downtown-Philadelpia","Noise isolation room","Studio","100","4"},
                {"Cizgi Dusler Hotel","RC001","Sweat Dream","Downtown-Philadelpia","Noise isolation room","Studio","2","500"},

        };
        return roomCreatingData;

    }

    @Test(dataProvider = "getData")
    public void creatRoom(String selectHotelRoom, String code, String name, String location, String description,String roomTypeDropdown, String maxAdult, String maxChild){
        ReusableMethods.selectFromDropDown(createHotelRoomFormPage.idDropdown,selectHotelRoom);
        createHotelRoomFormPage.code.sendKeys(code);
        createHotelRoomFormPage.name.sendKeys(name);
        createHotelRoomFormPage.location.sendKeys(location);
        createHotelRoomFormPage.description.sendKeys(description);
        ReusableMethods.actionDragDrop(createHotelRoomFormPage.price500,createHotelRoomFormPage.price);
        ReusableMethods.selectFromDropDown(createHotelRoomFormPage.roomTypeDropdown,roomTypeDropdown);
        createHotelRoomFormPage.maxAdultCount.sendKeys(maxAdult);
        createHotelRoomFormPage.maxChildrenCount.sendKeys(maxChild);
        createHotelRoomFormPage.isApprovedCheckbox.click();
        createHotelRoomFormPage.saveButton.click();

        try {
            WebDriverWait wait=new WebDriverWait(Driver.getDriver(),2);
            WebElement popupMessageElement=wait.until(ExpectedConditions.visibilityOf(createHotelRoomFormPage.popupMessage));
            Assert.assertFalse(popupMessageElement.isDisplayed());

        } catch (Exception e) {
            System.out.println("Tests Failed");
        }

    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();

    }

}