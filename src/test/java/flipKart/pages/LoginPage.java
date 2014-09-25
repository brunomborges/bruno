/**
 * Created by bborges on 8/21/14.
 */
package flipKart.pages;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertThat;

public class LoginPage {
    private static FirefoxDriver driver;

    public LoginPage(FirefoxDriver driver){
        this.driver = driver;

    }

    public void getUrl(String url){
        driver.get(url);
    }

    public void setEmail(String email){
        driver.findElementById("login_email_id1").sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElementById("login_password1").sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElementById("login-cta").click();
    }

    public String getErrorMessage(){
        return driver.findElementById("login_tiny_help_message1").getText();
    }

    public void waitForElement(String errorm){
        Boolean myDynamicElement = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBePresentInElement(By.id("login_tiny_help_message1"), errorm));
    }
    public void sucssessfulLogin(){
        driver.findElementById("login-cta").click();
        boolean result = driver.findElement(By.className("greeting-link")).isEnabled();

    }
}
