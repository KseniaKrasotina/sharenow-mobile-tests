package page_object.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PaymenPage {
    private AndroidDriver driver;

    public PaymenPage() {
    }

    public PaymenPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }

    public boolean paymenPageFormIsDisplayed() {
        var paymentForm = driver.findElement(By.xpath("//*[@data-test-id=\"registration-payment-form\"]"));
        return paymentForm.isDisplayed();
    }

}
