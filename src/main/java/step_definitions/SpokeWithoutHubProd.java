package step_definitions;

import PageObjects.CPQHomePage;
import PageObjects.LoginPage;
import Tests.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.LoginAction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class SpokeWithoutHubProd {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;

    public SpokeWithoutHubProd(){
        driver = Hooks.driver;
    }

    @When("^User opens the C4C login page$")
    public void i_open_the_C4C_login_page() throws Throwable{
        driver.get("https://my325462-sso.crm.ondemand.com/sap/byd/runtime");
    }

    @Given("^He signs in$")
    public void i_sign_in() throws Throwable{
        PageFactory.initElements(driver, LoginPage.class);
        LoginAction.Execute(driver);
    }

    @Then("^I click on Add Product$")
    public void i_click_add() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        Constants.waitUntilVisible(driver, 60, CPQHomePage.addProduct);
        CPQHomePage.addProduct.click();
    }

    @Then("^I hover and click on spoke$")
    public void i_hover_and_click_on_spoke() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        Constants.waitUntilVisible(driver, 60, CPQHomePage.ethernet);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //using Actions to hover and click
        Actions builder = new Actions(driver);
        builder.moveToElement(CPQHomePage.ethernet).moveToElement(CPQHomePage.spoke).click().perform();
    }

    @Then("^I enter the address details for the spoke$")
    public void i_enter_spoke_address() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilClickable(driver, 60, CPQHomePage.addressfieldA);
        CPQHomePage.addressfieldA.sendKeys("3, Julius-Tandler-Platz, Wien, Austria, Wien");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CPQHomePage.addressfieldA.sendKeys(Keys.DOWN);
        CPQHomePage.addressfieldA.sendKeys(Keys.RETURN);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("^I assert if constraint message for hub exists$")
    public void i_assert_constraint_msg_for_hub() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        String msg = "\"Select\" is not a valid option for Bandwidth, please Select Bandwidth from Drop-down.";
        Assert.assertEquals(CPQHomePage.hubMessage.getText(), msg);
    }

    @Then("^I click on start over button$")
    public void i_click_on_start_over(){
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CPQHomePage.startOver.click();
        driver.switchTo().alert().accept();
    }

    @And("^I assert if I am in product page$")
    public void i_assert_product_page(){
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(CPQHomePage.ethernet.isDisplayed());
    }
}
