package Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SearchPage extends BasePage {

    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector("button[class='btn btn-default btn-lg']");
    private By addToCartButton = By.cssSelector("button[onclick^='cart.add']");
    private By alertSuccess = By.cssSelector(".alert-success");

    private By noResultsMessage = By.cssSelector(".product-layout"); // Assuming the presence of products layout



    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchInput(String searchText) throws InterruptedException {
        sendText(searchText, searchBox);
    }

    public void searchOptClick() throws InterruptedException {
        click(searchButton);
    }

    public void addToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        click(addToCartButton);
    }

    public String alertSuccess() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertSuccess));
        return getText(alertSuccess);

    }

    public boolean isNoResultsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(noResultsMessage));
    }

    public boolean isAddToCartButtonDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
