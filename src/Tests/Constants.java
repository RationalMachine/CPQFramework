package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class Constants{


    public  WebDriver driver;


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
