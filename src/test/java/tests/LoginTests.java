package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends ApplicationManager {
    LoginPage loginPage;


    @Test
    public void loginPositiveTest() {
        //new HomePage(getDriver()).clickBtnLoginHeader();
        //new LoginPage(getDriver()).typeLoginForm("myphone@gmail.com", "German1234!");
        UserDtoLombok user = UserDtoLombok.builder()
                .email("myphone@gmail.com")
                .password("German1234!")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertTrue(loginPage.isPopUpMessagePresent());

    }
}
