package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants{


    public  WebDriver driver;

    //Begins the ExtentReport stuff
    //private static ExtentTest test;
    //private static ExtentReports extent;

    //@BeforeSuite
    public void startSuite(){
        LoggingIn.extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("/Users/himrekha/IdeaProjects/CPQFlintFramework/test-output/Extent.html");
        LoggingIn.extent.attachReporter(htmlReporter);
    }

    //@BeforeMethod
    public void startBeforeMethod(String methodName) {
        LoggingIn.test = LoggingIn.extent.createTest(methodName);
        //startBeforeMethod(String method.getName());
    }

    public void runAfterTesting(ITestResult result) throws IOException {
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                LoggingIn.test.fail(result.getThrowable());
                LoggingIn.test.fail("Screenshot below: " + LoggingIn.test.addScreenCaptureFromPath(takeScreenShot(result.getMethod().getMethodName())));
                break;
            case ITestResult.SKIP:
                LoggingIn.test.skip(result.getThrowable());
                break;
            case ITestResult.SUCCESS:
                LoggingIn.test.pass("Passed");
                break;
            default:
                break;
        }
        LoggingIn.extent.flush();
    }

    public String takeScreenShot(String methodName){
        String path = "/Users/himrekha/IdeaProjects/CPQFlintFramework/test-output/" + methodName + ".png";
        try {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (Exception e) {
            //APPLICATION_LOGS.error("Could not write screenshot" + e);
        }
        return path;
    }
    ////////

    public WebDriver setup(){
        //System.setProperty("webdriver.chrome.driver",readPropFile("chromepath"));
        //driver = new ChromeDriver();
    		System.setProperty("webdriver.gecko.driver", readPropFile("firefoxpath"));
        driver = new FirefoxDriver();
    		driver.get(readPropFile("url"));
        driver.manage().window().maximize();
        return driver;
    }


    public void waitUntilVisible(WebDriver driver, int seconds, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
  
       

    //method for WebDriverWait until object is clickable
    public void waitUntilClickable(WebDriver driver, int seconds, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    //method for scroll clickable
    public void scrollUntilClickable(WebDriver driver, WebElement element) {
    	try {
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    		Thread.sleep(500);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    //method for WebDriverWait until object is staleless
    public void waitTillStale(WebDriver driver, int seconds, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            wait.until(ExpectedConditions.stalenessOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void takeScreenshot(WebDriver driver, String path) {
		try {
			TakesScreenshot scr = ((TakesScreenshot)driver);
			File screenshotFile = scr.getScreenshotAs(OutputType.FILE);
			File finalFile = new File(path);
			FileUtils.copyFile(screenshotFile,finalFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

    //method to read property file
    public String readPropFile(String value){
        Properties prop = new Properties();
        String propValue="";
        try{
            InputStream input = new FileInputStream("property.properties");
            prop.load(input);
            try{
                propValue=prop.getProperty(value);
            }catch (Exception e){
                System.out.println("Check property name!!!");
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return propValue;
    }
}
