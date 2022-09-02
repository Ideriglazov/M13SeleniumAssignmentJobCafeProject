import Pages.JobsPage;
import Pages.AboutUsPage;
import Pages.BasePage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JobsSearchTest extends UseCaseBase{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();
    AboutUsPage aboutUsPage = new AboutUsPage();
    JobsPage jobsPage = new JobsPage();
    @Test
    public void JobSearch() {
        jobsPage.navigateToJobsPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_FIELD_XPATH)));
        WebElement locationFound = jobsPage.locationSearch("Toronto");
        assertTrue(locationFound != null);
        locationFound = jobsPage.locationSearch("Tel-Aviv");
        assertTrue(locationFound != null);
        locationFound = jobsPage.locationSearch("Chicago");
        assertTrue(locationFound != null);
        locationFound = jobsPage.locationSearch("New-York");
        assertTrue(locationFound != null);

        jobsPage.navigateToJobsPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.POSITION_FIELD_XPATH)));
        jobsPage.positionSearch("QA");

        assertTrue(jobsPage.isSearchResultContainsProvidedText("QA"));
        /*
        jobsPage.positionSearch("Developer");
        assertTrue(jobsPage.isElementsContainsProvidedText("Developer"));
        jobsPage.positionSearch("Project Manager");
        assertTrue(jobsPage.isElementsContainsProvidedText("Project Manager"));
         */
    }
}
