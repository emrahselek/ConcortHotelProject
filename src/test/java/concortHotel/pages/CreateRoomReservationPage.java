package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CreateRoomReservationPage {

    public CreateRoomReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
