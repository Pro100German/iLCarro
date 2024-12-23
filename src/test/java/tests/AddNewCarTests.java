package tests;

import dto.CarDto;
import dto.UserDtoLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetCarWorkPage;
import pages.LoginPage;
import utils.Fuel;

import java.util.Random;


public class AddNewCarTests extends ApplicationManager {
    LoginPage loginPage;
    LetCarWorkPage letCarWorkPage;

    @BeforeMethod
    public void login() {
        UserDtoLombok user = UserDtoLombok.builder()
                .email("myphone@gmail.com")
                .password("German1234!")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        loginPage.clickBtnYalla();
        if (loginPage.isPopUpMessagePresent()) {
            System.out.println("login success");
            loginPage.clickBtnOk();
            loginPage.clickBtnLetCarWork();


        } else
            System.out.println("Something went wrong");

    }

    @Test
    public void addNewCarPositiveTest() {
        CarDto car = CarDto.builder()
                .serialNumber(new Random().nextInt(1000) + "-055")
                .city("Haifa")
                .manufacture("Mazda")
                .model("CX-90")
                .year("2020")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(4)
                .carClass("G")
                .pricePerDay(150.50)
                .about("About my car").build();
        new LetCarWorkPage(getDriver()).typeLetCarWorkForm(car);
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
//            Assert.assertTrue(letCarWorkPage
//                    .isPopUpMessagePresent(car.getManufacture() + " " + car.getModel() + " " + "added successful"));

    }

    @Test
    public void addNewCarNegativeTestWrong() {
        CarDto car = CarDto.builder()
                .serialNumber(new Random().nextInt(1000) + "-055")
                .city("Haifa")
                .manufacture("")
                .model("CX-90")
                .year("2020")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(4)
                .carClass("G")
                .pricePerDay(150.50)
                .about("About my car").build();
        new LetCarWorkPage(getDriver()).typeLetCarWorkForm(car);
        letCarWorkPage = new LetCarWorkPage(getDriver());
        letCarWorkPage.typeLetCarWorkForm(car);
        Assert.assertTrue(LetCarWorkPage.textManufactureErrorMessage());
    }
}
