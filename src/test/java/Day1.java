import Utilities.ReadFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class Day1 {
    static String url="http://demo.guru99.com/V4/";
    static WebElement txtUserID;
    static WebElement txtPassword;
    static WebElement btnLogin;
    static String expectedResult1="Guru99 Bank Home Page";
    static String expactedResult2="Guru99 Bank Manager HomePage";
    static ReadFile readFile;




    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        readFile =new ReadFile();


        driver.get(url);

        assertEquals(expectedResult1,driver.getTitle());

        txtUserID=driver.findElement(By.name("uid"));
        txtUserID.sendKeys(readFile.getUserID());

        txtPassword=driver.findElement(By.name("password"));
        txtPassword.sendKeys(readFile.getPassword());

        btnLogin= driver.findElement(By.name("btnLogin"));
        btnLogin.click();
        assertEquals(expactedResult2,driver.getTitle());

        driver.quit();


    }
}
