package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {
    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        new HomePage(getDriver()).clickBtnSignUp();
        new RegistrationPage(getDriver()).typeRegistrationForm("German","Kogan","frodo_baggins_"+i+"@ua.com","Password123!");

    }
}
