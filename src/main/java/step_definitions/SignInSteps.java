package step_definitions;

import PageObjects.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.LoginAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class SignInSteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;

    public SignInSteps(){
        driver = Hooks.driver;
    }

    @When("^I open the C4C login page$")
    public void i_open_the_C4C_login_page() throws Throwable{
        driver.get("https://my325462-sso.crm.ondemand.com/sap/byd/runtime");
    }


    @Then("^I sign in$")
    public void i_sign_in() throws Throwable{
        PageFactory.initElements(driver, LoginPage.class);
        LoginAction.Execute(driver);
    }
}
