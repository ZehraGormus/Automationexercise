package automationDemo.pages;

import automationDemo.utilities.ConfigurationReader;
import automationDemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends BasePage{

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement singUpText;

    @FindBy(id = "uniform-id_gender1")
    public WebElement mrButton;

    @FindBy(id = "uniform-id_gender2")
    public WebElement mrsButton;

    @FindBy(id = "days")
    public WebElement days;

    @FindBy(id = "months")
    public WebElement months;

    @FindBy(id = "years")
    public WebElement years;

    @FindBy(xpath = "//*[text()='Sign up for our newsletter!']")
    public WebElement newsletterRadioBtn;

    @FindBy(xpath = "//*[text()='Receive special offers from our partners!']")
    public WebElement ourPartnersRadioBtn;

    @FindBy(xpath = "//input[contains(@class, 'form-control')]")
    public List<WebElement> fillDetails;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(xpath = "//*[text()='Create Account']")
    public WebElement createAccountBtn;





    public void fillDetails(String text){

//        Select select = new Select(fillDetails.get(5));

        switch (text) {

            case "password" :
                fillDetails.get(2).sendKeys(ConfigurationReader.get("password"));
                break;
            case "First Name" :
                fillDetails.get(3).sendKeys("Karya");
                break;
            case "Last name" :
                fillDetails.get(4).sendKeys("Ada");
                break;
            case "Company" :
                fillDetails.get(5).sendKeys("Microsoft");
                break;
            case "Address" :
                fillDetails.get(6).sendKeys("Hegel Straße 5");
                break;
            case "Address 2" :
                fillDetails.get(7).sendKeys("Bilmiyorum");
                break;
//            case "Country" -> select.selectByVisibleText("Canada");
            case "State" :
                fillDetails.get(8).sendKeys("Güstow");
                break;
            case "City" :
                fillDetails.get(9).sendKeys("München");
                break;
            case "Zipcode" :
                fillDetails.get(10).sendKeys("19063");
                break;
            case "Mobile Number" :
                fillDetails.get(11).sendKeys("1234567890");
                break;
            default :
                System.out.println("Formuler ist Falsch");
        }

    }



    public void selectDate(WebElement element){

        Select select=new Select(element);
        if(element.equals(days)){
            select.selectByVisibleText("1");
        }else if(element.equals(months)){
            select.selectByVisibleText("February");
        } else if (element.equals(years)) {
            select.selectByVisibleText("2001");
        }else{
            System.out.println("Datum is falsch");
        }
    }

    public void fillDetails(){
       fillDetails.get(0).click();
       fillDetails.get(1).sendKeys("Ada");
    }





}
