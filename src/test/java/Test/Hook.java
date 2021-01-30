package Test;

import Utilities.ReadFile;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static Utilities.CommonFeatures.*;

public class Hook {
    WebDriver driver;
    ReadFile readFile;
    @Before
    public void setUp(){
        readFile=new ReadFile();
        driver=gotoUrl(readFile.getBrowser(),readFile.getUrl());

    }
    @After
    public void tearDown(){
        closeBrowser();

    }
}
