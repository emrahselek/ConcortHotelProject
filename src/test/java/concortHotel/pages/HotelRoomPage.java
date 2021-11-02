package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomPage {

    public HotelRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


}
