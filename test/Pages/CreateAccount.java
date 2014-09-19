package Pages;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;

/**
 * Created by bborges on 9/3/14.
 */
public class CreateAccount {
    public static String EMAIL_ADDRESS = "teste1"+System.currentTimeMillis()+"@gmail.com";
    public static String CORRECT_PASSWORD = "Ikr2514201";
    public static String WEAK_PASSWORD = "123";
    public static String UNMATCHED_PASSWORD = "1234";


    private static FirefoxDriver driver;

    public CreateAccount(FirefoxDriver driver){
        this.driver = driver;
    }

    public CreateAccount fill(String id, String text){
        driver.findElementById(id).sendKeys(text);
        return this;
    }

    public CreateAccount click(String id){
        driver.findElementById(id).click();
        return this;
    }

    public CreateAccount checkText(String id, String text){
        assertThat(driver.findElementById(id).getText(), containsString(text));
        return this;
    }

}






























