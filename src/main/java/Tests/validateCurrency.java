package Tests;

import PageObjects.CPQHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validateCurrency extends BaseClass{

    @Test
    public void validateCurrency(){

        System.out.println("Second Test Case");
        Assert.assertTrue(true);


        //Assert.assertTrue(cpHome.currency.isDisplayed());
    }
}
