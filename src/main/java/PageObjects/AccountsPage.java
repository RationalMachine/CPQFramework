package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

    //search button
    @FindBy(xpath = "//span[contains(@id,'searchButton-img')]")
    public WebElement searchButton;

    //search edit field
    @FindBy(xpath = "//input[contains(@id,'searchField-I')]")
    public WebElement searchEditField;

    //search icon show result
    @FindBy(id = "panevariantm8HSa5dpNqg1z8nY0idosG_9-searchField-search")
    public WebElement searchMagniferIconShowResult;

    //Mohit search result
    @FindBy(xpath = "//a[text()='Mohit']")
    public WebElement mohitSearchResult;

    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
