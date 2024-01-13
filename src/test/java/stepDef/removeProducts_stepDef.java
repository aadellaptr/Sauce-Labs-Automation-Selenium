package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.productPages;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class removeProducts_stepDef extends env_target{
    protected WebDriver driver = getDriver();
    productPages productPage = new productPages(driver);

    @Given("User has added products {string} to the cart")
    public void userHasAddedProductsToTheCart(String products) {
        // Menggunakan split untuk mendapatkan array produk
        String[] productList = products.split(", ");

        // Memanggil metode untuk mengklik tombol add to cart pada setiap produk
        productPage.multipleProduct(productList);
    }

    @When("User clicks remove button for {string}")
    public void userClicksRemoveButtonFor(String product) {
        productPage.clickRemove(product);
    }

    @Then("Shopping cart badge should be reduced by {int}")
    public void shoppingCartBadgeShouldBeReducedBy(int count) {
        int expected = productPage.getExpectedCount()-productPage.getCartBadgeCount();
        assertEquals(expected, productPage.getCartBadgeCount());
    }

    @When("User clicks cart icon")
    public void userClicksCartIcon() {
        productPage.clickCartIcon();
    }

    @Then("Cart should not contain {string}")
    public void cartShouldNotContain(String product) {
        List<String> productsInCart = productPage.getProductName();
        assertFalse(productsInCart.contains(product));

    }
}
