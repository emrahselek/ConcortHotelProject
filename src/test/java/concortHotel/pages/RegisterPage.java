package concortHotel.pages;

import concortHotel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class RegisterPage {

    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (id = "UserName")
    public WebElement userName;

    @FindBy (id = "Password")
    public WebElement password;

    @FindBy (id = "Email")
    public WebElement email;

    @FindBy (id = "NameSurname")
    public WebElement fullName;

    @FindBy (id = "PhoneNo")
    public WebElement phoneNo;

    @FindBy (id = "SSN")
    public WebElement socialSecurityNumber;

    @FindBy (id = "DrivingLicense")
    public WebElement drivingLicenseNo;

    @FindBy (id = "IDCountry")
    public WebElement idCountry;

    @FindBy (id = "IDState")
    public WebElement idState;

    @FindBy (id = "Address")
    public WebElement address;

    @FindBy (id = "WorkingSector")
    public WebElement workingSector;

    @FindBy (id = "BirthDate")
    public WebElement birthDate;

    @FindBy (id = "btnSubmit")
    public WebElement saveButton;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement messageWhenSaveClicked;

    @FindBy(xpath = "//label[@class='error']")
    public  WebElement errorMessage;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public  WebElement okButton;

    @FindBy(id = "DescriptionDiv")
    public  WebElement messageWhenOkClicked;



    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    LocalDate currentDate = LocalDate.now();
    LocalDate dOBforAgeSmallerThenEighteen = LocalDate.now().minusYears(5);
    LocalDate dOBforAgeisAfterTodayDate = LocalDate.now().plusMonths(10);

    public String dateForDOBIsSmaller18 = formatter.format(dOBforAgeSmallerThenEighteen);
    public String todayDate = formatter.format(currentDate);
    public String dateForDOBAfterCurrentDate = formatter.format(dOBforAgeisAfterTodayDate);


    public boolean isAgeBiggerThen18(){
        Period period= Period.between(dOBforAgeSmallerThenEighteen,currentDate);
        return period.getYears()<18;
    }

    public boolean isDOBAfterToday(){
        Period period= Period.between(dOBforAgeisAfterTodayDate,currentDate);
        return dOBforAgeisAfterTodayDate.isAfter(currentDate);
    }

    public Object[][] requiredDataForNegativeTest(){
        String[][] userData={
                //username,         phone,          SSN,    DrivingLicence, Country,   States,    address  ,   working sector, dob
                {"", "1234567899","123456789", "12345", "United States", "New York","123 Apple Street", "IT Manager", "11/2/1980"},
                {"Thomas Watson", "","123456789", "12345", "United States", "New York","123 Apple Street", "IT Manager", "11/2/1980"},
                {"Thomas Watson", "1234567899","", "12345", "United States", "New York","123 Apple Street", "IT Manager", "11/2/1980"},
                {"Thomas Watson", "1234567899","123456789", "", "United States", "New York","123 Apple Street", "IT Manager", "11/2/1980"},
                {"Thomas Watson", "1234567899","123456789", "12345", "United States", "Select state","123 Apple Street", "IT Manager", "11/2/1980"},
                {"Thomas Watson", "1234567899","123456789", "12345", "United States", "New York","", "IT Manager", "11/2/1980"},
                {"Thomas Watson", "1234567899","123456789", "12345", "United States", "New York","123 Apple Street", "", "11/2/1980"},
                {"Thomas Watson", "1234567899","123456789", "12345", "United States", "New York","123 Apple Street", "IT Manager", ""},

        };
        return userData;
    }
}
