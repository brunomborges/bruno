/**
 * Created by bborges on 9/3/14.
 */


import Pages.CreateAccount;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CreateAccountTest {
    public FirefoxDriver driver;

    @Before
    public void setup() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void CreateAccountWeakPassword() {
        driver.get("http://www.flipkart.com/");
        driver.findElementByClassName("signup-link").click();
        new CreateAccount(driver)
                .fill("signup-email", CreateAccount.EMAIL_ADDRESS)
                .fill("signup-password", CreateAccount.WEAK_PASSWORD)
                .fill("signup-repeat-password", CreateAccount.WEAK_PASSWORD);
        driver.findElementByXPath(".//*[@id='signup-form']/div[4]/div[2]/input[2]").click();
        String result = driver.findElementByXPath(".//*[@id='signup_tiny_help_message']").getText();
                assertThat(result, Matchers.containsString("Password should be minimum 4 characters long."));
    }

    @Test
    public void CreateAccountNullPassword(){
        driver.get("http://www.flipkart.com/");
        driver.findElementByClassName("signup-link").click();
        new CreateAccount(driver)
                .fill("signup-email",CreateAccount.EMAIL_ADDRESS)
                .fill("signup-password",CreateAccount.CORRECT_PASSWORD)
                .fill("signup-repeat-password", CreateAccount.UNMATCHED_PASSWORD);
        driver.findElementByXPath(".//*[@id='signup-form']/div[4]/div[2]/input[2]").click();
        String result = driver.findElementByXPath(".//*[@id='signup_tiny_help_message']").getText();
        assertThat(result, Matchers.containsString("Passwords don't match"));
    }

    @Test
    public void CreateAccountSuccess() {
        driver.get("http://www.flipkart.com/");
        driver.findElementByClassName("signup-link").click();
        new CreateAccount(driver)
                .fill("signup-email", CreateAccount.EMAIL_ADDRESS)
                .fill("signup-password", CreateAccount.CORRECT_PASSWORD)
                .fill("signup-repeat-password", CreateAccount.CORRECT_PASSWORD);
        driver.findElementByXPath(".//*[@id='signup-form']/div[4]/div[2]/input[2]").click();
        boolean result = driver.findElementByClassName("greeting-link").isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }

}
