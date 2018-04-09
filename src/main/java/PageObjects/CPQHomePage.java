package PageObjects;

//import jdk.internal.vm.annotation.ForceInline;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CPQHomePage {


	
	@FindBy(id="return_to_c4c")
	public WebElement returnToC4C;

	@FindBy(id="add_product")
	public WebElement addProduct;

	@FindBy(id="readonly_1_currency_t")
    public WebElement currency;
	
	public CPQHomePage(WebDriver driver) {

	    PageFactory.initElements(driver, this);
	}


}
