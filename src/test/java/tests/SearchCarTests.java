package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultsPage;
import pages.HomePage;

public class SearchCarTests extends ApplicationManager {
    HomePage HomePage;

    @Test
    public void searchCarPositiveTest(){
        HomePage = new HomePage(getDriver());
        HomePage.fillSearchCarFormWOCalendar("Haifa", "12/25/2024", "12/27/2024");
        Assert.assertTrue(new ResultsPage(getDriver()).isUrlResultsPresent());
    }
}