package automationDemo.tests;

import automationDemo.pages.AccountCreated;
import automationDemo.pages.AccountDelete;
import automationDemo.pages.LoginandSignUpPage;
import automationDemo.pages.SignUpPage;
import automationDemo.utilities.BrowserUtils;
import automationDemo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase1 extends TestBase {

    @Test
    public void testCase1() throws IOException {

        LoginandSignUpPage login = new LoginandSignUpPage();
        SignUpPage signUpPage = new SignUpPage();
        AccountCreated accountCreated=new AccountCreated();
        AccountDelete accountDelete=new AccountDelete();


        extentLogger = report.createTest("Verify that home page is visible successfully");

        extentLogger.info("Launch browser");

        String actualText = driver.getCurrentUrl();
        String expectedText = "https://www.automationexercise.com/";

        extentLogger.info("Navigate to url 'http://automationexercise.com'");
        Assert.assertEquals(actualText, expectedText);

        extentLogger.info("Click on 'Signup / Login' button");
        login.signUpLogin.click();

        String actualVerifySignUpText = login.verifySignUp.getText();
        String expectedVerifySignUpText = "New User Signup!";

        extentLogger.info("Verify 'New User Signup!' is visible");
        Assert.assertEquals(actualVerifySignUpText, expectedVerifySignUpText);


        extentLogger.info("Enter the name");
        login.name.sendKeys(ConfigurationReader.get("name"));

        extentLogger.info("Enter the Email");
        login.emailSingUp.sendKeys(ConfigurationReader.get("email"));

        extentLogger.info("Click on SignUP Button");
        login.signupButton.click();

        String actualSignUpText = signUpPage.singUpText.getText();
        String expectedSignUpText = "ENTER ACCOUNT INFORMATION";

        extentLogger.info("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertEquals(actualSignUpText, expectedSignUpText);


        extentLogger.info("Enter gender");
        signUpPage.mrButton.click();

//        extentLogger.info("Enter password");
//        signUPPage.password.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Enter the Day");
        signUpPage.selectDate(signUpPage.days);

        extentLogger.info("Enter the Months");
        signUpPage.selectDate(signUpPage.months);

        extentLogger.info("Enter the Years");
        signUpPage.selectDate(signUpPage.years);

        extentLogger.info("Select checkbox 'Sign up for our newsletter!'");
        signUpPage.newsletterRadioBtn.click();

        extentLogger.info("Select checkbox 'Receive special offers from our partners!'");
        signUpPage.ourPartnersRadioBtn.click();

//        BrowserUtils.scrollToElement(driver.findElement(By.id("city")));

       signUpPage.fillDetails("password");
       signUpPage.fillDetails("First Name");
       signUpPage.fillDetails("Last Name");
        BrowserUtils.scrollToElement(driver.findElement(By.id("city")));// bizim bu elemente kadar sayfamizi kaydiriyor

        extentLogger.info("Click on ourPartnersRadioBtn");
        signUpPage.ourPartnersRadioBtn.click();

        extentLogger.info("Enter the Password");
        signUpPage.fillDetails("password");

        extentLogger.info("Enter the First Name");
        signUpPage.fillDetails("First Name");

        extentLogger.info("Enter the Last name");
        signUpPage.fillDetails("Last name");

        extentLogger.info("Enter the Company");
        signUpPage.fillDetails("Company");

        extentLogger.info("Enter the Address");
        signUpPage.fillDetails("Address");

        extentLogger.info("Enter the Address 2");
        signUpPage.fillDetails("Address 2");

        extentLogger.info("Enter the State");
        signUpPage.fillDetails("State");

        extentLogger.info("Enter the City");
        signUpPage.fillDetails("City");

        extentLogger.info("Enter the Zipcode");
        signUpPage.fillDetails("Zipcode");

        extentLogger.info("Enter the Mobile Number");
        signUpPage.fillDetails("Mobile Number");

        extentLogger.info("Select country");
        new Select(signUpPage.country).selectByVisibleText("United States");

        extentLogger.info("Click on Create Account");
        signUpPage.createAccountBtn.click();

        String actualAccountCreatedText = accountCreated.accountCreated.getText();
        String expectedAccountCreatedText = "ACCOUNT CREATED!";

        extentLogger.info("Verify that 'ACCOUNT CREATED!' is visible");
        Assert.assertEquals(actualAccountCreatedText, expectedAccountCreatedText);

        extentLogger.info("Click on continueBtn");
        accountCreated.continueBtn.click();

        String actualLoggedInAsName = login.loggedInAsUsername.getText();
        String expectedLoggedInAsName = "Logged in as " + ConfigurationReader.get("name");

        extentLogger.info(" Verify that 'Logged in as username' is visible");
        Assert.assertEquals(actualLoggedInAsName, expectedLoggedInAsName);

        extentLogger.info("Click 'Delete Account' button");
        accountDelete.headerDeleteAccount.click();


        extentLogger.info(" Verify that 'ACCOUNT DELETED!");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.automationexercise.com/delete_account?";
        Assert.assertEquals(actualUrl, expectedUrl);

        extentLogger.info("clicking 'Continue' button");
        BrowserUtils.verifyElementDisplayed(accountDelete.continueBtn);
        accountDelete.continueBtn.click();

        extentLogger.pass("Passed");

       /* extentLogger.info("Click on continueBtn");
        accountCreated.continueBtn.click();

        extentLogger.info("Verifying that 'Logged in as username' is visible");
        //String loggedInAsUsername = login.loggedInAsUsername.getText();
        //Assert.assertEquals(loggedInAsUsername,"Logged in as Saliha");
        //boolean inAsUsernameDisplayed = login.loggedInAsUsername.isDisplayed();
        //Assert.assertTrue(inAsUsernameDisplayed);
        BrowserUtils.verifyElementDisplayed(login.loggedInAsUsername);

        extentLogger.info("Clicking 'Delete Account' button");
        accountDelete.deleteAccountBn.click();

        BrowserUtils.getScreenshot("testCase1");

        extentLogger.info("Verify that 'ACCOUNT DELETED!' is visible");

       /* try {
            String textHeaderDelete = accountDelete.headerDeleteAccount.getText();
            Assert.assertEquals(textHeaderDelete,"ACCOUNT DELETED!");
        }catch(NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " );


        }*/

    }

    @Test
    public void testLogin() {

        LoginandSignUpPage loginandSignUpPage=new LoginandSignUpPage();
        extentLogger = report.createTest("Verify that login is succesful");
        extentLogger.info("login");
        loginandSignUpPage.login("zehra@gmail.com","12345");
        //String actual =loginandSignUpPage.logoutLinkText.getText();

        //Assert.assertEquals(actual,"Logout");
        BrowserUtils.verifyElementDisplayed(loginandSignUpPage.logoutLinkText);
        extentLogger.pass("passed");

    }
}
