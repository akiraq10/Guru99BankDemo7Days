package GuruBankPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static Utilities.CommonFeatures.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "uid") WebElement txtUserID;
    @FindBy(name = "password") WebElement txtPassword;
    @FindBy(name="btnLogin") WebElement btnLogin;


    public LoginPage(WebDriver driver) {
        this.driver = driver;

        AjaxElementLocatorFactory ajax=new AjaxElementLocatorFactory(driver,30);
        PageFactory.initElements(ajax, this);

    }

    public String getTitle(){

        return driver.getTitle();
    }

    public void fillUserID(String userID){
        fill(txtUserID,userID);

    }
    public void fillPassword(String password){
        fill(txtPassword,password);
    }
    public void clickLogin(){
        click(btnLogin);
    }
}
