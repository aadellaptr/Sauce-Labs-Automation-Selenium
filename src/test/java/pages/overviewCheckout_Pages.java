package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class overviewCheckout_Pages {
    protected WebDriver driver;
    private double totalPrice;
    private double tax;
    private double totalPriceTax;

    public overviewCheckout_Pages(WebDriver driver){

        this.driver = driver;
    }

    //Locator
    By priceLocator = By.className("inventory_item_price");
    By quantityLocator = By.className("cart_quantity");
    By totalLocator = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]");
    By taxLocator = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    By priceTaxLocator = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");

    public List<Double> getProductPrices(){
        List<WebElement> priceElements = driver.findElements(priceLocator);
        List<Double> productPrices = new ArrayList<>();

        for (WebElement priceElement : priceElements){
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            productPrices.add(price);
        }
        return productPrices;
    }

    public List<Integer> getProductQuantities(){
        List <WebElement> quantityElements = driver.findElements(quantityLocator);
        List <Integer> productQuantities = new ArrayList<>();

        for (WebElement quantityElement : quantityElements){
            String quantityText = quantityElement.getText().trim();
            int quantity = Integer.parseInt(quantityText);
            productQuantities.add(quantity);
        }
        return productQuantities;
    }

    public void calculateTotalPrice() {
        double totalPrice = 0.0;

        List<Double> productPrices = getProductPrices();
        List<Integer> productQuantities = getProductQuantities();

        for (int i = 0; i < productPrices.size(); i++) {
            double price = productPrices.get(i);
            int quantity = productQuantities.get(i);
            double productTotal = price * quantity;
            totalPrice += productTotal;
        }

        setTotalPrice(totalPrice);
    }

    public double getTotalPrice() {

        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void calculateTax() {
        double taxRate = 0.08; // 8% tax rate
        tax = totalPrice * taxRate;
        setTax(tax);
    }

    public void setTax(double tax){

        this.tax = tax;
    }

    public double getTax(){

        return tax;
    }

    public void calculateTotalPriceTax(){
        totalPriceTax = totalPrice + tax;
        setTotalPriceTax(totalPriceTax);
    }

    public void setTotalPriceTax(double totalPriceTax){

        this.totalPriceTax = totalPriceTax;
    }

    public double getTotalPriceTax(){

        return totalPriceTax;
    }

    public String getPriceOverview(){
        WebElement totalElement = driver.findElement(totalLocator);
        return totalElement.getText().replace("Item total: $", "").trim();
    }

    public String getTaxOverview(){
        WebElement totalElement = driver.findElement(taxLocator);
        return totalElement.getText().replace("Tax: $", "").trim();
    }

    public String getPriceTaxOverview(){
        WebElement totalElement = driver.findElement(priceTaxLocator);
        return totalElement.getText().replace("Total: $", "").trim();
    }

    public void verify_calculated_total_tax() {
        String expectedTotal = String.format("%.2f", getTotalPrice());
        assertEquals(expectedTotal, getPriceOverview());

        String expectedTax = String.format("%.2f", getTax());
        assertEquals(expectedTax, getTaxOverview());

        String expectedPriceTax = String.format("%.2f", getTotalPriceTax());
        assertEquals(expectedPriceTax, getPriceTaxOverview());
    }
}
