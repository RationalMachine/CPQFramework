package Tests;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.*;

public class LoggingIn extends Constants{
	
	
	Constants cpq = new Constants();
	
	
	@BeforeTest
	public void setUp() {
		driver = cpq.setup();
	}
	
	//@AfterTest
	//public void tearDown() {
	//	driver.quit();
	//}
	
	@Test
	public void login(){
		
		//Login to C4C
		
			
			LoginPage loginPage = new LoginPage(driver);
			HomePage homeMenu = new HomePage(driver);
			
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
  				Thread.sleep(1000);
  			} catch (InterruptedException e) {
  				e.printStackTrace();
  			}
             
             cpq.waitUntilVisible(driver, 60, homeMenu.Quotes);
             //cpq.waitUntilClickable(driver, 60, homeMenu.Quotes);
             homeMenu.Quotes.click();
            
             Assert.assertTrue(homeMenu.feed.isDisplayed());
		
		
	}
	
	

}
