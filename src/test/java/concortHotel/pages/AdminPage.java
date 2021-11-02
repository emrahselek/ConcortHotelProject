package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
