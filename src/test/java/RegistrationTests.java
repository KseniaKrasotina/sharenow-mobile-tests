import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import page_object.Android.MainPage;
import page_object.Android.MenuPage;
import page_object.Android.RegistrationFormPage;
import page_object.Android.WelcomePage;

import java.util.Set;

public class RegistrationTests extends BaseDriver {

    @BeforeClass
    public static void setUp() throws Exception {
        prepareAndroidForAppium();
    }

//    @AfterClass
//    public static void tearDown() throws Exception {
//        driver.quit();
//    }


    //● User can see register button from Menu entry (Start Now > Register)
    @Test
    public void registerDisplayedSuccessfull() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickStartNow();

        WelcomePage welcomePage = new WelcomePage(driver);
        //User can see register button from Menu entry
        Assert.assertTrue(welcomePage.isDisplayedRegister());
    }


    @Test
    public void typeEmailSuccessfull() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickStartNow();

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickNewRegister();

//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.
//        driver.wait(5000);
        //Thread.sleep(5000);





        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }

        //driver.context("WEBVIEW_com.car2go");
        //Set<String> contextNames = driver.getContextHandles();
        driver.context((String) contextNames.toArray()[1]);
        //RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
        //registrationFormPage.typeEmail("rr@rr.rr");

        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);
        registrationFormPage.typeEmail2("rr@rr.rr");
        //registrationFormPage.clickSelectCountry();
    }
}
