package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CreateHotelRoomPage {


    public CreateHotelRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
