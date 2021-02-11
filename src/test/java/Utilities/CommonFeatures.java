package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

public class CommonFeatures {

    public static WebDriver driver;
    public static WebDriverWait driverWait;

    public static WebDriver browser(String browser) {

        switch (browser) {
            case "chrome":
                System.out.println("Launch browser: Chrome");
                System.setProperty("webdriver.chrome.driver", ".\\src\\test\\WebDriver\\chromedriver.exe");
                driver = new ChromeDriver(new ChromeOptions().setAcceptInsecureCerts(true));

                break;
            case "firefox":
                System.out.println("Launch browser: Firefox");
                System.setProperty("webdriver.gecko.driver", ".\\src\\WebDriver\\geckodriver.exe");
                driver = new FirefoxDriver(new FirefoxOptions().setAcceptInsecureCerts(true));

                break;

            default:
                throw new IllegalAccessError("Browser: " + browser + " does not define ");

        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        return driver;

    }

    public static void url(String https){
        driver.get(https);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);


    }

    public static WebDriver gotoUrl(String browser, String https){
        browser(browser);
        url(https);
        return driver;
    }

    public static void closeBrowser(){

        driver.quit();

    }

    public static void fill(WebElement element,String contains){
        if(!element.isDisplayed())
        {
            return;
        }
        else {
            element.clear();
            element.sendKeys(contains);
        }

    }
    public static void click(WebElement element){
        if (!element.isDisplayed()){
            return;
        }else element.click();
    }

    public static void captureScreen(WebDriver driver, String tname) throws IOException  {

        TakesScreenshot scrShot  = ((TakesScreenshot) driver);
        File srcFile = scrShot .getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/IMG/" + tname + ".png");
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("Screenshot taken");
    }




}
