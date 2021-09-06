package shop.configuration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import shop.configuration.pages.LoginPage;
import shop.configuration.pages.MainPage;
import shop.configuration.pages.UserAddressPage;

import java.util.concurrent.TimeUnit;

public class CreateNewAddressSteps {
    WebDriver driver;
    MainPage mainPage;
    UserAddressPage userAddressPage;

    @Given("User is signed in to Coderslab shop.")
    public void userIsLoggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginAs("cjnpcthsflvppndgmg@bptfp.com", "password");

    }

    @When("User goes to YourAccountPage")
    public void userGoesToYourAccountPage() {
        userAddressPage = mainPage.goToUserAccount().goToUserAddressPage();
    }

    @And("User clicks create new address btn")
    public void userClicksCreateNewAddressBtn() {
        WebElement createNewAddress = driver.findElement(By.cssSelector("#content > div.addresses-footer > a"));
        createNewAddress.click();
    }

    @And("User enters alias (.*)")
    public void enterAlias(String alias) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);
    }

    @And("User enters address (.*)")
    public void enterAddress(String address) {
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);
    }

    @And("User enters zip/postal code (.*)")
    public void enterPostalCode(String postcode) {
        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        postcodeInput.sendKeys(postcode);
    }

    @And("User enters city (.*)")
    public void enterCity(String city) {
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);
    }
    @And("User choose country (.*)")
    public void selectCountry(String country1) {
        WebElement country = driver.findElement(By.className("form-control-select"));
        Select select = new Select(country);
        select.selectByVisibleText(country1);
    }

    @And("User enters phone (.*)")
    public void enterPhone(String phone) {
        WebElement phoneInput = driver.findElement(By.name("phone"));
    }

    @And("User clicks Save btn")
    public void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.className("btn-primary"));
        saveBtn.click();
    }

    @Then("User gets the message: Address successfully added!")
    public String getUpdatedInformation() {
        WebElement successInformation = driver.findElement(By.cssSelector("#notifications > div > article"));
        return successInformation.getText();
    }

    @And("Close shop page")
    public void closeBrowser() {
        driver.quit();
    }

}

