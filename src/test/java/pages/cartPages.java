package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cartPages {
    protected WebDriver driver;

    public cartPages(WebDriver driver){

        this.driver=driver;
    }

    //Locator
    By cartPage=By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By checkoutSuccess = By.className("complete-header");

    // Wait cart page
    public void waitForCartPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPage));
    }

    //Click checkout button
    public void clickCheckout(){

        driver.findElement(checkoutButton).click();
    }

    // Wait Check Information page
    public void waitForCheckoutInformationPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
    }

    //Fill Checkout Information
    public void fillCheckoutInformation(String firstName, String lastName, String postalCode){
        //User Input First Name
        driver.findElement(firstNameField).sendKeys(firstName);
        //User Input Last Name
        driver.findElement(lastNameField).sendKeys(lastName);
        //User Input Postal Code
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    //Click Continue Button
    public void clickContinue(){

        driver.findElement(continueButton).click();
    }

    // Wait Check Overview page
    public void waitForCheckoutOverviewPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
    }

    // Click Finish Button
    public void clickFinish(){
        driver.findElement(finishButton).click();
    }

    //Verify Checkout Result
    public void verifyCheckoutResult() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutSuccess));
    }

}
