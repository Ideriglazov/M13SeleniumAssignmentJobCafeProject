import Pages.BasePage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.logging.Level;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class HomePageNavigateTest extends UseCaseBase{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();
    @Test
    public void openHomePage() {
        homePage.navigateToHomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(basePage.LOGO)));
        boolean isLoadedButton = homePage.isLogoVisible();
        assertTrue(isLoadedButton);
        assertEquals(homePage.HOME_PAGE_URL,webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(homePage.COMING_SOON)));
        boolean isComingSoon = homePage.isComingSoonVisible();
        assertTrue(isComingSoon);
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
        //Assertions.assertEquals(0, logs.size());
    }

}
