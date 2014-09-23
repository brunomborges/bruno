/**
 * Created by bborges on 8/21/14.
 */
package Pages;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginPage {
    public static String EMAIL_ADRESS = "bruno1@gmail.com";
    public static String CORRECT_PASSWORD = "Tartaruga01";
    public static String INCORRECT_PASSWORD = "Tartaruga01";

    private static FirefoxDriver driver;

    public LoginPage(FirefoxDriver driver){
        this.driver = driver;

    }

    public LoginPage fill(String id, String text){
        driver.findElementById(id).sendKeys(text);
        return this;
    }

    public LoginPage click(String id, String text){
        driver.findElementById(id).click();
        return this;
    }


    public LoginPage checkText(String id, String text){
        assertThat(driver.findElementById(id).getText(), containsString(text));
        return this;
    }

}
