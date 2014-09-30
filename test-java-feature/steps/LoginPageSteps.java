package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by bborges on 9/26/14.
 */
public class LoginPageSteps {
    private static FirefoxDriver driver;


    @cucumber.api.java.After
    public void tearDown(){
        driver.close();
    }


    @Given("^I am in the login page$")
    public void I_am_in_the_login_page ()throws Throwable {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.flipkart.com/account");
    }

    @Given("^I have entered \"([^\"]*)\" as an email address$")
    public void I_have_entered_as_an_email_address(String email) throws Throwable {
        driver.findElementById("login_email_id1").sendKeys(email);
    }

    @Given("^I have entered \"([^\"]*)\" as a password to login$")
    public void I_have_entered_as_a_password_to_login(String password) throws Throwable {
        driver.findElementById("login_password1").sendKeys(password);

    }

    @When("^I press the Login button$")
    public void I_press_the_Login_button() throws Throwable {
        driver.findElementById("login-cta").click();
    }

    @Then("^The error message \"([^\"]*)\" should appear on the screen and user should not be loged in$")
    public void The_error_message_should_appear_on_the_screen_and_user_should_not_be_loged_in(String errorMessage) throws Throwable {
        Boolean myDynamicElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.textToBePresentInElement(By.id("login_tiny_help_message1"), errorMessage));
        String result = driver.findElementById("login_tiny_help_message1").getText();
                assertThat(result, Matchers.containsString(errorMessage));

    }

    @Then("^I should login in the system$")
    public void I_should_login_in_the_system() throws Throwable {
        boolean result = driver.findElementByClassName("greeting-link").isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }



}
