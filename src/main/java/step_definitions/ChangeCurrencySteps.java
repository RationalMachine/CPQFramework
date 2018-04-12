package step_definitions;

import PageObjects.LoginPage;
import Tests.Constants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class ChangeCurrencySteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;

    public ChangeCurrencySteps(){
        driver = Hooks.driver;
    }

    @When("^I open the login page$")
    public void i_open_the_C4C_login_page() throws Throwable{
        driver.get("https://my325462-sso.crm.ondemand.com/sap/byd/runtime");
    }


    @Then("^I login$")
    public void i_sign_in_to_cpq() throws Throwable{
        PageFactory.initElements(driver, LoginPage.class);
        LoginAction.Execute(driver);
    }

    @Then("^User changes the currency to GBP from drop down and clicks on change currency button$")
    public void user_changes_currency() throws Throwable{
        PageFactory.initElements(driver, LoginPage.class);
        Constants.waitUntilVisible(driver, 60, LoginPage.changeCurrency);
        Select dropdown = new Select(LoginPage.changeCurrency);
        dropdown.selectByValue("GBP");
        Constants.waitUntilVisible(driver, 60, LoginPage.changeButton);
        LoginPage.changeButton.click();
    }

    @Then("User checks if the quote currency has changed to GBP")
    public void user_checks_if_quote_currency_changed(){
        PageFactory.initElements(driver, LoginPage.class);
        Constants.waitUntilVisible(driver, 60, LoginPage.readCurrency);
        Assert.assertEquals(LoginPage.readCurrency.getText(), "GBP");
    }
}