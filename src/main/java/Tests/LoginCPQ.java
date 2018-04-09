package Tests;

import PageObjects.CPQHomePage;
import org.testng.annotations.Test;

public class LoginCPQ extends BaseClass{

    @Test
    public void loggingIntoCPQ(){
        login("my325462-sso.crm.ondemand.com/sap/byd/runtime");
    }
}
