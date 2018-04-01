package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CPQHomePage {
	
	@FindBy(id="return_to_c4c")
	public WebElement returnToC4C;
	
	public CPQHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}
