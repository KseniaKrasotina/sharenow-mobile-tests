import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import page_object.Android.*;

import java.util.Set;

public class RegistrationTests extends BaseDriver {

    @BeforeClass
    public static void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public static void tearDown() throws Exception {
    //TODO: Remove also test data from DB
        driver.quit();
    }

    // User can see register button from Menu entry (Start Now > Register)
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

    //User lands on Payment page after saving personal data
    @Test
    public void landsPaymentPageSuccessfull() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickStartNow();

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickNewRegister();

        //waiting for the webview to load
        synchronized (driver) {
            driver.wait(5000);
        }

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }

        driver.context("WEBVIEW_com.car2go");

        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);

        //fill the form with correct data
        registrationFormPage.typeEmail("rr10@rr.rr");
        registrationFormPage.selectCountry(RegistrationFormPage.Country.FR);
        registrationFormPage.typePhoneNumber("98767894213");
        registrationFormPage.selectYourTitle(RegistrationFormPage.Salutation.MRS);
        registrationFormPage.typeFirstName("Ksenia");
        registrationFormPage.typeLastName("Krasotina");
        registrationFormPage.typePassword("45678990");
        registrationFormPage.typePin("4455");

        //TODO: make more beautiful code: year 2002(2) -> 1926(78), 1978(26)
        registrationFormPage.selectBirthDate(12,9,26);
        registrationFormPage.typeBirthPlace("Russia, Novosibirsk");
        registrationFormPage.typeAddressStreet("Parkhomenko, 00");
        registrationFormPage.typePostalCode("10179");
        registrationFormPage.typeTown("Paris");

        registrationFormPage.checkTermsAndConditions();
        registrationFormPage.clickRegisterNowButton();

        PaymenPage paymentPage = new PaymenPage(driver);
        Assert.assertTrue(paymentPage.paymenPageFormIsDisplayed());
    }
}
