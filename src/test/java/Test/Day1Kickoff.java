package Test;

import GuruBankPages.LoginPage;
import Utilities.ReadFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static Utilities.CommonFeatures.*;
import static org.junit.Assert.assertEquals;

public class Day1Kickoff {

    WebDriver driver;
    ReadFile readFile;
    LoginPage page;
    String mainPageTitle="Guru99 Bank Home Page";

    @Before
    public void setUp(){
        readFile =new ReadFile();
        driver=gotoUrl(readFile.getBrowser(), readFile.getUrl());
        assertEquals(mainPageTitle,driver.getTitle());

    }

    @Test
    public void jTest(){

        page=new LoginPage(driver);
        page.fillUserID(readFile.getUserID());
        page.fillPassword(readFile.getPassword());
        page.clickLogin();

        String expectedResult="Guru99 Bank Manager HomePage";
        assertEquals(expectedResult,driver.getTitle());
    }


    @After
    public void tearDown(){
        closeBrowser();
    }
}
