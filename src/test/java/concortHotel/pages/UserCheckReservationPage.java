package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class UserCheckReservationPage {

    public UserCheckReservationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}