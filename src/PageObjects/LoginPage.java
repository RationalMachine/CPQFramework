package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Username
	@FindBy(id = "username")
	public WebElement username;
	
	//Password
	@FindBy(id = "password")
	public WebElement password;
	
	
	//Button
	@FindBy(xpath = "//button")
	public WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='No']")
	public WebElement popUp;
	
	@FindBy(xpath = "//button[contains(text(),'No')]")
	public WebElement popUpHtml;
	
	@FindBy(xpath = "//span[contains(@class,'sapUiUfdShellHeadUsrItmExp')]")
	public WebElement dropDown;
	
	@FindBy(xpath = "//span[contains(text(),'Launch HTML5')]")
	public WebElement launchHTML5;
	
	//
	
	
	
	//PopUp Button
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
