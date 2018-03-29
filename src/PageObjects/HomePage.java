package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//@FindBy(xpath = "//h1[text()='Customers']")
	//public WebElement customers;
	
	@FindBy(xpath = "//a[text()='Accounts']")
	public WebElement accounts;

	@FindBy(xpath = ".//li[2]")
	public WebElement feed;
	
	@FindBy(xpath = "//li/a[contains(text(), 'Customers')]")
	public WebElement customers;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement searchField;
	
	@FindBy(xpath = "//div[@id='BasicFind3-cb-searchico']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//a[@title='Mohit']")
	public WebElement mohit;
	
	@FindBy(xpath = "//a[contains(text(), 'OPPORTUNITIES')]")
	public WebElement opportunities;
	
	@FindBy(xpath = "//input[@type='search']") 
	public WebElement oppSearch;
	
	@FindBy(xpath = "//a[contains(text(), 'Test_Nam')]")
	public WebElement testNam;
	
	//@FindBy(xpath = "//div[@role='Main']//li[@class='sapUiUx3NavBarItemSel']/a[contains(text(), 'Quotes')]")
	@FindBy(css = "[id^='navigationitemNAVIGATIONITEMID_7bc2f6d569b74f2fa33d38fa9962135c_2230']")
	public WebElement Quotes;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

}
