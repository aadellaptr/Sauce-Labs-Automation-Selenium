package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.loginPages;


public class loginTDD extends env_target {
    protected WebDriver driver = getDriver();

    loginPages loginPage = new loginPages(driver);

    @Given("User is on login pages")
    public void user_is_on_login_page() {

        loginPage.navigateToLoginPage(sauceDemo);
    }

    @When("^User input (.*) and (.*)$")
    public void user_input_username_and_password_tdd(String username, String password) {

    loginPage.inputUserPwTDD(username, password);
    }

    @And("User clicks login button")
    public void user_click_login_button() {

        loginPage.clickLogin();
    }

    @Then("^User login (.*)$")
    public void user_verify_login_result_tdd(String result) {

    loginPage.verifyLoginResultTDD(result);

    }
}
