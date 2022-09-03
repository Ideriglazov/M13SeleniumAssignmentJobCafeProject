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
        //Could not find the location element
        /*
        jobsPage.navigateToJobsPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_FIELD_XPATH)));
        jobsPage.elementSearch("Toronto");
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Toronto",jobsPage.POSITION_TITLE_XPATH));
        jobsPage.elementSearch("Tel-Aviv");
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Tel-Aviv", jobsPage.POSITION_TITLE_XPATH));
        jobsPage.elementSearch("Chicago");
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Chicago",jobsPage.POSITION_TITLE_XPATH ));
        jobsPage.elementSearch("New-York");
        assertTrue(jobsPage.isSearchResultContainsProvidedText("New-York",jobsPage.POSITION_TITLE_XPATH));
*/
        jobsPage.navigateToJobsPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.POSITION_FIELD_XPATH)));
        //Position search
        jobsPage.elementSearch("QA",jobsPage.POSITION_FIELD_WEBELEMENT);
        assertTrue(jobsPage.isSearchResultContainsProvidedText("QA",jobsPage.POSITION_TITLE_XPATH));
        jobsPage.elementSearch("Developer",jobsPage.POSITION_FIELD_WEBELEMENT);
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Developer",jobsPage.POSITION_TITLE_XPATH));
        jobsPage.elementSearch("Project Manager",jobsPage.POSITION_FIELD_WEBELEMENT);
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Project Manager",jobsPage.POSITION_TITLE_XPATH));
        //Company search
        jobsPage.elementSearch("Apple",jobsPage.COMPANY_FIELD_WEBELEMENT);
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Apple",jobsPage.COMPANY_TITLE_XPATH));
        jobsPage.elementSearch("Facebook",jobsPage.COMPANY_FIELD_WEBELEMENT);
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Facebook",jobsPage.COMPANY_TITLE_XPATH));
        jobsPage.elementSearch("Google",jobsPage.COMPANY_FIELD_WEBELEMENT);
        assertTrue(jobsPage.isSearchResultContainsProvidedText("Google",jobsPage.COMPANY_TITLE_XPATH));
        //Combined search by position and company name without location
        jobsPage.COMPANY_FIELD_WEBELEMENT.sendKeys("Google");
        jobsPage.POSITION_FIELD_WEBELEMENT.sendKeys("Manager");
        jobsPage.SEARCH_BUTTON_WEBELEMENT.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jobsPage.FOUND_SPAN_XPATH)));
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

//Below is my failed attempt to find job locations using relative locators and store the values in an arraylist
// in order to verify them later.
    /*
    @Test
    public void xpathVerify() {
        jobsPage.navigateToJobsPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsPage.LOCATION_FIELD_XPATH)));
        jobsPage.elementSearch("Toronto");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(jobsPage.POSITION_TITLE_XPATH)));

        List <WebElement> companyNameWebElements = webDriver.findElements(By.xpath("//p[@style='color: rgb(37, 82, 105);']"));
        List<WebElement> locations = new ArrayList<>();
        for (WebElement companyName : companyNameWebElements) {
            for (WebElement location : locations) {
                location = webDriver.findElement(with(By.tagName("span")).below(companyName));
            }
        }
        //List<WebElement> locations = webDriver.findElements(with(By.tagName("span")).below(companyNameWebElements));
        for (WebElement item : locations) {
            System.out.println(item.getText());
        }
    }
*/
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
