package flipKart; /**
 * Created by bborges on 9/3/14.
 */


import flipKart.pages.CreateAccount;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
    public void WeakPassword(){
        CreateAccount createAccount = new CreateAccount(driver);
                 createAccount.getUrl("http://www.flipkart.com/");
                 createAccount.signUp();
                 createAccount.setEmail("teste1"+System.currentTimeMillis()+"@gmail.com");
                 createAccount.setPassoword("123");
                 createAccount.setPasswordConfirmation("123");
                 createAccount.clickSubmit();
                 assertThat(createAccount.getErrorMessage(),Matchers.containsString("Password should be minimum 4 characters long."));

    }

    @Test
    public void UnmatchedPassword(){
        CreateAccount createAccount = new CreateAccount(driver);
                 createAccount.getUrl("http://www.flipkart.com/");
                 createAccount.signUp();
                 createAccount.setEmail("teste1"+System.currentTimeMillis()+"@gmail.com");
                 createAccount.setPassoword("Tartaruga01");
                 createAccount.setPasswordConfirmation("Tartaruga01111111");
                 createAccount.clickSubmit();
                 assertThat(createAccount.getErrorMessage(),Matchers.containsString("Passwords don't match"));
    }

    @Test
    public void CreateAccountSuccess(){
        CreateAccount createAccount = new CreateAccount(driver);
                 createAccount.getUrl("http://www.flipkart.com/");
                 createAccount.signUp();
                 createAccount.setEmail("teste1"+System.currentTimeMillis()+"@gmail.com");
                 createAccount.setPassoword("Tartaruga01");
                 createAccount.setPasswordConfirmation("Tartaruga01");
                 createAccount.clickSubmit();
                 createAccount.succsessMessage();
    }
}
