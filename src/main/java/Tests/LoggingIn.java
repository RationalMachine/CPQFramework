package Tests;

import java.util.Iterator;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Keys;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.reporter.*;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import java.io.IOException;
import org.testng.annotations.AfterSuite;


import PageObjects.*;

public class LoggingIn extends Constants{
	
	//Create Objects for CPQ, ExtentReports and ExtentTest
	Constants cpq = new Constants();
	private static ExtentReports extent;
	private static ExtentTest test;

    //This starts the reports object which runs a method called attachReporter which takes the HTML file has input to write
	@BeforeSuite
    public void runBeforeEverything() {
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("/Users/himrekha/IdeaProjects/CPQFlintFramework/test-output/Extent.html");
        //htmlReporter.loadXMLConfig("/Users/himrekha/IdeaProjects/CPQFlintFramework/test-output/extent-config.xml");
        extent.attachReporter(htmlReporter);
    }

    //This considers each method present for reporting
    @BeforeMethod
    public void runBeforeTest(Method method) {
        test = extent.createTest(method.getName());
    }

    //Sets up the WebDriver by calling setup() method from Constants.java
    @BeforeTest
	public void setUp() {
		driver = cpq.setup();
	}


    @AfterMethod
    public void runAfterTest(ITestResult result) throws IOException{
        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                test.fail(result.getThrowable());
                test.fail("Screenshot below: " + test.addScreenCaptureFromPath(takeScreenShot(result.getMethod().getMethodName())));
                break;
            case ITestResult.SKIP:
                test.skip(result.getThrowable());
                break;
            case ITestResult.SUCCESS:
                test.pass("Passed");
                break;
            default:
                break;
        }
        extent.flush();
    }
	//@AfterTest
	//public void tearDown() {
	//	driver.quit();
	//}

    //This flushes the extent object
    @AfterSuite
    public void afterSuiteMethod() {
        extent.flush();
    }

    protected String takeScreenShot(String methodName) {
        String path = "/Users/himrekha/IdeaProjects/CPQFlintFramework/test-output/" + methodName + ".png";
        try {
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File(path));
        } catch (Exception e) {
            //APPLICATION_LOGS.error("Could not write screenshot" + e);
        }
        return path;
    }
	
	@Test
	public void login(){
		
		//Login to C4C
		
			
			LoginPage loginPage = new LoginPage(driver);
			HomePage homeMenu = new HomePage(driver);
			CPQHomePage cpHome = new CPQHomePage(driver);
			
			cpq.waitUntilVisible(driver, 60, loginPage.username);
			loginPage.username.sendKeys(cpq.readPropFile("username"));
			loginPage.password.sendKeys(cpq.readPropFile("password"));
			loginPage.loginButton.click();
			
		
			try {
				Thread.sleep(10000);
				cpq.waitUntilClickable(driver, 60, loginPage.popUp);
				loginPage.popUp.click();
			}catch(Exception e) {
				
			}
			
			
			 cpq.waitUntilVisible(driver, 60, loginPage.dropDown);
			 loginPage.dropDown.click();
			
			 cpq.waitUntilVisible(driver, 60, loginPage.launchHTML5);
			 loginPage.launchHTML5.click();
			
			 Iterator<String> iterator = driver.getWindowHandles().iterator();
             String parent = (String) iterator.next();
             String child = (String) iterator.next();          
             driver.switchTo().window(child);
             
             try {
            	 cpq.waitUntilClickable(driver, 60, loginPage.popUpHtml);
            	 loginPage.popUpHtml.click();
             }catch(Exception e) {
            	 
             }
            
             //cpq.waitUntilVisible(driver, 60, homeMenu.feed);
             //homeMenu.feed.click();
             
             cpq.waitUntilClickable(driver, 60, homeMenu.customers);
             homeMenu.customers.click();
             try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
             
             cpq.waitUntilClickable(driver, 60, homeMenu.searchField);
             homeMenu.searchField.click();
             homeMenu.searchField.sendKeys("Mohit");
             try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
             
             homeMenu.searchField.sendKeys(Keys.ENTER);
             try {
 				Thread.sleep(1000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
             
             //cpq.waitUntilClickable(driver, 60, homeMenu.searchButton);
             //homeMenu.searchButton.click();
             
             cpq.waitUntilClickable(driver, 60, homeMenu.mohit);
             //cpq.scrollUntilClickable(driver, homeMenu.mohit);
             homeMenu.mohit.click();
             
             cpq.waitUntilClickable(driver, 60, homeMenu.opportunities);
             homeMenu.opportunities.click();
             
             cpq.waitUntilClickable(driver, 60, homeMenu.oppSearch);
             homeMenu.oppSearch.click();
             homeMenu.oppSearch.sendKeys("Test_Nam");
             try {
 				Thread.sleep(1000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
             
             homeMenu.oppSearch.sendKeys(Keys.ENTER);
             
             cpq.waitUntilClickable(driver, 60, homeMenu.testNam);
             homeMenu.testNam.click();
             
             try {
  				Thread.sleep(5000);
  			} catch (InterruptedException e) {
  				e.printStackTrace();
  			}
             
             
             cpq.waitUntilClickable(driver, 60, homeMenu.Quotes);
             homeMenu.Quotes.click();            
             try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
             
             cpq.waitUntilClickable(driver, 60, homeMenu.goToCPQ);
             homeMenu.goToCPQ.click();
             
             //cpq.waitUntilClickable(driver, 60,);
             
             try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
             
             //takeScreenshot(driver, "/Users/himrekha/eclipse-workspace/FlintAutomation/CPQ.png");
		
             Assert.assertTrue(homeMenu.feed.isDisplayed());
	}

	
	
	

}
