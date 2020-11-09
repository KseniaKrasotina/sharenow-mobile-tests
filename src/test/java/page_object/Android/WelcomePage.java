package page_object.Android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    private AndroidDriver<AndroidElement> driver;

    public WelcomePage() {
    }

    public WelcomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "cardNewRegistration")
    private AndroidElement NewRegister;

    public void clickNewRegister() throws InterruptedException {
        NewRegister.click();
        //driver.wait(1000);
   }

    public boolean isDisplayedRegister() {
        return NewRegister.isDisplayed();
    }

    public static boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, String targetResourceId){

        try{
            var mobileElement =  (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+targetResourceId+"\")");
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            var isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        }catch(Exception e){
            var isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        } }
}
