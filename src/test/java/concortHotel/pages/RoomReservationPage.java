package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomReservationPage {

    public RoomReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//tbody//tr[9]//td[14]/a")
    public WebElement details;

//    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[9]")
    //@FindBy(xpath = "//tbody/tr[9]/td[14]")
  //  @FindBy(xpath = "//tbody//tr[9]//td[14]/a")
 //   public WebElement details;

    //    @FindBy(xpath = "(//a[@class='btn btn-xs default'])[9]")
//    public WebElement details1;
////
////    @FindBy(xpath =//tbody//tr[1]//td[8] )
////






}