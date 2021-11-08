package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(partialLinkText = "Hotel List")
    public WebElement hotelListLink;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement usernameRightTop;

    @FindBy(xpath = "//span[.= 'Hotel Management']")
    public WebElement hotelManagementTab;

    @FindBy(partialLinkText = "Room reservations")
    public WebElement roomReservationsLink;

}
