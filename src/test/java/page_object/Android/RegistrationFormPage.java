package page_object.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class RegistrationFormPage {
    private AndroidDriver driver;

    public RegistrationFormPage() {
    }

    public RegistrationFormPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver,10, TimeUnit.SECONDS), this);
    }

    @FindBy(xpath = "//select[@name=\"addressCountryIsoCode\"]")
    private AndroidElement SelectCountry;

    public enum Country {
        AT(1),
        DK(2),
        FR(3),
        DE(4),
        HU(5),
        IT(6),
        NL(7),
        ES(8);

        private Integer countryCode;

        Country(Integer countryCode) {
            this.countryCode = countryCode;
        }
        public Integer getCountryCode() {
            return countryCode;
        }
    }

    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement Email;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement Password;

    @FindBy(xpath = "//input[@name=\"pin\"]")
    private WebElement MagicPin;

    @FindBy(xpath = "//select[@name=\"salutation\"]")
    private AndroidElement SelectTitle;

    public enum Salutation {
        MR(1),
        MRS(2);

        private Integer salutationCode;

        Salutation(Integer salutationCode) {
            this.salutationCode = salutationCode;
        }
        public Integer getSalutationCode() {
            return salutationCode;
        }
    }

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    private WebElement FirstName;

    @FindBy(xpath = "//input[@name=\"lastName\"]")
    private WebElement LastName;

    @FindBy(xpath = "//select[@name=\"birthDate\"]")
    private AndroidElement BirthDate;

    @FindBy(xpath = "//input[@name=\"birthPlace\"]")
    private AndroidElement BirthPlace;

    @FindBy(xpath = "//input[@name=\"addressStreet\"]")
    private AndroidElement AddressStreet;

    @FindBy(xpath = "//input[@name=\"addressZipCode\"]")
    private AndroidElement AddressZipCode;

    @FindBy(xpath = "//input[@name=\"addressCity\"]")
    private AndroidElement AddressCity;

    //TODO: ask developers to create an unique ID or xpath for the Mobile phone input field and change locator here
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/form/div[3]/camelot-phone/div/div/camelot-input/div/input")
    private AndroidElement MobilePhone;

    @FindBy(xpath = "//input[@name=\"fiscalCode\"]")
    private AndroidElement FiscalCode;

    @FindBy(xpath = "//*[@id=\"registration-step-1\"]/div[4]/div[2]/camelot-checkbox/div/div[1]")
    private AndroidElement AcceptTermsAndConditions;

    @FindBy(xpath = "//*[@id=\"registration-save-button\"]")
    private AndroidElement RegisterNowButton;

    public void selectCountry(Country country) {
        var selectedCountry = driver.findElement(By.xpath("//*[@name=\"addressCountryIsoCode\"]/option[" + country.getCountryCode() + "]"));
        selectedCountry.click();
    }

    public void typeEmail(String email) {
        Email.clear();
        Email.sendKeys(email);
    }
    public void typePassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void typePin(String pin) {
        MagicPin.clear();
        MagicPin.sendKeys(pin);
    }

    public void typeFirstName(String firstName) {
        FirstName.clear();
        FirstName.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        LastName.clear();
        LastName.sendKeys(lastName);
    }

    public void typeBirthPlace(String birthplace) {
        BirthPlace.clear();
        BirthPlace.sendKeys(birthplace);
    }

    public void typeAddressStreet(String addressStreet) {
        AddressStreet.clear();
        AddressStreet.sendKeys(addressStreet);
    }

    public void typePostalCode(String postalcode) {
        AddressZipCode.clear();
        AddressZipCode.sendKeys(postalcode);
    }

    public void typeTown(String town) {
        AddressCity.clear();
        AddressCity.sendKeys(town);
    }

    public void selectBirthDate(Integer day, Integer month, Integer yearId) {
        var dayBirth = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[3]/camelot-fieldset/fieldset/div/camelot-select[1]/div/div/select/option[" + (day+1) + "]"));
        var monthBirth = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[3]/camelot-fieldset/fieldset/div/camelot-select[2]/div/div/select/option[" + (month+1) + "]"));
        var yearBirth = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[3]/camelot-fieldset/fieldset/div/camelot-select[3]/div/div/select/option["+ yearId +"]"));
        dayBirth.click();
        monthBirth.click();
        yearBirth.click();
    }

    public void selectYourTitle(Salutation title) {
        var selectedSalutation = driver.findElement(By.xpath("//*[@name=\"salutation\"]/option[" + title.getSalutationCode() + "]"));
        selectedSalutation.click();
    }

    public void typePhoneNumber(String phoneNumber) throws InterruptedException {
        MobilePhone.clear();
        synchronized (driver) {
            driver.wait(1000);
        }
        MobilePhone.sendKeys(phoneNumber);
    }

    public void checkTermsAndConditions() throws InterruptedException {
        synchronized (driver) {
            driver.wait(1000);
        }
        AcceptTermsAndConditions.click();
    }

    public void clickRegisterNowButton() throws InterruptedException {
        RegisterNowButton.click();
    }

}
