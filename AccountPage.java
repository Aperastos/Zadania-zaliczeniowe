package shop.configuration.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private final WebDriver driver;

    @FindBy(id = "addresses-link")
    private WebElement userAddress;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserAddressPage goToUserAddressPage() {
        userAddress.click();
        return new UserAddressPage(driver);
    }
}
