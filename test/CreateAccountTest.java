/**
 * Created by bborges on 9/3/14.
 */


import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import Pages.CreateAccount;

public class CreateAccountTest {
    public FirefoxDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void CreateAccountWeakPassWord(){
        driver.get("http://www.flipkart.com/");
        driver.findElementByClassName("signup-link").click();
        new CreateAccount(driver)
                .fill("signup-email", CreateAccount.EMAIL_ADDRESS)
                .fill("signup-password", CreateAccount.WEAK_PASSWORD);
                driver.findElementByClassName("btn btn-green");
                assertThat(driver.findElementById("signup_tiny_help_message").getText(),containsString("The password entered by you is weak as it is very commonly used. Please use a different password."));
    }

    @Test
    public void CreateAccountNullPassword(){
        driver.get("http://www.flipkart.com/");
        driver.findElementByClassName("signup-link").click();
        new CreateAccount(driver)
                .fill("signup-email",CreateAccount.EMAIL_ADDRESS)
                .fill("signup-password",CreateAccount.NULL_PASSWORD);
        driver.findElementByClassName("btn btn-green");
    }

    @Test
    public void CreateAccountSuccess() {
        driver.get("http://www.flipkart.com/");
        driver.findElementByClassName("signup-link").click();
        new CreateAccount(driver)
                .fill("signup-email", CreateAccount.EMAIL_ADDRESS)
                .fill("signup-password", CreateAccount.CORRECT_PASSWORD);
        driver.findElementByClassName("btn btn-green").click();
        assertThat(driver.findElementByClassName("no-border").getText(), containsString("Hi bruno"));
    }

}
