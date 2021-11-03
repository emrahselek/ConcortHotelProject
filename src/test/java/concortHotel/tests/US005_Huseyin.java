package concortHotel.tests;

import concortHotel.pages.GoogleMain;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US005_Huseyin {
    @Test(skipFailedInvocations = true)
    public void deneme() throws IOException {
        Driver.getDriver().get("https://www.google.com/");
        GoogleMain googleMain = new GoogleMain();
        googleMain.googleSearchBox.sendKeys("iphone" + Keys.RETURN);
        boolean isTrue = Driver.getDriver().getTitle().contains("huseyin");
        if (!isTrue) {
            ReusableMethods.getScreenshot("huseyin");
            System.out.println("Title assertion doesn't match");
        }
        Assert.assertTrue(isTrue);

        Driver.getDriver().get("https://www.google.com/");
        googleMain.googleSearchBox.sendKeys("iphone" + Keys.RETURN);
        boolean isOk = Driver.getDriver().getTitle().contains("huseyin");
        if (!isOk) {
            ReusableMethods.getScreenshot("iphone");
            System.out.println("Title assertion doesn't match");
        }
        Assert.assertTrue(isOk);
    }
}
