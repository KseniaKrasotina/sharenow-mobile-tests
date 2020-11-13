import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseDriver {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.18.3");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "/Users/kkrasotina/ShareNow-tests/bin/com.car2go_4.24.2(562089)_arm64-v8a,armeabi-v7a,x86,x86_64.apk");
        capabilities.setCapability("appPackage", "com.car2go");
        capabilities.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


}