package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditRoomReservationPage {

    public EditRoomReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "IDHotelRoom")
    public WebElement idHotelRoom;

    @FindBy(id = "IDUser")
    public WebElement idUser;



    @FindBy(id = "Price")
    public WebElement price;

    @FindBy(id = "DateEnd")
    public WebElement dateEnd;

    @FindBy(id = "ContactNameSurname")
    public WebElement contactNameSurname;

    @FindBy(id = "ContactEmail")
    public WebElement contactEmail;

    @FindBy(id = "Notes")
    public WebElement notes;


    @FindBy(xpath = "(//button[.='Save'])[1]")
    public WebElement saveButton;

    //@FindBy(xpath = "(//button[.='Save'])[1]")
    //  @FindBy(id="btnSubmit")
}