package Test;

import Utilities.ReadFile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static Utilities.CommonFeatures.*;

public class Hook {
    WebDriver driver;
    ReadFile readFile;
    @BeforeMethod
    public void setUp(){
        readFile=new ReadFile();
        driver=gotoUrl(readFile.getBrowser(),readFile.getUrl());

    }
    @AfterMethod
    public void tearDown(){
        closeBrowser();

    }
}
