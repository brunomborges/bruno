import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.hamcrest.Matchers;
import org.junit.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

/**
 * Created by bborges on 9/3/14.
 */
public class LoginPageTest {
    public FirefoxDriver driver;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void loginError(){
        driver.get("http://www.flipkart.com/");
        driver.findElementByXPath(".//*[@id='fk-mainhead-id']/div[1]/div/div[2]/div[1]/ul/li[7]/a").click();
        new LoginPage(driver)
                .fill("login_email_id", LoginPage.EMAIL_ADRESS)
                .fill("login_password", LoginPage.INCORRECT_PASSWORD);
         driver.findElement(By.cssSelector("input[value = 'Login']")).click();
         String result = driver.findElementByXPath(".//*[@id='login_tiny_help_message']").getText();
         assertThat(result, Matchers.containsString("Email/Password combination is wrong."));

    }
}
