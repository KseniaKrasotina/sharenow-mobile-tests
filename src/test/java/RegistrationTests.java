import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page_object.Android.*;

import java.util.Set;

public class RegistrationTests extends BaseDriver {

    @BeforeEach
    public void setUp() throws Exception {
        if(driver != null) driver.quit();
        prepareAndroidForAppium();
    }

    // After each test we close the driver. It makes tests independent from each other, but slower.
    // Alternative approach:
    // we can keep the driver running, but in this case we have to restart the app or at least navigate to the home screen after each test.
    @AfterEach
    public void tearDown() throws Exception {
    //TODO: Remove test data from DB as well
        synchronized (driver) {
            driver.wait(2000);
        }
        driver.quit();
    }

    @Test
    @Description("1. User can see register button from Menu entry (Start Now > Register)")
    public void registerDisplayedSuccessful() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickStartNow();

        WelcomePage welcomePage = new WelcomePage(driver);
        //User can see register button from Menu entry
        Assert.assertTrue(welcomePage.isDisplayedRegister());
    }

    @Test
    @Description("2. User lands on Payment page after saving personal data")
    public void landsPaymentPageSuccessful() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickStartNow();

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickNewRegister();

        //waiting for the webview to load
        synchronized (driver) {
            driver.wait(2000);
        }

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.car2go");

        RegistrationFormPage registrationFormPage = new RegistrationFormPage(driver);

        //fill the form with correct data
        registrationFormPage.typeEmail("rr11@rr.rr");
        registrationFormPage.selectCountry(RegistrationFormPage.Country.FR);
        registrationFormPage.typePhoneNumber("111111111111111");
        registrationFormPage.selectYourTitle(RegistrationFormPage.Salutation.MRS);
        registrationFormPage.typeFirstName("Ksenia");
        registrationFormPage.typeLastName("Krasotina");
        registrationFormPage.typePassword("45678990");
        registrationFormPage.typePin("4455");

        //TODO: make more clean code: year 2002(2) -> 1926(78), 1978(26)
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
