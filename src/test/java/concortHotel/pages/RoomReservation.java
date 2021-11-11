package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomReservation {
    public RoomReservation(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id="checkin_date")
    public WebElement checkIn;

    @FindBy(id="checkout_date")
    public WebElement checkOut;

    @FindBy(id="IDRoomType")
    public WebElement room;

    @FindBy(id="AdultCount")
    public WebElement customer;

    @FindBy(xpath = "//input[@value=\"Check Availability\"]")
    public WebElement ava;


    @FindBy(xpath ="//div[@class=\"col-lg-8\"]//div[2]//div[1]//div[1]//h3[1]")
    public WebElement booking;

    @FindBy(xpath = "//div[@class=\"row\"]//a[contains(text(),\"Log in\")]")
    public WebElement log;




    @FindBy(id="checkin_date")
    public WebElement In;

    @FindBy(id="checkout_date")
    public WebElement Out;

    @FindBy(id="AdultCount")
    public WebElement adult;

    @FindBy(id="ChildrenCount")
    public WebElement child;

    @FindBy(id="NameSurname")
    public WebElement name;

    @FindBy(id="EmailAddress")
    public WebElement email;


    @FindBy(id="PhoneNumber")
    public WebElement phone;

    @FindBy(id="NameOnCreditCard")
    public WebElement cardName;

    @FindBy(id="CreditCardNumber")
    public WebElement number;

    @FindBy(id="CreditCardExpirationYear")
    public WebElement year;

    @FindBy(id="CreditCardExpirationMonth")
    public WebElement month;

    @FindBy(id="CVV")
    public WebElement cvv;

    @FindBy(id="Message")
    public WebElement message;

    @FindBy(xpath = "//input[@value=\"Book this room\"]")
    public WebElement bookThisRoom;

    @FindBy(xpath = "//div[@class=\"bootbox-body\"]//a[contains(text(),\"here\")]")
    public WebElement here;
}
