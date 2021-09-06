package shop.order.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


        private final WebDriver driver;

        @FindBy(className = "user-info")
        private WebElement signIn;
        @FindBy(name = "email")
        private WebElement loginInput;
        @FindBy(name = "password")
        private WebElement passwordInput;
        @FindBy(id = "submit-login")
        private WebElement signInBtn;
        @FindBy(id="_desktop_logo")
        private WebElement myStoreBtn;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public MainPage loginAs(String email, String password) {
            loginInput.clear();
            loginInput.sendKeys(email);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            signInBtn.click();
            myStoreBtn.click();

            return new MainPage(driver);
        }
}

