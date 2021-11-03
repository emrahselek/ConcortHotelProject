package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CreateHotelFormPage {

    public CreateHotelFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
