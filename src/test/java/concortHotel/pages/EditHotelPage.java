package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditHotelPage {

    public EditHotelPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(xpath = "//input[@id='Name']")
    public WebElement name;

    @FindBy(xpath = "//input[@id='Address']")
    public WebElement address;

    @FindBy(xpath = "//input[@id='Phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement email;

    @FindBy(xpath = "//select[@id='IDGroup']")
    public WebElement group;

    @FindBy(xpath = "(//button[.='Save'])[1]")
    public WebElement save;



}
