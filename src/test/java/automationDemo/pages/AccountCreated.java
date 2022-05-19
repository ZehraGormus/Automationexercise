package automationDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreated extends BasePage{

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreated;

    @FindBy(linkText = "Continue")
    public WebElement continueBtn;

}
