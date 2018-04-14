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

	@FindBy(xpath = "//a[contains(text(),'Ethernet Hub')]")
    public static WebElement hub;

	@FindBy(id = "siteAddressAEnd")
	public static WebElement addressfieldA;

	@FindBy(id = "start_over")
	public static WebElement startOver;

	@FindBy(xpath = "//p[contains(text(),'not a valid option')]")
    public static WebElement hubMessage;

	@FindBy(xpath = "//iframe[@id='siteAddressLink']")
    public static WebElement iframe;

	@FindBy(xpath = "//div[contains(text(),'We are pleased')]")
    public static WebElement viewerMsg;

	@FindBy(xpath = "//div[contains(@class,'address')]")
    public static WebElement viewerAddress;

	@FindBy(xpath = "//td[contains(text(),'Check Connectivity')]")
    public static WebElement checkConnectivityBtn;

	@FindBy(id = "serviceBandwidth")
    public static WebElement bandwidthDrop;

	@FindBy(xpath = "//span[contains(text(),'Site Details')]")
    public static WebElement siteDetails;

	@FindBy(xpath = "//span[contains(text(),'Features')]")
    public static WebElement features;

	@FindBy(id = "resiliencyServiceLevel")
    public static WebElement resiliency;

	@FindBy(xpath = "(//td[contains(text(),'Base Price')])[1]")
    public static WebElement basePrice;

	@FindBy(xpath = "(//span[contains(text(),'3, Julius-Tandler-Platz, Wien, Austria, Wien, 1090')])[1]")
    public static WebElement hubDetailAddr;

	@FindBy(xpath = "//input[@id='outsideBusinessHoursInstallationAEnd_true']")
    public static WebElement obhA;

	@FindBy(id = "outsideBusinessHoursInstallationAEndSecondary_true")
    public static WebElement obhAsec;

	@FindBy(xpath = "//a[contains(@id,'update')]")
    public static WebElement updatebtn;

	@FindBy(xpath = "//input[@id='fasttrackAddon_true']")
    public static WebElement fastTrackradio;

	@FindBy(xpath = "//*[@id='chargesAddonLevel']/table/tbody/tr[3]/td[1]")
    public static WebElement fastTrackTableCheck;

	@FindBy(xpath = "//*[@id='chargesAddonLevel']/table/tbody/tr[4]/td[1]")
    public static WebElement obhTableCheck;

	@FindBy(xpath = "(//td[contains(text(),'Outside Business Hours Installation Secondary')])[1]")
    public static WebElement obhTableCheckSecond;



	@FindBy(id = "add_to_transaction")
    public static WebElement saveToQuote;

	@FindBy(xpath = "(//span[contains(@id,'readonly_2_product')])[1]")
    public static WebElement productTable;

}
