package shop.order.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import shop.order.pages.LoginPage;
import shop.order.pages.MainPage;
/*import shop.order.pages.MyStorePage;*/

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CreateNewOrder {
    private static WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
   /* MyStorePage myStorePage;*/

    @Given("^User is logged in to Coderslab shop account$")
    public void userIsLoggedInToCoderslabShop() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginAs("cjnpcthsflvppndgmg@bptfp.com", "password");
    }

    @When("^User goes to My Store page$")
    public void userGoesToMyStorePage() {
        WebElement myStoreBtn = driver.findElement(By.id("_desktop_logo"));
        myStoreBtn.click();

    }

    @And("^User enters productname \"Hummingbird Printed Sweater\" into search field and click search btn$")
    public void userEntersHumingbirdPrintedSweaterIntoSearchField() {
        WebElement searchField = driver.findElement(By.name("s"));
        searchField.clear();
        searchField.sendKeys("Hummingbird Printed Sweater");
        searchField.submit();
    }

    @And("^User clicks in \"Hummingbird Printed Sweater\" details$")
    public void userClicksInProductDetails() {
        WebElement quickView = driver.findElement(By.cssSelector("#js-product-list > div.products.row > article:nth-child(1) > div > div.product-description > h2 > a"));
        quickView.click();
    }

    @And("^User choose M size$")
    public void userSelectMSize() {
        WebElement sizeList = driver.findElement(By.id("group_1"));
        Select select = new Select(sizeList);
        select.selectByVisibleText("M");
    }

    @And("^User enters 5 in quantity box and click Add to Cart Btn$")
    public void userEntersQuantity() {
        WebElement quantityWanted = driver.findElement(By.id("quantity_wanted"));
        quantityWanted.clear();
        quantityWanted.sendKeys("5");
        WebElement addToCartBtn = driver.findElement(By.className("add-to-cart"));
        addToCartBtn.click();
    }

    @And("^User clicks Proceed To Checkout Btn$")
    public void userProceedToCheckout() {
        WebElement checkoutBtn = driver.findElement(By.cssSelector("a.btn:nth-child(2)"));
        checkoutBtn.click();
    }

    @And("^User goes to My Cart and clicks Proceed To Checkout Btn$")
    public void userCheckoutInMyCart() {
        WebElement cartCheckoutBtn = driver.findElement(By.cssSelector("a.btn"));
        cartCheckoutBtn.click();
    }

    @And("^User confirmes address$")
    public void userConfirmAddress() {
        WebElement confirmAddress = driver.findElement(By.name("confirm-addresses"));
        confirmAddress.click();
    }

    @And("^User choose shipping method PrestaShop$")
    public void userChooseShippingMethod() {
        WebElement prestaShop = driver.findElement(By.name("delivery_option[13737]"));
        prestaShop.sendKeys(Keys.ENTER);
    }

    @And("^User clicks Continue Btn$")
    public void userClicksContinueBtn() {
        WebElement continueBtn = driver.findElement(By.cssSelector("#js-delivery > button"));
        continueBtn.click();
    }

    @And("^User choose payment method Pay By Check$")
    public void userChoosePaymentMethod() {
        WebElement payByCheck = driver.findElement(By.cssSelector("#payment-option-1"));
        payByCheck.click();
    }

    @And("^User agrees the therms of service$")
    public void userAgreesTermsOfService() {
        WebElement termsCheckbox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        termsCheckbox.click();
    }

    @And("^User clicks Order With An Obligation To Pay Btn$")
    public void userOrderWithPay() {
        WebElement orderWithPay = driver.findElement(By.id("payment-confirmation"));
        orderWithPay.click();
    }

    @Then("^Make a screenshot")

    public void screenshot() throws IOException {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:\\Users\\apera\\OneDrive\\Obrazy\\order_screenshot.png"));
    }

    @And("Close shop page")
    public void closeBrowser() {
        driver.quit();
    }
}
