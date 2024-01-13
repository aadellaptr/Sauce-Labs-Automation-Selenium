package stepDef;

import config.env_target;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.cartPages;
import pages.overviewCheckout_Pages;

public class checkout_stepDef extends env_target {
    protected WebDriver driver = getDriver();

    cartPages cartPage = new cartPages(driver);
    overviewCheckout_Pages overviewPages = new overviewCheckout_Pages(driver);

    @Given("User is on the shopping cart page")
    public void user_is_on_the_cart_page() {

        cartPage.waitForCartPage();
    }


    @And("Check the total price, tax, and total price + tax of the products")
    public void calculates_the_price_tax() {
        overviewPages.calculateTotalPrice();

        overviewPages.calculateTax();

        overviewPages.calculateTotalPriceTax();
    }

    @Then("User goes to the checkout information page")
    public void checkout_information_page() {

        cartPage.clickCheckout();
    }

    @When("^User fill (.*), (.*), and (.*)$")
    public void userFillFirst_nameLast_nameAndZip_code(String firstName, String lastName, String postalCode) {
        cartPage.waitForCheckoutInformationPage();
        cartPage.fillCheckoutInformation(firstName, lastName, postalCode);
    }

    @And("User clicks the continue")
    public void userClicksTheContinue() {

        cartPage.clickContinue();
    }

    @Then("Verifies that the total on the checkout overview matches the calculated total and tax")
    public void verifies_calculated_total_tax() {
        overviewPages.verify_calculated_total_tax();
    }

    @When("User clicks the finish button")
    public void user_clicks_the_finish_button(){
        cartPage.waitForCheckoutOverviewPage();
        cartPage.clickFinish();
    }

    @Then("Checkout is complete")
    public void checkout_is_complete(){

        cartPage.verifyCheckoutResult();
    }

    @After
    public void tearDown() {

        env_target.closeDriver();
    }

}
