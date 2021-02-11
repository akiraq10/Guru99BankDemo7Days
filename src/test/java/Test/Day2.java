package Test;

import GuruBankPages.LoginPage;
import org.testng.annotations.Test;


import static org.junit.Assert.assertEquals;

public class Day2 extends Hook{
    LoginPage loginPage;

    @Test
    public void runSS1(){
        loginPage=new LoginPage(driver);
        String homePageTitle="Guru99 Bank Home Page";
        assertEquals(homePageTitle,driver.getTitle());

        loginPage.fillUserID(readFile.getUserID());
        loginPage.fillPassword(readFile.getPassword());
        loginPage.clickLogin();

        String expectedResult="Guru99 Bank Manager HomePage";
        assertEquals(expectedResult,driver.getTitle());
    }
}
