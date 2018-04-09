package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test_NamPage {

    //Quotes from menu
    @FindBy(xpath = "//span[text()='Quotes']")
    public WebElement quotes;
    //Add
    @FindBy(xpath = "//span[text()='Add']")
    public WebElement add;


    public Test_NamPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
