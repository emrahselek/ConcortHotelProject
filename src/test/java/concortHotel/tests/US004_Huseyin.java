package concortHotel.tests;

import concortHotel.pages.GoogleMain;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US004_Huseyin {
    @Test(skipFailedInvocations = true)
    public void deneme() throws IOException {
        Driver.getDriver().get("https://www.google.com/");
        GoogleMain googleMain = new GoogleMain();
        googleMain.googleSearchBox.sendKeys("zaman" + Keys.RETURN);
        boolean isTrue = Driver.getDriver().getTitle().contains("zaman");
        if (!isTrue) {
            ReusableMethods.getScreenshot("huseyin");
            System.out.println("Title assertion doesn't match");
        }
        Assert.assertTrue(isTrue);

        Driver.getDriver().get("https://www.google.com/");
        googleMain.googleSearchBox.sendKeys("time" + Keys.RETURN);
        boolean isOk = Driver.getDriver().getTitle().contains("time");
        if (!isOk) {
            ReusableMethods.getScreenshot("huseyin");
            System.out.println("Title assertion doesn't match");
        }
        Assert.assertTrue(isOk);
    }
}