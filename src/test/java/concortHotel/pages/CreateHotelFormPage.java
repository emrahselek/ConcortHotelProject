package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateHotelFormPage {

    public CreateHotelFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Address")
    public WebElement address;

    @FindBy(id = "Phone")
    public WebElement phone;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "IDGroup")
    public WebElement idGroupDropdown;

    @FindBy(id = "btnSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "//div[.='Hotel was inserted successfully']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[.='Hotel with this code already exist']")
    public WebElement fakeDuplicateMessage;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement okButton;

    @FindBy(xpath = "//label[.='Code']")
    public WebElement codeMessage;

    @FindBy(xpath = "//label[.='Name']")
    public WebElement nameMessage;

    @FindBy(xpath = "//label[.='Address']")
    public WebElement addressMessage;

    @FindBy(xpath = "//label[.='Phone']")
    public WebElement phoneMessage;

    @FindBy(xpath = "//label[.='Email']")
    public WebElement emailMessage;

    @FindBy(xpath = "//label[.='Select Group']")
    public WebElement selectGroupMessage;
}
