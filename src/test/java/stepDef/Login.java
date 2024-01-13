package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.loginPages;

public class Login extends env_target {
    protected WebDriver driver = getDriver();

    loginPages loginPage = new loginPages(driver);

    @Given("User is on login page")
    public void user_is_on_login_page() {

        loginPage.navigateToLoginPage(sauceDemo);
    }

    @When("User fill username and password")
    public void user_fill_username_and_password() {

        loginPage.inputUserPw("standard_user","secret_sauce");
    }

    @And("User click login button")
    public void user_click_login_button() {

        loginPage.clickLogin();
    }

    @Then("User verify login result")
    public void user_verify_login_result() {

        loginPage.verifyLoginResult();
    }

}
