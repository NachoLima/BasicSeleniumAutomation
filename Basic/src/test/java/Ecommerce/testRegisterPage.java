package Ecommerce;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testRegisterPage {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeEach
    public void setUp() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        registerPage = new RegisterPage(driver);

        registerPage.setup();
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    public void registerBtn() throws InterruptedException {
        registerPage.selectCreateAccount();
        registerPage.selectRegister();

        registerPage.firstNameInput("Danny");
        registerPage.lastNameInput("Phantom");
        registerPage.emailInput("danny.phantom@ghosthunters.com");
        registerPage.phoneNumberInput("5342826451");
        registerPage.passwordInput("JOR76O2OQ8UX");
        registerPage.repeatPasswordInput("JOR76O2OQ8UX");
        registerPage.newsletterBtn();
        registerPage.boxAgree();
        registerPage.btnContinueClick();

        String result = registerPage.alertSuccess();
        assertTrue(result.contains("Congratulations! Your new account has been successfully created!"));
    }

    @Test
    public void registerWithInvalidEmail() throws InterruptedException {
        registerPage.selectCreateAccount();
        registerPage.selectRegister();

        registerPage.firstNameInput("Tyrone");
        registerPage.lastNameInput("Hardin");
        registerPage.emailInput("asd");  // Invalid email format (and data)
        registerPage.phoneNumberInput("5487954327");
        registerPage.passwordInput("EAK04IXU6RV");
        registerPage.repeatPasswordInput("EAK04IXU6RV");
        registerPage.newsletterBtn();
        registerPage.boxAgree();
        registerPage.btnContinueClick();

        //Assertion basic error message
        String error = registerPage.wrongFormatAlert();
        assertTrue(error.contains("Please include an '@' in the email address."));

        // Additional assertion
        assertEquals("Please include an '@' in the email address. 'asd' is missing an '@'.", error);
    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();        }
    }

}
