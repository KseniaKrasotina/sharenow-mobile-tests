package page_object.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    private AndroidDriver<AndroidElement> driver;

    public MenuPage() {
    }

    public MenuPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "loginRegisterButton")
    private AndroidElement StartNow;

    @AndroidFindBy(id = "settings")
    private AndroidElement Settings;

    public void clickStartNow() {
        StartNow.click();
    }

    public boolean isDisplayedStartNow() {
        return StartNow.isDisplayed();
    }
}
