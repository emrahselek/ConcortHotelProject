package concortHotel.pages;

import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Log in")
    public WebElement logInLink;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement navHome;

    @FindBy(xpath = "(//a[.='Rooms'])[1]")
    public WebElement navRooms;

    @FindBy(xpath = "//a[.='Restaurant']")
    public WebElement navRestaurant;

    @FindBy(xpath = "(//a[.='About'])[1]")
    public WebElement navAbout;

    @FindBy(xpath = "(//a[.='Blog'])[1]")
    public WebElement navBlog;

    @FindBy(xpath = "(//a[.='Contact'])[1]")
    public WebElement navContact;

    @FindBy(xpath = "(//a[.='Blog'])[2]")
    public WebElement bottomBlog;

    @FindBy(xpath = "(//a[.='Rooms'])[2]")
    public WebElement bottomRooms;

    @FindBy(xpath = "//a[.='Amenities test']")
    public WebElement bottomAmenitiesTest;

    @FindBy(xpath = "//a[.='Gift Card']")
    public WebElement bottomGiftCard;

    @FindBy(xpath = "//a[.='Career']")
    public WebElement bottomCareer;

    @FindBy(xpath = "//a[.='About Us']")
    public WebElement bottomAboutUs;

    @FindBy(xpath = "//a[.='Contact Us']")
    public WebElement bottomContactUs;

    @FindBy(xpath = "//a[.='Services']")
    public WebElement bottomServices;

    @FindBy(xpath = "//span[.='302 718 2180']")
    public WebElement bottomPhoneNumber;

    @FindBy(xpath = "//span[.='info@concorthotel.com']")
    public WebElement bottomEmailLink;

    public static void setUp(String username, String password) {

        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.logInLink.click();
        loginPage.username.sendKeys(ConfigReader.getProperty(username));
        loginPage.password.sendKeys(ConfigReader.getProperty(password));
        loginPage.loginButton.click();

    }
}