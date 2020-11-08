package page_object.Android;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormPage {
    private WebDriver driver;

    public RegistrationFormPage() {
    }

    public RegistrationFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "camelot-select-52072")
    private WebElement SelectCountry;

    @AndroidFindBy(xpath = "//input[@name=\"email\"]")
    private WebElement Email;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[8]/android.view.View/android.widget.EditText")
    private WebElement Email2;

    public void clickSelectCountry() {
        SelectCountry.click();
    }

    public void typeEmail(String email) {
        Email.clear();
        Email.sendKeys(email);
    }

    public void typeEmail2(String email) {
        Email2.clear();
        Email2.sendKeys(email);
    }


}
