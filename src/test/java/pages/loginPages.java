package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPages {
    protected WebDriver driver;

    public loginPages(WebDriver driver){

        this.driver=driver;
    }

    //Locator
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//input[@type='submit'][@data-test='login-button']");
    By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    By sideBar = By.id("react-burger-menu-btn");
    By logoutButton = By.xpath("//*[@id=\"logout_sidebar_link\"]");

    // Navigate to login page
    public void navigateToLoginPage(String url) {
        driver.get(url);
        waitForLoginPageToLoad();
    }

    // Wait Login page
    public void waitForLoginPageToLoad() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    //Input Username and Password
    public void inputUserPw(String username, String password){
        //User Input Username
        driver.findElement(usernameField).sendKeys(username);
        //User Input Password
        driver.findElement(passwordField).sendKeys(password);
    }

    //Click Login Button
    public void clickLogin(){

        driver.findElement(loginButton).click();
    }

    //Verify Login Result
    public void verifyLoginResult() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        WebElement sidebar =wait.until(ExpectedConditions.visibilityOfElementLocated(sideBar));

        sidebar.findElement(logoutButton);
    }

    //Input Invalid Username and Password
    public void inputInvalidUserPw(String invalidUsername, String invalidPassword){
        //User Input Invalid Username
        driver.findElement(usernameField).sendKeys(invalidUsername);
        driver.findElement(passwordField).sendKeys(invalidPassword);
    }

    //Get error message
    public void errorLoginMessage(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        );

    }

    //Input Username and Password TDD
    public void inputUserPwTDD(String username, String password){
        //User Input Username
        driver.findElement(usernameField).sendKeys(username);
        //User Input Password
        driver.findElement(passwordField).sendKeys(password);
    }

    //Verify Login Result TDD
    public void verifyLoginResultTDD(String result) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        if ("Passed".equals(result)) {
            verifyLoginResult();
        } else if ("Failed".equals(result)) {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(errorMessage)
            ));
        }
    }

    // Check if the user is currently logged in
    public boolean isLoggedIn() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        try {
            // Check if the logout button is present, indicating that the user is logged in
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
            return true;
        } catch (Exception e) {
            // If the logout button is not present, the user is not logged in
            return false;
        }
    }
}
