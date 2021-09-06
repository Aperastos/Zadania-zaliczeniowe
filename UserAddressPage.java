package shop.configuration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserAddressPage {
    private static WebDriver driver;

    @FindBy(className = "addresses-footer")
    private WebElement createNewAddress;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "country")
    private WebElement countryChoose;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(className = "btn-primary")
    private WebElement saveBtn;

    @FindBy(css = "alert.alert-success")
    private WebElement successInformation;

    public UserAddressPage(WebDriver driver) {

    }


    public void creatNewAddress(String alias, String address, String city, String postcode, String phone) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void SelectCountry() {
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("United Kingdom");
    }

    public void SaveAddressInfo() {
        saveBtn.click();
    }

    public String getUpdatedInformation() {
        return successInformation.getText();
    }
}
