package automationDemo.tests;

import automationDemo.pages.AccountCreated;
import automationDemo.pages.LoginandSignUpPage;
import automationDemo.pages.SignUpPage;
import automationDemo.utilities.BrowserUtils;
import automationDemo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends TestBase {

    @Test
    public void testCase1() {

        LoginandSignUpPage login = new LoginandSignUpPage();
        SignUpPage signUPPage = new SignUpPage();
        AccountCreated accountCreated=new AccountCreated();


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

        String actualSignUpText = signUPPage.singUpText.getText();
        String expectedSignUpText = "ENTER ACCOUNT INFORMATION";

        extentLogger.info("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        Assert.assertEquals(actualSignUpText, expectedSignUpText);


        extentLogger.info("Enter gender");
        signUPPage.mrButton.click();

//        extentLogger.info("Enter password");
//        signUPPage.password.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Enter the Day");
        signUPPage.selectDate(signUPPage.days);

        extentLogger.info("Enter the Months");
        signUPPage.selectDate(signUPPage.months);

        extentLogger.info("Enter the Years");
        signUPPage.selectDate(signUPPage.years);

        extentLogger.info("Select checkbox 'Sign up for our newsletter!'");
        signUPPage.newsletterRadioBtn.click();

        extentLogger.info("Select checkbox 'Receive special offers from our partners!'");
        signUPPage.ourPartnersRadioBtn.click();

//        BrowserUtils.scrollToElement(driver.findElement(By.id("city")));

       signUPPage.fillDetails("password");
       signUPPage.fillDetails("First Name");
       signUPPage.fillDetails("Last Name");
        BrowserUtils.scrollToElement(driver.findElement(By.id("city")));// bizim bu elemente kadar sayfamizi kaydiriyor

        extentLogger.info("Click on ourPartnersRadioBtn");
        signUPPage.ourPartnersRadioBtn.click();

        extentLogger.info("Enter the Password");
        signUPPage.fillDetails("password");

        extentLogger.info("Enter the First Name");
        signUPPage.fillDetails("First Name");

        extentLogger.info("Enter the Last name");
        signUPPage.fillDetails("Last name");

        extentLogger.info("Enter the Company");
        signUPPage.fillDetails("Company");

        extentLogger.info("Enter the Address");
        signUPPage.fillDetails("Address");

        extentLogger.info("Enter the Address 2");
        signUPPage.fillDetails("Address 2");

        extentLogger.info("Enter the State");
        signUPPage.fillDetails("State");

        extentLogger.info("Enter the City");
        signUPPage.fillDetails("City");

        extentLogger.info("Enter the Zipcode");
        signUPPage.fillDetails("Zipcode");

        extentLogger.info("Enter the Mobile Number");
        signUPPage.fillDetails("Mobile Number");

        extentLogger.info("Select country");
        new Select(signUPPage.country).selectByVisibleText("United States");

        extentLogger.info("Click on Create Account");
        signUPPage.createAccountBtn.click();

        String actualAccountCreatedText = accountCreated.accountCreated.getText();
        String expectedAccountCreatedText = "ACCOUNT CREATED!";

        extentLogger.info("Verify that 'ACCOUNT CREATED!' is visible");
        Assert.assertEquals(actualAccountCreatedText, expectedAccountCreatedText);

        extentLogger.info("Click on continueBtn");
        accountCreated.continueBtn.click();















    }
}
