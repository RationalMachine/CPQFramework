package step_definitions;

import PageObjects.CPQHomePage;
import PageObjects.LoginPage;
import Tests.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Pa;
import modules.LoginAction;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class CanAddHubProduct {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;

    public CanAddHubProduct(){
        driver = Hooks.driver;
    }

    @When("^they open C4C site$")
    public void i_open_the_C4C_login_page() throws Throwable{
        driver.get("https://my325462-sso.crm.ondemand.com/sap/byd/runtime");
    }

    @Then("^they sign in$")
    public void they_sign_in() throws Throwable{
        PageFactory.initElements(driver, LoginPage.class);
        LoginAction.Execute(driver);
    }

    @Then("^user clicks on add product$")
    public void clicks_add_product() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilClickable(driver, 60, CPQHomePage.addProduct);
        CPQHomePage.addProduct.click();
    }

    @Then("^user selects Hub from the dropdown$")
    public void selects_hub() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        Constants.waitUntilVisible(driver, 60, CPQHomePage.ethernet);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //using Actions to hover and click
        Actions builder = new Actions(driver);
        builder.moveToElement(CPQHomePage.ethernet).moveToElement(CPQHomePage.hub).click().perform();
    }

    @Then("^user is able to enter the address$")
    public void enters_address() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        Constants.waitUntilVisible(driver, 60, CPQHomePage.addressfieldA);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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




    @Then("^user is able to see check connectivity button$")
    public void user_checks_connbtn() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.checkConnectivityBtn);
        Assert.assertTrue(CPQHomePage.checkConnectivityBtn.isDisplayed());
    }

    @Then("^user clicks check connectivity button$")
    public void click_connbtn() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.checkConnectivityBtn);
        CPQHomePage.checkConnectivityBtn.click();
    }

    @Then("^user asserts that tab is created for features$")
    public void checks_features_tab() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.features);
        Assert.assertTrue(CPQHomePage.features.isDisplayed());
    }

    @And("^user asserts that tab is created for site details$")
    public void checks_sitedetails_tab() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.siteDetails);
        Assert.assertTrue(CPQHomePage.siteDetails.isDisplayed());
    }

    @Then("^user asserts that clicking on site details tab takes them to it$")
    public void go_to_sitedetails() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.siteDetails);
        CPQHomePage.siteDetails.click();
        Constants.waitUntilVisible(driver, 60, CPQHomePage.resiliency);
        Assert.assertTrue(CPQHomePage.resiliency.isDisplayed());
    }

    @Then("^user selects bandwidth of 1g from dropdown$")
    public void dropdown_band() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select bandDrop = new Select(CPQHomePage.bandwidthDrop);
        bandDrop.selectByValue("1 Gbps");
    }

    @Then("^user selects resiliency as gold$")
    public void select_gold() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.resiliency);
        Select resDrop = new Select(CPQHomePage.resiliency);
        resDrop.selectByValue("Gold");
    }

    @Then("^user asserts if base prices shown in table$")
    public void base_price_table() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.basePrice);
        Assert.assertTrue(CPQHomePage.basePrice.isDisplayed());
    }

    @Then("^user goes to features tab and adds obh and fast track$")
    public void add_obh_fast() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CPQHomePage.features.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Constants.waitUntilClickable(driver, 60, CPQHomePage.obhA);
        //Actions radioaction = new Actions(driver);
        //radioaction.moveToElement(CPQHomePage.obhA).click().perform();
        //CPQHomePage.obhA.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", CPQHomePage.obhA);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Constants.waitUntilClickable(driver, 60, CPQHomePage.fastTrackradio);
        //CPQHomePage.fastTrackradio.click();
        //radioaction.moveToElement(CPQHomePage.fastTrackradio).click().perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", CPQHomePage.fastTrackradio);
    }

    @Then("^user asserts if both the features present in table")
    public void feature_table() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.fastTrackTableCheck);
        Assert.assertTrue(CPQHomePage.fastTrackTableCheck.isDisplayed());
    }

    @Then("^user clicks update button$")
    public void update_btn()throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilClickable(driver, 60, CPQHomePage.updatebtn);
        CPQHomePage.updatebtn.click();
    }

    @Then("^user clicks save to quote$")
    public void save_to_quote() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.saveToQuote);
        CPQHomePage.saveToQuote.click();
    }


    @Then("^user asserts CPQ page has the product added$")
    public void cpq_assert_product() throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Constants.waitUntilVisible(driver, 60, CPQHomePage.productTable);
        Assert.assertTrue(CPQHomePage.productTable.isDisplayed());
    }
}