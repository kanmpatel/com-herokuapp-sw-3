package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //find the element of username and send the username key
        sendTextToElement(By.id("username"),"tomsmith");
        //find the element of password and send the password key
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        //click on loging button using elements
        clickOnElement(By.xpath("//button[@class='radius']"));

        //this os form requirement
        String expectedLogInText = "Secure Area";
        //find the welcome text element and get the text
        String actualLogInText = getTextFromElement(By.tagName("h2"));
        //Verify the text error message with assert
        verifyTextMessage(expectedLogInText,actualLogInText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //find the element of username and send the username key
        sendTextToElement(By.id("username"),"tomsmith1");
        //find the element of password and send the password key
       sendTextToElement(By.id("password"),"SuperSecretPassword!");
        //click on loging button using elements
        clickOnElement(By.xpath("//button[@class='radius']"));
        //this os form requirement
        String expectedErrorMessage = "Your username is invalid!";
        //find the welcome text element and get the text
        String actualErrorMessage = getTextFromElement(By.cssSelector("div#flash"));
        //Verify the text error message with assert
        verifyTextMessage(expectedErrorMessage,actualErrorMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        //find the element of username and send the username key
        sendTextToElement(By.id("username"),"tomsmith");
        //find the element of password and send the password key
        sendTextToElement(By.id("password"),"SuperSecretPassword");
        //click on loging button using elements
        clickOnElement(By.xpath("//button[@class='radius']"));
        //this os form requirement
        String expectedErrorMessage = "Your password is invalid!";
        //find the welcome text element and get the text
        String actualErrorMessage = getTextFromElement(By.cssSelector("div#flash"));
        //Verify the text error message with assert
        verifyTextMessage(expectedErrorMessage,actualErrorMessage);
    }

    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
