package flipKart.pages;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

/**
 * Created by bborges on 9/3/14.
 */
public class CreateAccount {


    private static FirefoxDriver driver;

    public CreateAccount(FirefoxDriver driver){
        this.driver = driver;
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public void signUp(){
        driver.findElementByXPath(".//*[@id='fk-mainhead-id']/div[1]/div/div[3]/div[1]/ul/li[6]/a").click();
    }

    public void setEmail(String email){
        driver.findElementById("signup-email").sendKeys(email);

    }

    public void setPassoword(String pass){
        driver.findElementById("signup-password").sendKeys(pass);
    }

    public void setPasswordConfirmation(String passConf){
        driver.findElementById("signup-repeat-password").sendKeys(passConf);
    }

    public String getErrorMessage(){
        return driver.findElementByXPath(".//*[@id='signup_tiny_help_message']").getText();

    }

    public void clickSubmit(){
        driver.findElement(By.cssSelector("input[value = 'Sign Up Now!']")).click();

    }

    public void succsessMessage(){
        boolean result = driver.findElementByClassName("greeting-link").isEnabled();
        assertThat(result, equalTo(Boolean.TRUE));
    }


}






























