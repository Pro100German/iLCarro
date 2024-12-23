package tests;

import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {
    RegistrationPage registrationPage;


    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000)+1000;
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastName("Doe")
                .email(i+ "bobi_@ua.com")
                .password("Password1234!")
                .build();
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
       // new RegistrationPage(getDriver()).typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.isPopUpMessagePresent());
      //  new HomePage(getDriver()).clickBtnSignUp();
      //  new RegistrationPage(getDriver()).typeRegistrationForm("German", "Kogan", "frodo_baggins_" + i + "@ua.com", "Password123!");
    }
    @Test
    public void registrationNegativeTestWrongEmail(){
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Bob")
                .lastName("Doe")
                .email("bobi_@ua..com")
                .password("Password1234!")
                .build();
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.validateErrorMessege("Wrong email format"));
    }
    @Test
    public void registrationNegativeTestWrongName(){
        UserDtoLombok user = UserDtoLombok.builder()
                .name(" ")
                .lastName("Asd")
                .email("bobi_@ua.com")
                .password("Password1234!")
                .build();
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertFalse(registrationPage.textNameErrorMessage());
    }
    @Test
    public void registrationNegativeTestWrongLastName(){
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Asd")
                .lastName(" ")
                .email("bobi_@ua.com")
                .password("Password1234!")
                .build();
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
        Assert.assertTrue(registrationPage.isPopUpMessagePresent("не должно быть пустым"));
    }
    @Test
    public void registrationNegativeTestWrongPassword(){
        UserDtoLombok user = UserDtoLombok.builder()
                .name("Asd")
                .lastName("Bob")
                .email("bobi_@ua.com")
                .password("Password")
                .build();
        new HomePage(getDriver()).clickBtnSignUp();
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.typeRegistrationForm(user);
        registrationPage.clickCheckBox();
        registrationPage.clickBtnYalla();
    }

}
