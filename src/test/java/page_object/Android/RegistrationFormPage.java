package page_object.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormPage {
    private AndroidDriver driver;

    public RegistrationFormPage() {
    }

    public RegistrationFormPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//select[@name=\"addressCountryIsoCode\"]")
    private AndroidElement SelectCountry;

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement Email;

    public void clickSelectCountry() {
        SelectCountry.click();
    }

    public void selectCountry(Integer country) {
        SelectCountry.setId(String.valueOf(country));
    }

    public void typeEmail(String email) {
        Email.clear();
        Email.sendKeys(email);
    }

}
