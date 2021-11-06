package concortHotel.tests;

import concortHotel.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleUsageForSetUp {

    @BeforeMethod
    public void callSetUp(){
        MainPage.setUp("manager1_user","manager1_password");
    }

    @Test
    public void testExample(){

    }
}
