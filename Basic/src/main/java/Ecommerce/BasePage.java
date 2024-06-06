package Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void setup() {
        driver.manage().window().maximize();
    }

    protected void getUrl(String url) throws InterruptedException {
        driver.get(url);
    }

    protected void closeBrowser() {
        driver.quit();
    }

    protected WebElement findElement(By locator) throws InterruptedException {
        return driver.findElement(locator);
    }

    protected void sendText(String inputText, By locator) throws InterruptedException {
        this.findElement(locator).clear();
        this.findElement(locator).sendKeys(inputText);
    }

    protected void click(By locator) throws InterruptedException {
        this.findElement(locator).click();
    }


    protected String getText(By locator) throws InterruptedException {
        return this.findElement(locator).getText();
    }
}