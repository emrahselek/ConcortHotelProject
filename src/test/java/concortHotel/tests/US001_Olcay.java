package concortHotel.tests;

import concortHotel.pages.MainPage;
import concortHotel.utilities.ConfigReader;
import concortHotel.utilities.Driver;
import concortHotel.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class US001_Olcay {
    MainPage mainPage;

    @Test
    public void us001_tc001() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        mainPage.navHome.click();
        String homeTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(homeTitle.contains("Concort Hotel - Home"));
        String homeUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(homeUrl.contains("https://qa-environment.concorthotel.com/"));
        mainPage.navRooms.click();
        String roomsTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(roomsTitle.contains("Concort Hotel - Rooms"));
        mainPage.navRestaurant.click();
        String restaurantTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(restaurantTitle.contains("Restaurant"));
        ReusableMethods.waitFor(1);
        mainPage.navAbout.click();
        String aboutTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(aboutTitle.contains("About"));
        mainPage.navBlog.click();
        String blogTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(blogTitle.contains("Blog"));
        mainPage.navContact.click();
        String contactTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(contactTitle.contains("Contact"));
        mainPage.logInLink.click();
        String loginTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(loginTitle.contains("Log in"));

    }

    @Test
    public void us001_tc002() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_qa"));
        mainPage = new MainPage();
        mainPage.bottomBlog.click();
        System.out.println(Driver.getDriver().getTitle());
        System.out.println(Driver.getDriver().getCurrentUrl());
        String blogTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(blogTitle.contains("Blog"));
        mainPage.bottomRooms.click();
        String roomsTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(roomsTitle.contains("Rooms"));
        mainPage.bottomAmenitiesTest.click();
        String amenitiesTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(amenitiesTitle.contains("Amenities"));
        mainPage.bottomGiftCard.click();
        String giftCardTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(giftCardTitle.contains("Gift"));
        ReusableMethods.waitFor(1);
        mainPage.bottomCareer.click();
        String careerTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(careerTitle.contains("Career"));
        mainPage.bottomAboutUs.click();
        String aboutUsTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(aboutUsTitle.contains("About"));
        mainPage.bottomContactUs.click();
        String contactUsTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(contactUsTitle.contains("Contact"));
        ReusableMethods.waitFor(1);
        mainPage.bottomServices.click();
        String servicesTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(servicesTitle.contains("Services"));
        mainPage.bottomPhoneNumber.click();
        String phoneTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(phoneTitle.contains("Phone"));
        mainPage.bottomEmailLink.click();
        String emailTitle = Driver.getDriver().getTitle();
        Assert.assertFalse(emailTitle.contains("Email"));

    }

    @AfterMethod()
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            ReusableMethods.getScreenshot("US001_Olcay");
        }
        Driver.closeDriver();
    }

}





