package pages;

import dto.UserDtoLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//button[@type='button']")
    WebElement btnOk;
    //h2[@class='message']
    @FindBy(id="1")
    WebElement btnLetCarWork;

    public void clickBtnOk(){
        clickWait(btnOk,5);
    }

    public void clickBtnLetCarWork(){
        clickWait(btnLetCarWork,5);
    }

    public void typeLoginForm(UserDtoLombok user){
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());

    }
    public void clickBtnYalla(){
        btnYalla.click();
    }
    public boolean isPopUpMessagePresent(){
        return isTextInElementPresent(popUpMessage,"Logged in success");

    }
    public void typeLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        btnYalla.click();
        btnOk.click();

    }

}
