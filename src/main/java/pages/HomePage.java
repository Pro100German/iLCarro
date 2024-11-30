package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    @FindBy(xpath = "//a[@ng-reflect-router-link='login']")
    WebElement btnLogin;
    @FindBy(xpath = "//a[@class='navigation-link ng-star-inserted']")
    WebElement btnSignUp;

    public void clickBtnLoginHeader(){
        btnLogin.click();
        pause(3);
    }
    public void clickBtnSignUp(){
        btnSignUp.click();
        pause(3);
    }

}
