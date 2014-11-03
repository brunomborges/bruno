package flipKart;

import flipKart.pages.EditAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by bborges on 9/30/14.
 */
public class EditAccountPageTest {

    public FirefoxDriver driver;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void fillAccountInformation(){
        EditAccountPage editAccountPage = new EditAccountPage(driver);
        editAccountPage.login();
        editAccountPage.typeFirstName("Bruno");
        editAccountPage.typeLastName("Alfredo");
        editAccountPage.typeMobileNumber("91919992");
        editAccountPage.typeLandlineNumber("19199929");
        editAccountPage.selectGender("gender","Male");
        editAccountPage.saveChanges(".//*[@id='fk-mainbody-id']/div/div[2]/div[2]/div[2]/div/form/div[7]/div[2]/button");
    }
}
