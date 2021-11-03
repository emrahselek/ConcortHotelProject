package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class EditHotelPage {

    public EditHotelPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
