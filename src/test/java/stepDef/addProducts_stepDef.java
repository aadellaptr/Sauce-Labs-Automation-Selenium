package stepDef;

import config.env_target;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.productPages;

public class addProducts_stepDef extends env_target{
    protected WebDriver driver = getDriver();
    productPages productPage = new productPages(driver);

    @When("User adds products {string} to the cart")
    public void userAddProductsToCart(String products) {
        // Menggunakan split untuk mendapatkan array produk
        String[] productList = products.split(", ");

        // Memanggil metode untuk mengklik tombol add to cart pada setiap produk
        productPage.multipleProduct(productList);
    }

    @Then("Shopping cart badge should display the correct count")
    public void shoppingCartBadgeDisplayCorrectCount() {
        productPage.verifyCartBadgeCount();
    }

    @When("User click cart icon")
    public void userClickCartIcon() {
        productPage.clickCartIcon();
    }

    @Then("Cart should display the correct products")
    public void cartShouldDisplayTheCorrectProducts() {
        productPage.verifyProductsInCart();
    }
}
