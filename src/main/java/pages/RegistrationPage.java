package pages;

import dto.UserDtoLombok;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.swing.*;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//label[@for='terms-of-use']")
    WebElement btnCheckBox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath = "//button[@type='button']")
    WebElement btnOk;
    @FindBy(xpath = "//h2[@class='message']")
    WebElement popUpMessage;

    public void typeRegistrationForm(UserDtoLombok user){
        inputName.sendKeys(user.getName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
    }
    public void clickCheckBox(){
       // btnCheckBox.click();
        System.out.println(btnCheckBox.getRect().getWidth()+"X"+btnCheckBox.getRect().getHeight());
        int widthCheckBox = btnCheckBox.getRect().getWidth();
        int heightCheckBox = btnCheckBox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement(btnCheckBox,-widthCheckBox/3,heightCheckBox/4).click().perform();
    }
    public void clickBtnYalla(){
        btnYalla.click();
    }
    public boolean isPopUpMessagePresent(){
        return isTextInElementPresent(popUpMessage,"You are logged in success");

    }
//    public void typeRegistrationForm(String name, String lastName, String email, String password) {
//        inputName.sendKeys(name);
//        inputLastName.sendKeys(lastName);
//        inputEmail.sendKeys(email);
//        inputPassword.sendKeys(password);
//        btnCheckBox.click();
//        btnYalla.click();
//        btnOk.click();
//
//    }

}
