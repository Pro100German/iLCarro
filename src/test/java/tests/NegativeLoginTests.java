package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class NegativeLoginTests extends ApplicationManager {
    LoginPage loginPage;


    @Test
    public void loginPositiveTest() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("myphone@gmail.com")
                .password("German1234")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        Assert.assertFalse(loginPage.isPopUpMessagePresent());

    }
}