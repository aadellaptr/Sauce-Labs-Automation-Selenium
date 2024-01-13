package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class menuPages {
    protected WebDriver driver;

    public menuPages(WebDriver driver){

        this.driver=driver;
    }

    //Locator
    By menuButton = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    By logoutButton = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    By loginButton = By.xpath("//*[@id=\"login-button\"]");

    public void clickMenu(){
        driver.findElement(menuButton).click();
    }

    public void clickLogout(){
        driver.findElement(logoutButton).click();
    }

    public void verifyLogoutResult(String url) {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        assertEquals(url, driver.getCurrentUrl());
    }
}
