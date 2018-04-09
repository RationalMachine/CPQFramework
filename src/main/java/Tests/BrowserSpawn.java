package Tests;

import com.google.sitebricks.client.Web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class BrowserSpawn implements ISuiteListener{

    private static final String DRIVER = "driver";
    private static WebDriver driver = null;

    //@Override
    public void onStart(ISuite suite) {
        //WebDriver driver;
        driver = new ChromeDriver();
        suite.setAttribute(DRIVER, driver);
    }

    public void onFinish(ISuite suite) {
        Object driver = suite.getAttribute(DRIVER);
        if (driver == null) {
            return;
        }
        if (!(driver instanceof WebDriver)){
            throw new IllegalStateException("Corrupt Driver");
        }
        ((WebDriver)driver).quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
