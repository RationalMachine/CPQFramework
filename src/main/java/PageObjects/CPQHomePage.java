package PageObjects;

//import jdk.internal.vm.annotation.ForceInline;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CPQHomePage extends BaseClass{

	public CPQHomePage(WebDriver driver){
		super(driver);
	}

	@FindBy(id="add_product")
	public static WebElement addProduct;

	@FindBy(xpath = "//a[contains(text(),'Ethernet')]")
	public static WebElement ethernet;

	@FindBy(xpath = "//a[contains(text(),'Ethernet Spoke')]")
	public static WebElement spoke;

	@FindBy(id = "siteAddressAEnd")
	public static WebElement addressfieldA;

	@FindBy(id = "start_over")
	public static WebElement startOver;

	@FindBy(xpath = "//p[contains(text(),'not a valid option')]")
    public static WebElement hubMessage;

}
