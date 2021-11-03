package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class EditRoomReservationPage {

    public EditRoomReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
