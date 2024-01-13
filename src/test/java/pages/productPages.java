package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class productPages {
    protected WebDriver driver;

    private int expectedCount;
    private List<String> addedProducts = new ArrayList<>();

    public productPages(WebDriver driver){

        this.driver=driver;
    }

    //Locator
    By cartIcon = By.className("shopping_cart_link");
    By productLocator = By.className("inventory_item_name");
    By cartBadge = By.className("shopping_cart_badge");
    
    public void multipleProduct(String[] productList){
        for (String product : productList) {
            By productButton = By.xpath(String.format("//*[@id='add-to-cart-sauce-labs-%s']", product.trim()));
            driver.findElement(productButton).click();
            addedProducts.add(product);
        }
        expectedCount = productList.length;
    }

    public int getExpectedCount() {

        return expectedCount;
    }

    public int getCartBadgeCount() {
        WebElement cartBadges = driver.findElement(cartBadge);
        String badgeText = cartBadges.getText().trim();
        return Integer.parseInt(badgeText);
    }

    public void verifyCartBadgeCount(){

        assertEquals(getExpectedCount(), getCartBadgeCount());
    }

    public void clickCartIcon(){

        driver.findElement(cartIcon).click();
    }

    public List<String> getAddedProducts() {

        return addedProducts;
    }

    public List<String> getProductName() {
        List<WebElement> productElements = driver.findElements(productLocator);
        List<String> productNames = new ArrayList<>();

        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            productNames.add(productName);
        }

        return productNames;
    }

    public void verifyProductsInCart() {
        List<String> addedProducts = getAddedProducts();
        List<String> productsInCart = getProductName();

        // Konversi ke huruf kecil, hapus "Sauce Labs" dan tanda strip, lalu urutkan
        List<String> modifiedAddedProducts = modifyAndSortList(addedProducts);
        List<String> modifiedProductsInCart = modifyAndSortList(productsInCart);

        assertEquals(modifiedAddedProducts, modifiedProductsInCart);
    }

    private List<String> modifyAndSortList(List<String> originalList) {
        return originalList.stream()
                .map(this::modifyProductString)
                .sorted()
                .collect(Collectors.toList());
    }

    private String modifyProductString(String originalString) {
        // Konversi ke huruf kecil, hapus "Sauce Labs" dan tanda strip ("-")
        return originalString.toLowerCase().replace("sauce labs", "").replace("-", "").replaceAll("\\s", "");
    }

    public void clickRemove (String product){
        By removeButton = By.xpath(String.format("//*[@id='remove-sauce-labs-%s']", product.trim()));
        driver.findElement(removeButton).click();
        addedProducts.remove(product);
    }

}
