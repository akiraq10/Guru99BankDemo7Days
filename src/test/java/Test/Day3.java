package Test;

import GuruBankPages.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day3 extends Hook{
    LoginPage loginPage;
    String expectedAlert="User or Password is not valid";

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

    @Test
    public void runSS2(){
        loginPage=new LoginPage(driver);
        loginPage.fillUserID("KKK");
        loginPage.fillPassword(readFile.getPassword());
        loginPage.clickLogin();
        assertEquals(expectedAlert,loginPage.msgInsideAlert());
        loginPage.clickOkonAlert();
    }

    @Test
    public void runSS3(){
        loginPage=new LoginPage(driver);
        loginPage.fillUserID(readFile.getUserID());
        loginPage.fillPassword("asd");
        loginPage.clickLogin();
        assertEquals(expectedAlert,loginPage.msgInsideAlert());
        loginPage.clickOkonAlert();
    }

    @Test
    public void runSS4(){
        loginPage=new LoginPage(driver);
        loginPage.fillUserID("dasd");
        loginPage.fillPassword("asd");
        loginPage.clickLogin();
        assertEquals(expectedAlert,loginPage.msgInsideAlert());
        loginPage.clickOkonAlert();
    }

}
