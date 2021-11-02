package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CreateHotelRoomFormPage {

    public CreateHotelRoomFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
