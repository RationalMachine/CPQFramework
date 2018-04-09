package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MohitPage {
    //Opportunities from sub menu
    @FindBy(xpath = "//span[text()='OPPORTUNITIES']")
    public WebElement opportunities;
    //Oppurtunities from menu
    @FindBy(id = "__item21-label")
    public WebElement oppurtunities;
    //Search magnifier icon to open search field
    //@FindBy(xpath = "(//span[contains(@id,'searchButton')])[3]")
    @FindBy(xpath = "//span[contains(@id,'searchButton-img')]")
    public WebElement searchIcon;
    //Search field
    //@FindBy(id = "panevariant6ngrpfYYxKwqkRw05rkfIW_607-searchField-I")
    @FindBy(xpath = "(//input[contains(@id,'searchField-I')])[2]")
    public WebElement searchField;
    //Search icon to show search result
    @FindBy(xpath = "(//div[contains(@id,'searchField-search')])[2]")
    public WebElement searchIconShowResult;
    //Test_Nam search result
    @FindBy(xpath = "//a[text()='Test_Nam']")
    public WebElement testNamSearchResult;



    public MohitPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}