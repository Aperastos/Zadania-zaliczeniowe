package shop.configuration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;

    @FindBy(className = "account")
    private WebElement userDetailsLink;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccountPage goToUserAccount() {
        userDetailsLink.click();
        return new AccountPage(driver);
    }
}