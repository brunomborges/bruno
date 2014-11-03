package flipKart.pages;

import flipKart.LoginPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by bborges on 9/30/14.
 */
public class EditAccountPage {

    private FirefoxDriver driver;

    public EditAccountPage(FirefoxDriver driver){
        this.driver = driver;
    }

    public void login(){
        LoginPageTest loginPageTest = new LoginPageTest();
        loginPageTest.correctLogin();
    }


    public EditAccountPage typeFirstName(String firstName){
        driver.findElementById("first_name").sendKeys(firstName);
        return this;
    }

    public EditAccountPage typeLastName(String lastName){
        driver.findElementById("last_name").sendKeys(lastName);
        return this;
    }

    public EditAccountPage typeMobileNumber(String mobileNumber){
        driver.findElementById("mobile").sendKeys(mobileNumber);
        return this;

    }

    public EditAccountPage typeLandlineNumber(String landLineNumber){
        driver.findElementById("landline").sendKeys(landLineNumber);
        return this;
    }

    public EditAccountPage selectGender(String id, String value){
        WebElement dropDownListBox = driver.findElement(By.id(id));
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByVisibleText(value);
        return this;
    }

    public EditAccountPage saveChanges(String xpath){
        driver.findElementByXPath(xpath).click();
        return this;
    }

}
