package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HotelRoomListPage {

    public HotelRoomListPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
