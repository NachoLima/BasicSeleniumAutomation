package Ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class RegisterPage extends BasePage {

    private By createAccountButton = By.cssSelector("[title='My Account']");
    private By registerButton = By.linkText("Register");
    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By phoneNumberField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By repeatPasswordField = By.id("input-confirm");
    private By newsletterBtn = By.cssSelector("input[name='newsletter'][value='0']");
    private By agreeCheckbox = By.name("agree");
    private By continueButton = By.cssSelector("input.btn-primary");
    private By alertSuccess = By.xpath("//div[@id='content']/p[text()='Congratulations! Your new account has been successfully created!']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void selectCreateAccount() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(createAccountButton));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        click(createAccountButton);
    }

    public void selectRegister() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(registerButton));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        click(registerButton);
    }

    public void firstNameInput(String firstName) throws InterruptedException {
        sendText(firstName, firstNameField);
    }

    public void lastNameInput(String lastName) throws InterruptedException {
        sendText(lastName, lastNameField);
    }

    public void emailInput(String email) throws InterruptedException {
        sendText(email, emailField);
    }

    public void phoneNumberInput(String phoneNumber) throws InterruptedException {
        sendText(phoneNumber, phoneNumberField);
    }

    public void passwordInput(String password) throws InterruptedException {
        sendText(password, passwordField);
    }

    public void repeatPasswordInput(String password) throws InterruptedException {
        sendText(password, repeatPasswordField);
    }

    public void newsletterBtn() throws InterruptedException {
        click(newsletterBtn);
    }


    public void boxAgree() throws InterruptedException {
        click(agreeCheckbox);
    }

    public void btnContinueClick() throws InterruptedException {
        click(continueButton);
    }

    public String alertSuccess() throws InterruptedException {
        return getText(alertSuccess);
    }

    public String wrongFormatAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", driver.findElement(emailField));
    }
}
