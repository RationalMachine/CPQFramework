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

    //Appends all the ended tests to the HTML report
    @AfterSuite
    public void afterSuiteMethod() {
        extent.flush();
    }

    //Takes screenshot after every method
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

    //Method to login to CPQ
	@Test
	public void login(){
		
		//Login to C4C
		
			//Instantiate all the Page Objects
			LoginPage loginPage = new LoginPage(driver);
			HomePage homeMenu = new HomePage(driver);
			CPQHomePage cpHome = new CPQHomePage(driver);

			//Steps to Login to C4C
			cpq.waitUntilVisible(driver, 60, loginPage.username);
			loginPage.username.sendKeys(cpq.readPropFile("username"));
			loginPage.password.sendKeys(cpq.readPropFile("password"));
			loginPage.loginButton.click();
			
		    //Handle the pop up window right after clicking log in C4C button
			try {
				Thread.sleep(10000);
				cpq.waitUntilClickable(driver, 60, loginPage.popUp);
				loginPage.popUp.click();
			}catch(Exception e) {
				
			}
			
			 //Click on the dropdown to go to the Launch HTML5 page
			 cpq.waitUntilVisible(driver, 60, loginPage.dropDown);
			 loginPage.dropDown.click();

			 //Click on Launch HTML5 page
			 cpq.waitUntilVisible(driver, 60, loginPage.launchHTML5);
			 loginPage.launchHTML5.click();

			 //New tab opens up. Handling it here.
             //Also, you can put all the handles available into a Set<String>
             //using gerWindowHandles() and then iterate through it!
             //Good use of Collection use case
			 Iterator<String> iterator = driver.getWindowHandles().iterator();
             String parent = (String) iterator.next();
             String child = (String) iterator.next();          
             driver.switchTo().window(child);

             //Pop up handler for the new Tab
             //Good source for learning about JVM Uncaught Exception Handling
             //https://medium.com/yohan-liyanage/know-the-jvm-series-1-the-uncaught-exception-handler-beb3ea1edb14
        /    //In case you want to avoid try{}catch(){} in these kind of cases
             try {
            	 cpq.waitUntilClickable(driver, 60, loginPage.popUpHtml);
            	 loginPage.popUpHtml.click();
             }catch(Exception e) {
            	 
             }

             //Click on customers menu
             cpq.waitUntilClickable(driver, 60, homeMenu.customers);
             homeMenu.customers.click();
             try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			 //Click on the searchfield in the Account page
             cpq.waitUntilClickable(driver, 60, homeMenu.searchField);
             homeMenu.searchField.click();
             homeMenu.searchField.sendKeys("Mohit");
             try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			 //Click on the ENTER key after sendKeys above
             homeMenu.searchField.sendKeys(Keys.ENTER);
             try {
 				Thread.sleep(1000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
             
             //Click on the correct Mohit
             //For a change in account, just make the changes in PageObjects
             //And make sure you do sendKeys for the correct account in the
             //above fields
             cpq.waitUntilClickable(driver, 60, homeMenu.mohit);
             homeMenu.mohit.click();

             //Click on Opportunities
             cpq.waitUntilClickable(driver, 60, homeMenu.opportunities);
             homeMenu.opportunities.click();

             //Click in the Search Field for Opportunities and sendKeys
             cpq.waitUntilClickable(driver, 60, homeMenu.oppSearch);
             homeMenu.oppSearch.click();
             homeMenu.oppSearch.sendKeys("Test_Nam");
             try {
 				Thread.sleep(1000);
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}

 			 //Click Enter
             homeMenu.oppSearch.sendKeys(Keys.ENTER);

             //Click on Test_Nam
             cpq.waitUntilClickable(driver, 60, homeMenu.testNam);
             homeMenu.testNam.click();

             //Sleep for a while since the page keeps refreshing
             try {
  				Thread.sleep(5000);
  			} catch (InterruptedException e) {
  				e.printStackTrace();
  			}
             
             //There are dynamic IDs for Quotes
             //Make a note of all the xpaths you might try to fix this
             cpq.waitUntilClickable(driver, 60, homeMenu.Quotes);
             homeMenu.Quotes.click();            
             try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			 //Click o Add to go to CPQ
             cpq.waitUntilClickable(driver, 60, homeMenu.goToCPQ);
             homeMenu.goToCPQ.click();

             try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			 //Unused takeScreenshot method here
             //Commenting it out since ExtentReports is handling it above
             //takeScreenshot(driver, "/Users/himrekha/eclipse-workspace/FlintAutomation/CPQ.png");
		
             Assert.assertTrue(homeMenu.feed.isDisplayed());
	}

	
	
	

}
