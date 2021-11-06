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