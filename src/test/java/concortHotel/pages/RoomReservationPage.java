package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class RoomReservationPage {

    public RoomReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
