package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelListPage {

    public HotelListPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//span[.='Add Hotel ']")
    public WebElement addHotel;

    @FindBy(name = "Code")
    public WebElement codeTextBox;

    @FindBy(xpath = "//button[.='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//tbody/tr[1]/td[8]/a[1]")
    public WebElement details;

    @FindBy(id ="lkpGroups")
    public WebElement idGroupDropdown;


}
