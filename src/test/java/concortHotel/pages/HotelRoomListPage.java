package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomListPage {

    public HotelRoomListPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(partialLinkText = "HotelRoomAdmin")
    public WebElement details;

    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[8]")
    public WebElement details1;

    @FindBy(xpath = "//tbody//tr[1]//td[9]/a")
    public WebElement details2;

}
