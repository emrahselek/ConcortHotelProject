package concortHotel.tests;
import com.github.javafaker.Faker;
import concortHotel.pages.LoginPage;
import concortHotel.pages.MainPage;
import concortHotel.pages.RegisterPage;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.*;
public class US003_Huseyin {

    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        loginPage = new LoginPage();
        mainPage.logInLink.click();
        loginPage.createNewAccount.click();
    }

    @Test
    public void tc_0001(){
    registerPage = new RegisterPage();
    String name = faker.name().firstName();
    registerPage.userName.sendKeys(name+"12");
    registerPage.password.sendKeys("Sa174656!");
    registerPage.email.sendKeys(faker.internet().emailAddress());
    registerPage.fullName.sendKeys(name+ " Araba");
    registerPage.phoneNo.sendKeys("1234567899");
    registerPage.socialSecurityNumber.sendKeys("123456789");
    registerPage.drivingLicenseNo.sendKeys("12345");
    ReusableMethods.selectFromDropDown(registerPage.idCountry,"Canada");
    registerPage.address.sendKeys("123 Apple Street");
    registerPage.workingSector.sendKeys("IT");
    registerPage.birthDate.sendKeys("11/2/1980");
    registerPage.saveButton.click();
    ReusableMethods.waitFor(1);
    registerPage.okButton.click();
    ReusableMethods.waitFor(1);
    assertTrue(registerPage.messageWhenOkClicked.getText().contains("inserted successfully"));

    }

    @Test
    public void tc_0002(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys(name + " Araba");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        registerPage.okButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.messageWhenOkClicked.getText().contains("inserted successfully"));

    }

    @Test
    public void tc_0003(){
        registerPage = new RegisterPage();
        registerPage.userName.sendKeys("Thomas");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.messageWhenSaveClicked.getText().contains("already taken"));

    }

    @Test
    public void tc_0004(){
        registerPage = new RegisterPage();
        registerPage.userName.sendKeys("Tom");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.getText().contains("at least 4 characters"));
    }

    @Test
    public void tc_0005(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa1!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.getText().contains("at least 5 characters long"));
    }

    @Test
    public void tc_0006(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Saq12");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.getText().contains("one special character"));
    }

    @Test
    public void tc_0007(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("aq12!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.getText().contains("one uppercase character"));
    }

    @Test
    public void tc_0008(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("AQ12!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.getText().contains("one lowercase character"));
    }

    @Test
    public void tc_0009(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys("abc@hotmail.com");
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.messageWhenSaveClicked.getText().contains("already taken"));
    }

    @Test
    public void tc_0010(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("123456789");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.getText().contains("Please enter phone number"));
    }

    @Test
    public void tc_0011(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("12345678");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys("11/2/1980");
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.getText().contains("This field is required"));
    }

    @Test
    public void tc_0012() {
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys(registerPage.dateForDOBIsSmaller18);
        registerPage.saveButton.click();

        ReusableMethods.waitFor(1);
        boolean isSuccessful =registerPage.messageWhenSaveClicked.getText().contains("inserted successfully");
        if(isSuccessful && registerPage.isAgeBiggerThen18()){
            assertFalse(isSuccessful,"Age is smaller than 18. Law requires age should be bigger than 18");
        }

    }


    @Test
    public void tc_0013(){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys("Thomas Art");
        registerPage.phoneNo.sendKeys("1234567899");
        registerPage.socialSecurityNumber.sendKeys("123456789");
        registerPage.drivingLicenseNo.sendKeys("12345");
        ReusableMethods.selectFromDropDown(registerPage.idCountry,"United States");
        ReusableMethods.selectFromDropDown(registerPage.idState,"New York");
        registerPage.address.sendKeys("123 Apple Street");
        registerPage.workingSector.sendKeys("IT");
        registerPage.birthDate.sendKeys(registerPage.dateForDOBAfterCurrentDate);
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        boolean isSuccessful =registerPage.messageWhenSaveClicked.getText().contains("inserted successfully");
        if(isSuccessful && registerPage.isDOBAfterToday()){
            assertFalse(isSuccessful,"Date of Birth can not be after Today's date");
        }

    }

    @DataProvider
    public Object[][] getData() {
        registerPage = new RegisterPage();
        return registerPage.requiredDataForNegativeTest();
    }

    @Test(dataProvider = "getData")
    public void tc_0014(String fullName,String phoneNumber,String SSN,String drivingLicence,String country, String states, String address, String workingSector, String dob){
        registerPage = new RegisterPage();
        String name = faker.name().firstName();
        registerPage.userName.sendKeys(name+"12");
        registerPage.password.sendKeys("Sa174656!");
        registerPage.email.sendKeys(faker.internet().emailAddress());
        registerPage.fullName.sendKeys(fullName);
        registerPage.phoneNo.sendKeys(phoneNumber);
        registerPage.socialSecurityNumber.sendKeys(SSN);
        registerPage.drivingLicenseNo.sendKeys(drivingLicence);
        ReusableMethods.selectFromDropDown(registerPage.idCountry,country);
        ReusableMethods.selectFromDropDown(registerPage.idState,states);
        registerPage.address.sendKeys(address);
        registerPage.workingSector.sendKeys(workingSector);
        registerPage.birthDate.sendKeys(dob);
        registerPage.saveButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(registerPage.errorMessage.isDisplayed());

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        ReusableMethods.getScreenshotIfFails(result);
        Driver.closeDriver();
    }

}
