package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver){
		super(driver);
	}

	//Username
	@FindBy(id = "username")
	public static WebElement username;
	
	//Password
	@FindBy(id = "password")
	public static WebElement password;
	
	
	//Button
	@FindBy(xpath = "//button")
	public static WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='No']")
	public static WebElement popUp;
	
	@FindBy(xpath = "//button[contains(text(),'No')]")
	public WebElement popUpHtml;

	@FindBy(id = "__panel0-CollapsedImg")
	public static WebElement customerDropdown;

    @FindBy(xpath = "//a[contains(text(),'Accounts')]")
    public static WebElement accounts;
	
	@FindBy(xpath = "//span[contains(@class,'sapUiUfdShellHeadUsrItmExp')]")
	public WebElement dropDown;
	
	@FindBy(xpath = "//span[contains(text(),'Launch HTML5')]")
	public WebElement launchHTML5;

    //search button
    @FindBy(xpath = "//span[contains(@id,'searchButton-img')]")
    public static WebElement searchButton;

    //search edit field
    @FindBy(xpath = "//input[contains(@id,'searchField-I')]")
    public static WebElement searchEditField;


    //Mohit search result
    @FindBy(xpath = "//a[text()='Mohit']")
    public static WebElement mohitSearchResult;

    @FindBy(xpath = "//span[text()='OPPORTUNITIES']")
    public static WebElement opportunities;

    @FindBy(xpath = "//span[contains(@id,'searchButton-img')]")
    public static WebElement searchIcon;

    @FindBy(xpath = "(//input[contains(@id,'searchField-I')])[2]")
    public static WebElement searchField;

    @FindBy(xpath = "(//div[contains(@id,'searchField-search')])[2]")
    public static WebElement searchIconShowResult;

    @FindBy(xpath = "//span[text()='Quotes']")
    public static WebElement quotes;
    //Add
    @FindBy(xpath = "//span[text()='Add']")
    public static WebElement add;

    @FindBy(xpath = "//img[contains(@id,'coltlogo')]")
    public static WebElement coltlogo;

    @FindBy(xpath = "//select[contains(@name,'__change_currency')]")
    public static WebElement changeCurrency;

    @FindBy(id = "change_currency")
    public static WebElement changeButton;

    @FindBy(id = "readonly_1_currency_t")
    public static WebElement readCurrency;

}
