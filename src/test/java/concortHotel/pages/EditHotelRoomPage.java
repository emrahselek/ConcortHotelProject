package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditHotelRoomPage {

    public EditHotelRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "Code")
    public WebElement code;

    @FindBy(id = "Name")
    public WebElement name;

    @FindBy(id = "Location")
    public WebElement location;

    @FindBy(xpath = "//textarea[@dir='ltr']")
    public WebElement descriptionBox;

    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(xpath = "//li[@data-id='700']")
    public WebElement price700;

    @FindBy(id="IDGroupRoomType")
    public WebElement roomTypeDropdown;

    @FindBy(id ="MaxAdultCount")
    public WebElement adultCount;

    @FindBy(id = "MaxChildCount")
    public WebElement childCount;

    @FindBy(xpath = "//*[@id='IsAvailable']")
    public WebElement available;

    @FindBy(xpath = "(//button[.='Save'])[1]")
    public WebElement save;

    @FindBy(id ="btnDelete")
    public WebElement deleteBtn;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement popupMessage;

    @FindBy(xpath = "//button[@data-bb-handler='confirm']")
    public WebElement okBtn;

    @FindBy(xpath = "//button[@data-bb-handler='ok']")
    public WebElement okButton;








}
