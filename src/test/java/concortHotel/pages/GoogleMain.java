package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleMain {

public GoogleMain(){
    PageFactory.initElements(Driver.getDriver(),this);
}
    @FindBy(name = "q")
    public WebElement googleSearchBox;
}
