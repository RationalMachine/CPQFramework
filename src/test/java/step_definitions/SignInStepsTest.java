package step_definitions;

import PageObjects.LoginPage;
import Tests.Constants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class SignInStepsTest {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;

    public SignInStepsTest(){
        driver = Hooks.driver;
    }

    @When("^login to C4C$")
    public void i_open_the_C4C_login() throws Throwable{
        driver.get("https://my325462-sso.crm.ondemand.com/sap/byd/runtime");
    }


    @Then("^I sign in$")
    public void i_sign_in() throws Throwable{
        PageFactory.initElements(driver, LoginPage.class);
        LoginAction.Execute(driver);
    }

    @Then("^I assert if I am inside CPQ$")
    public void i_assert_if_im_in_cpq() throws Throwable{
        PageFactory.initElements(driver, LoginPage.class);
        Constants.waitUntilVisible(driver, 60, LoginPage.coltlogo);
        Assert.assertTrue(LoginPage.coltlogo.isDisplayed());
    }
}
