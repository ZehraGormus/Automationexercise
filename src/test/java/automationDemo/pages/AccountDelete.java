package automationDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDelete extends BasePage{
    @FindBy(xpath = "(//a[@style='color:brown;'])[2]")
    public WebElement deleteAccountBn;

    @FindBy(tagName = "h1")
    public WebElement headerDeleteAccount;

    @FindBy(linkText = "Continue")
    public WebElement continueBtn;
}
