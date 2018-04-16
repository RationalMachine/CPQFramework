package step_definitions;

import PageObjects.CPQHomePage;
import PageObjects.LoginPage;
import Tests.Constants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.LoginAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class CommercePageValidations {

    public WebDriver driver;
    public List<HashMap<String, String>> datamap;

    public CommercePageValidations() {
        driver = Hooks.driver;
    }

    @When("^user opens login page$")
    public void i_open_the_C4C_login_page() throws Throwable {
        driver.get("https://my325462-sso.crm.ondemand.com/sap/byd/runtime");
    }

    /***************************
     **Using get to reload the page because default load does not load the elements in the page
     **************************/
    @Then("^user signs into CPQ$")
    public void they_sign_in() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        LoginAction.Execute(driver);
        driver.get("https://coltuat1.bigmachines.com/commerce/buyside/document.jsp?formaction=create&process=oraclecpqo&document_id=36244034&partnerOpportunityId=260703&_bm_cm_new_transaction_currency=USD");
    }


    @Then("^user asserts deal class is bronze$")
    public void deal_class()throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        Constants.waitForBrowserReadystateComplete(driver);
        Thread.sleep(20000);
        Assert.assertEquals(CPQHomePage.dealClass.getAttribute("textContent"), "Bronze");
    }

    @Then("^user asserts legal complexity is standard$")
    public void legal_complexity()throws Throwable{
        PageFactory.initElements(driver, CPQHomePage.class);
        Constants.waitForBrowserReadystateComplete(driver);
        Thread.sleep(20000);
        Assert.assertEquals(CPQHomePage.legalComplexity.getAttribute("textContent"), "Standard");
        //https://coltuat1.bigmachines.com/commerce/buyside/document.jsp
        //https://coltuat1.bigmachines.com/commerce/buyside/document.jsp?formaction=create&process=oraclecpqo&document_id=36244034&partnerOpportunityId=260703&_bm_cm_new_transaction_currency=USD
        //https://coltuat1.bigmachines.com/commerce/buyside/document.jsp?page=%2Fcommerce%2Fbuyside%2Fdocument.jsp&document_id=36244034&OCN=100117674&formaction=create&process=oraclecpqo&BM_URL_CAPTURE_COOKIE=coltuat1&BM_BROWSER_COOKIE=Netscape
    }

    @Then("^user asserts goapproval is y$")
    public void goapproval_flag()throws Throwable{
        Assert.assertEquals(CPQHomePage.goApproval.getText(), "Y");
    }

    @Then("^user asserts opportunity name is test_nam$")
    public void oppo_name()throws Throwable{
        Assert.assertEquals(CPQHomePage.opponame.getText(), "Test_Nam");
    }

    @Then("^user asserts pricing segment is whss$")
    public void pricing_seg()throws Throwable{
        Assert.assertEquals(CPQHomePage.pricingSegment.getText(), "WHSS");
    }

    @Then("^user asserts new logo is N$")
    public void newlogo()throws Throwable{
        Assert.assertEquals(CPQHomePage.newlogo.getText(), "N");
    }

    //Scenario 2:
    @Then("^user navigates to the approval tab$")
    public void approval_nav()throws Throwable{
        CPQHomePage.approvaltab.click();
        Thread.sleep(10000);
    }

    @Then("^user asserts if submit to approval button exists$")
    public void approval_btn()throws Throwable{
        Assert.assertTrue(CPQHomePage.approvalbtn.isDisplayed());
    }
}
