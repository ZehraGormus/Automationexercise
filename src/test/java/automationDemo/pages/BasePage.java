package automationDemo.pages;

import automationDemo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() { //bütün testlerin ortaklarini buraya koyuyoruz

        PageFactory.initElements(Driver.get(), this); //sayfamda olan tüm metodlari initilaze etmemi sagladigi icin
        //PageFactory yi kullaniyoruz.
        //bu sayfada bulunan element ve methodlari kullanmama izin verir

    }

    @FindBy(xpath = "(//span[text()='Automation'])[2]")
    public WebElement automationText;

    @FindBy(xpath = "//*[text()=' Signup / Login']")
    public WebElement signUpLogin;


}
