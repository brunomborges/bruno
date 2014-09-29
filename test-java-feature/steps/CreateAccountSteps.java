package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Created by bborges on 9/26/14.
 */

public class CreateAccountSteps {

    private static FirefoxDriver driver;


    @cucumber.api.java.After
    public void tearDown(){
        driver.close();
    }






        @Given("^I am in the home page$")
        public void I_am_in_the_home_page ()throws Throwable {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://www.flipkart.com/");
        }


        @Given("^I have clicked the Sign Up button on the upper menu$")
        public void I_have_clicked_the_Sign_Up_button_on_the_upper_menu ()throws Throwable {
        driver.findElementByXPath(".//*[@id='fk-mainhead-id']/div[1]/div/div[3]/div[1]/ul/li[6]/a").click();
    }

        @Given("^I have entered a valid email address$")
        public void I_have_entered_as_a_valid_email_address ()throws Throwable {
        driver.findElementById("signup-email").sendKeys("teste1" + System.currentTimeMillis() + "@gmail.com");

    }

        @Given("^I have entered \"([^\"]*)\" as a password$")
        public void I_have_entered_as_a_password (String weakPassword)throws Throwable {
        driver.findElementById("signup-password").sendKeys(weakPassword);
    }

        @Given("^I have entered \"([^\"]*)\" as a password confirmation$")
        public void I_have_entered_as_a_password_confirmation (String weakPasswordConfirmation)throws Throwable {
        driver.findElementById("signup-repeat-password").sendKeys(weakPasswordConfirmation);
    }

        @When("^I press Sign up button$")
        public void I_press_Sign_up_button ()throws Throwable {
        driver.findElement(By.cssSelector("input[value = 'Sign Up Now!']")).click();
    }

        @Then("^The error message \"([^\"]*)\" should appear on the screen and account should not be created$")
        public void The_error_message_should_appear_on_the_screen_and_account_should_not_be_created (String
        errorMessage)throws Throwable {
        String result = driver.findElementByXPath(".//*[@id='signup_tiny_help_message']").getText();
        assertThat(result, Matchers.containsString(errorMessage));


    }


    @Then("^the user should be logged in$")
    public void the_user_should_be_logged_in ()throws Throwable {
        boolean result = driver.findElementByClassName("greeting-link").isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }




}
