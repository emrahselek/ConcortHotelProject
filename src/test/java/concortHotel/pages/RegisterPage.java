package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (id = "UserName")
    public WebElement userName;

    @FindBy (id = "Password")
    public WebElement password;

    @FindBy (id = "Email")
    public WebElement email;

    @FindBy (id = "NameSurname")
    public WebElement fullName;

    @FindBy (id = "PhoneNo")
    public WebElement phoneNo;

    @FindBy (id = "SSN")
    public WebElement socialSecurityNumber;

    @FindBy (id = "DrivingLicense")
    public WebElement drivingLicenseNo;

    @FindBy (id = "IDCountry")
    public WebElement idCountry;

    @FindBy (id = "IDState")
    public WebElement idState;

    @FindBy (id = "Address")
    public WebElement address;

    @FindBy (id = "WorkingSector")
    public WebElement workingSector;

    @FindBy (id = "BirthDate")
    public WebElement birthDate;

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement messageWhenSaveClicked;

    @FindBy(xpath = "//label[@class='error']")
    public  WebElement errorMessage;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public  WebElement okButton;

    @FindBy(id = "DescriptionDiv")
    public  WebElement messageWhenOkClicked;

}
