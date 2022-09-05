import Pages.JobsPage;
import Pages.AboutUsPage;
import Pages.BasePage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class JobsSearchTest extends UseCaseBase{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();
    AboutUsPage aboutUsPage = new AboutUsPage();
    JobsPage jobsPage = new JobsPage();
    @Test
    public void jobSearch() {
        jobsPage.navigateToJobsPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_FIELD_XPATH)));
        //location search
        jobsPage.elementSearch("Toronto",jobsPage.LOCATION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Toronto",jobsPage.LOCATION_TITLE_XPATH));

        jobsPage.elementSearch("Tel-Aviv",jobsPage.LOCATION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Tel-Aviv", jobsPage.LOCATION_TITLE_XPATH));

        jobsPage.elementSearch("Chicago",jobsPage.LOCATION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Chicago",jobsPage.LOCATION_TITLE_XPATH ));

        jobsPage.elementSearch("New-York",jobsPage.LOCATION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("New-York",jobsPage.LOCATION_TITLE_XPATH));
        //Position search
        jobsPage.elementSearch("QA",jobsPage.POSITION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.POSITION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("QA",jobsPage.POSITION_TITLE_XPATH));

        jobsPage.elementSearch("Developer",jobsPage.POSITION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.POSITION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Developer",jobsPage.POSITION_TITLE_XPATH));

        jobsPage.elementSearch("Project Manager",jobsPage.POSITION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.POSITION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Project Manager",jobsPage.POSITION_TITLE_XPATH));
        //Company search
        jobsPage.elementSearch("Apple",jobsPage.COMPANY_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.COMPANY_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Apple",jobsPage.COMPANY_TITLE_XPATH));

        jobsPage.elementSearch("Facebook",jobsPage.COMPANY_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.COMPANY_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Facebook",jobsPage.COMPANY_TITLE_XPATH));

        jobsPage.elementSearch("Google",jobsPage.COMPANY_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.COMPANY_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Google",jobsPage.COMPANY_TITLE_XPATH));
        //Combined search by position and company name without location
        jobsPage.COMPANY_FIELD_WEBELEMENT.sendKeys("Google");
        jobsPage.POSITION_FIELD_WEBELEMENT.sendKeys("Manager");
        jobsPage.SEARCH_BUTTON_WEBELEMENT.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jobsPage.COMPANY_TITLE_XPATH)));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jobsPage.POSITION_TITLE_XPATH)));
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Google",jobsPage.COMPANY_TITLE_XPATH) && jobsPage.isSearchResultContainsProvidedText("Manager",jobsPage.POSITION_TITLE_XPATH));
        //abracadabra search in the position field
        jobsPage.elementSearch("abracadabra",jobsPage.POSITION_FIELD_WEBELEMENT);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jobsPage.NO_RESULTS_MESSAGE_XPATH)));
        assertTrue(jobsPage.isMessageDisplayed(jobsPage.NO_RESULTS_MESSAGE_WEBELEMENT));
    }
    @Test
    public void resetButtonTest() {
        jobsPage.navigateToJobsPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.POSITION_FIELD_XPATH)));
        jobsPage.resetButtonCheck();
        assertTrue(jobsPage.POSITION_FIELD_WEBELEMENT.getAttribute("value").equals(""));
        assertTrue(jobsPage.LOCATION_FIELD_WEBELEMENT.getAttribute("value").equals(""));
        assertTrue(jobsPage.COMPANY_FIELD_WEBELEMENT.getAttribute("value").equals(""));
        assertTrue(jobsPage.DESCRIPTION_FIELD_WEBELEMENT.getAttribute("value").equals(""));
    }

@Test
public void logsTest() {
    LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
    List<LogEntry> logs = entries.getAll();
    for (LogEntry e : logs) {
        System.out.println("Message : " + e.getMessage());
        System.out.println("Level : " + e.getLevel());
        Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
    }
}
}
