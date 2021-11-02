package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CreateHotelPage {

    public CreateHotelPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
