package flipKart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import flipKart.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.hamcrest.Matchers;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

/**
 * Created by bborges on 9/3/14.
 */
public class LoginPageTest {
    public static final String EMAIL_PASSWORD_COMBINATION_IS_WRONG = "Email/Password combination is wrong.";
    public static final String ACCOUNT_DOES_NOT_EXIST = "Account does not exist";
    public FirefoxDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void accountDoesNotExist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUrl("http://www.flipkart.com/account");
        loginPage.setEmail("bruno10@gmail.com");
        loginPage.setPassword("Tartaruga011111111");
        loginPage.clickLoginButton();
        loginPage.waitForElement(ACCOUNT_DOES_NOT_EXIST);
        assertThat(loginPage.getErrorMessage(), Matchers.containsString(ACCOUNT_DOES_NOT_EXIST));
    }

    @Test
    public void wrongPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUrl("http://www.flipkart.com/account");
        loginPage.setEmail("bruno@gmail.com");
        loginPage.setPassword("tartaruga0000000");
        loginPage.clickLoginButton();
        loginPage.waitForElement(EMAIL_PASSWORD_COMBINATION_IS_WRONG);
        assertThat(loginPage.getErrorMessage(), Matchers.containsString(EMAIL_PASSWORD_COMBINATION_IS_WRONG));
    }

    @Test
    public void correctLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUrl("http://www.flipkart.com/account");
        loginPage.setEmail("bruno1@gmail.com");
        loginPage.setPassword("Tartaruga01");
        loginPage.clickLoginButton();
        loginPage.sucssessfulLogin();
    }
}
