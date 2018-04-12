package modules;

import PageObjects.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import Tests.Constants;

import static Tests.Constants.cpq;

public class LoginAction {

    public static void Execute(WebDriver driver){

        cpq.waitUntilVisible(driver, 60, LoginPage.username);
        LoginPage.username.sendKeys("abhishek.bahadur@colt.net");
        cpq.waitUntilVisible(driver, 60, LoginPage.password);
        LoginPage.password.sendKeys("Colt1234");
        cpq.waitUntilVisible(driver, 60, LoginPage.loginButton);
        LoginPage.loginButton.click();

        try {
            Thread.sleep(10000);
            cpq.waitUntilVisible(driver, 60, LoginPage.popUp);
            LoginPage.popUp.click();
        } catch (Exception e) {

        }

        Constants.waitUntilClickable(driver, 60, LoginPage.customerDropdown);
        LoginPage.customerDropdown.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Constants.waitUntilClickable(driver, 60, LoginPage.accounts);
        LoginPage.accounts.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Constants.waitUntilClickable(driver, 60, LoginPage.searchButton);
        LoginPage.searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Constants.waitUntilClickable(driver, 60, LoginPage.searchEditField);
        LoginPage.searchEditField.sendKeys("Mohit");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LoginPage.searchEditField.sendKeys(Keys.ENTER);

        Constants.waitUntilVisible(driver, 40, LoginPage.mohitSearchResult);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LoginPage.mohitSearchResult.click();

        Constants.waitUntilVisible(driver, 30, LoginPage.opportunities);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LoginPage.opportunities.click();

        Constants.waitUntilVisible(driver, 30, LoginPage.searchIcon);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LoginPage.searchIcon.click();

        Constants.waitUntilVisible(driver, 10, LoginPage.searchField);

        LoginPage.searchField.sendKeys("Test_Nam");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Constants.waitUntilClickable(driver, 20, LoginPage.searchIconShowResult);
        LoginPage.searchIconShowResult.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Constants.waitUntilVisible(driver, 60, LoginPage.quotes);
        //Click on Quotes
        LoginPage.quotes.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //wait for Add
        Constants.waitUntilVisible(driver, 40, LoginPage.add);
        //Click on ADD
        LoginPage.add.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Reporter.log("SignIn Action is successfully perfomred");

    }
}
