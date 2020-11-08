package page_object.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private AndroidDriver<AndroidElement> driver;

    public MainPage() {
    }

    public MainPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "menuItem")
    private AndroidElement Menu;

    @AndroidFindBy(id = "listItem")
    private AndroidElement Vehicles;

    @AndroidFindBy(id = "radarItem")
    private AndroidElement Radar;

    @AndroidFindBy(id = "searchItem")
    private AndroidElement Search;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ImageButton")
    private AndroidElement NavigateButton;

    public void clickMenu() {
        Menu.click();
    }

    public void clickVehicles() {
        Vehicles.click();
    }

    public void clickRadar() {
        Radar.click();
    }

    public void clickSearch() {
        Search.click();
    }

    public void clickNavigate() {
        NavigateButton.click();
    }

    public boolean isDisplayedMenu() {
        return Menu.isDisplayed();
    }


}