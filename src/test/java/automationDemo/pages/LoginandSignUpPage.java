package automationDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginandSignUpPage extends BasePage {
    @FindBy(xpath = "//*[text()='New User Signup!']")
    public WebElement verifySignUp;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement name;

    @FindBy(xpath = "(//*[@name='email'])[2]")
    public WebElement emailSingUp;

    @FindBy(xpath = "//*[@name='email'][1]")
    public WebElement emailLogin;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordLogin;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = " //a[text()=' Signup / Login']")
    public WebElement signAndLoginBtn;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logoutLinkText;



    @FindBy(xpath = "//a[text()=' Logged in as ']")
    public WebElement loggedInAsUsername;





    public void login(String email, String password){
        signAndLoginBtn.click();
        emailLogin.sendKeys(email);
        passwordLogin.sendKeys(password);
        loginButton.click();
    }




}
