package flipKart; /**
 * Created by bborges on 9/3/14.
 */


import flipKart.pages.CreateAccountPage;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;

public class CreateAccountPageTest {
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
    public void WeakPassword(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
                 createAccountPage.getUrl("http://www.flipkart.com/");
                 createAccountPage.signUp();
                 createAccountPage.setEmail("teste1"+System.currentTimeMillis()+"@gmail.com");
                 createAccountPage.setPassoword("123");
                 createAccountPage.setPasswordConfirmation("123");
                 createAccountPage.clickSubmit();
                 assertThat(createAccountPage.getErrorMessage(),Matchers.containsString("Password should be minimum 4 characters long."));

    }

    @Test
    public void UnmatchedPassword(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
                 createAccountPage.getUrl("http://www.flipkart.com/");
                 createAccountPage.signUp();
                 createAccountPage.setEmail("teste1"+System.currentTimeMillis()+"@gmail.com");
                 createAccountPage.setPassoword("Tartaruga01");
                 createAccountPage.setPasswordConfirmation("Tartaruga01111111");
                 createAccountPage.clickSubmit();
                 assertThat(createAccountPage.getErrorMessage(),Matchers.containsString("Passwords don't match"));
    }

    @Test
    public void CreateAccountSuccess(){
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
                 createAccountPage.getUrl("http://www.flipkart.com/");
                 createAccountPage.signUp();
                 createAccountPage.setEmail("teste1"+System.currentTimeMillis()+"@gmail.com");
                 createAccountPage.setPassoword("Tartaruga01");
                 createAccountPage.setPasswordConfirmation("Tartaruga01");
                 createAccountPage.clickSubmit();
                 createAccountPage.succsessMessage();
    }
}
