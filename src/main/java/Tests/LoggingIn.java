package Tests;

import PageObjects.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class LoggingIn extends Constants {

    //Create Objects for CPQ, ExtentReports and ExtentTest



    @BeforeSuite
    public void runBeforeEverything() {
        startSuite();
    }

    //This considers each method present for reporting
    //created startBeforeMethod() in Constants
    @BeforeMethod
    public void runBeforeTest(Method method) {
        //test = extent.createTest(method.getName());
        String name = method.getName();
        startBeforeMethod(name);
    }

    //Sets up the WebDriver by calling setup() method from Constants.java
    @BeforeTest
    public void setUp() {
        driver = cpq.setup();
    }


    @AfterMethod
    public void testEndRun(ITestResult result) throws IOException {
        runAfterTesting(result);
    }

    @AfterTest(dependsOnGroups = "Commerce")
    public void tearDown() {
    driver.quit();
    }

    //Appends all the ended tests to the HTML report
    @AfterSuite(dependsOnGroups = "Commerce")
    public void afterSuiteMethod() {
        extent.flush();
    }


    //Method to login to CPQ
    @Test(groups = "Login")
    //Removing login() and shifting it to Constants class. It's public void here.
    //Removing void and replacing with Object
    public void login() {

        //Login to C4C

        //Instantiate all the Page Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homeMenu = new HomePage(driver);
        CPQHomePage cpHome = new CPQHomePage(driver);
        AccountsPage accountsPage = new AccountsPage(driver);
        MohitPage mohitPage = new MohitPage(driver);
        Test_NamPage test_namPage = new Test_NamPage(driver);

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
        } catch (Exception e) {

        }

        //Click on the dropdown to go to the Launch HTML5 page
        //cpq.waitUntilVisible(driver, 60, loginPage.dropDown);
        //loginPage.dropDown.click();

        //Chrome
        //Click on Customer dropdown
        cpq.waitUntilClickable(driver, 60, loginPage.customerDropdown);
        loginPage.customerDropdown.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cpq.waitUntilClickable(driver, 60, loginPage.accounts);
        loginPage.accounts.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //click on the Search Button
        cpq.waitUntilClickable(driver, 60, accountsPage.searchButton);
        accountsPage.searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Type in "Mohit"
        cpq.waitUntilClickable(driver, 60, accountsPage.searchEditField);
        accountsPage.searchEditField.sendKeys("Mohit");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        accountsPage.searchMagniferIconShowResult.click();

        cpq.waitUntilVisible(driver, 40, accountsPage.mohitSearchResult);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        accountsPage.mohitSearchResult.click();

        cpq.waitUntilVisible(driver, 30, mohitPage.opportunities);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mohitPage.opportunities.click();

        cpq.waitUntilVisible(driver, 30, mohitPage.searchIcon);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mohitPage.searchIcon.click();

        cpq.waitUntilVisible(driver, 10, mohitPage.searchField);

        mohitPage.searchField.sendKeys("Test_Nam");

        cpq.waitUntilClickable(driver, 20, mohitPage.searchIconShowResult);
        mohitPage.searchIconShowResult.click();

        //cpq.waitUntilVisible(driver, 40, mohitPage.testNamSearchResult);
        //mohitPage.testNamSearchResult.click();

        cpq.waitUntilVisible(driver, 60, test_namPage.quotes);
        //Click on Quotes
        test_namPage.quotes.click();
        //wait for Add
        cpq.waitUntilVisible(driver, 40, test_namPage.add);
        //Click on ADD
        test_namPage.add.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Getter for CPQHomePage instance


        Assert.assertTrue(cpHome.addProduct.isDisplayed());
    }


}
