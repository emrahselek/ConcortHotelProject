package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateRoomReservationPage {

    public CreateRoomReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    //add room reservation
    @FindBy (xpath = "//span[@class=\"hidden-480\"]")
    public WebElement addRoomReservation;

    //price
    @FindBy (xpath = "//input[@id=\"Price\"]")
    public WebElement price;

    //IDUser First
    @FindBy (xpath = "//select[@id=\"IDUser\"]")
    public WebElement firstSelectIdUSer;

    //IDUser Second
    @FindBy (xpath = "//select[@id=\"IDHotelRoom\"]")
    public WebElement secondSelectIdUSer;

    //DateStart
    @FindBy (xpath = "//input[@id=\"DateStart\"]")
    public WebElement dateStart;

    //DateEnd
    @FindBy (xpath = "//input[@id=\"DateEnd\"]")
    public WebElement dataEnd;

    //AdultAmount
    @FindBy (xpath = "//input[@id=\"AdultAmount\"]")
    public WebElement adultAmount;

    //ChildrenAmount
    @FindBy (xpath = "//input[@id=\"ChildrenAmount\"]")
    public WebElement childrenAmount;

    //Contact Name Surname
    @FindBy (xpath = "//input[@id=\"ContactNameSurname\"]")
    public WebElement contactNameSurname;

    //Contact Phone
    @FindBy (xpath = "//input[@id=\"ContactPhone\"]")
    public WebElement contactPhone;

    //Contact Email
    @FindBy (xpath = "//input[@id=\"ContactEmail\"]")
    public WebElement contactEmail;

    //Notes
    @FindBy(xpath = "//input[@id=\"Notes\"]")
    public WebElement notes;

    //Approved
    @FindBy (xpath = "//input[@id=\"Approved\"]")
    public WebElement approved;

    //ispaid
    @FindBy(xpath = "//input[@id=\"IsPaid\"]")
    public WebElement isPaid;

    //save button
    @FindBy(xpath = "//button[@id=\"btnSubmit\"]")
    public WebElement saveButton;

    //successfully message
    @FindBy(xpath = "//div[.='RoomReservation was inserted successfully']")
    public WebElement popupMessage;

    //error message
    @FindBy (xpath = "//label[.='Please provide correct email address']")
    public WebElement emailError;

    //contact phone mesasge esser
    @FindBy (xpath = "//label[normalize-space()='Contact Phone']")
    public WebElement contactPhoneError;


    //ok popup
    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    public WebElement clickOk;

}