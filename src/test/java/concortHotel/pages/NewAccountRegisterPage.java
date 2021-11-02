package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class NewAccountRegisterPage {

    public NewAccountRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
