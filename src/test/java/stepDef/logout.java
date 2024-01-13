package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.menuPages;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class logout extends env_target {
    protected WebDriver driver = getDriver();
    menuPages menuPage = new menuPages(driver);

    @Given("User is logged in")
    public void userIsLoggedIn() {
    }

    @When("User clicks the side button")
    public void userClicksTheSideButton() {
        menuPage.clickMenu();
    }

    @And("User clicks the logout button")
    public void userClicksTheLogoutButton() {
        menuPage.clickLogout();
    }

    @Then("Verify logout result")
    public void verifyLogoutResult() {
        menuPage.verifyLogoutResult(sauceDemo);
    }
}
