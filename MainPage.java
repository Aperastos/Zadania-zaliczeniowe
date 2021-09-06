package shop.order.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;

    @FindBy(id="_desktop_logo")
    private WebElement myStoreBtn;

    public MainPage(WebDriver driver) {
    this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*public void MyStorePage goToMyStore() {
        myStoreBtn.click();
        return new MyStorePage(driver);
    }*/
}
