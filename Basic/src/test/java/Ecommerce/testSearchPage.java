package Ecommerce;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSearchPage {

    private WebDriver driver;
    private SearchPage searchPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        searchPage = new SearchPage(driver);

        searchPage.setup();
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    public void test_SuccessfulSearch() throws InterruptedException {
        searchPage.searchInput("Iphone");
        searchPage.searchOptClick();
        searchPage.addToCart();

        String result = searchPage.alertSuccess();
        assertTrue(result.contains("Success: You have added iPhone to your shopping cart!"));
    }

    @Test //Testing if this functionality is limited to no characters or not, decision depends on product
    public void test_EmptySearch() throws InterruptedException {
        searchPage.searchInput("");
        searchPage.searchOptClick();

        boolean noResults = searchPage.isNoResultsDisplayed();
        assertTrue(noResults, "Your shopping cart is empty!");
    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
