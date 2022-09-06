package Utilities;
import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;

public class UseCaseBase {
    protected static WebDriver webDriver;
    private static BasePage page;
    public WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = SharedDriver.getWebDriver(SharedDriver.Broswer.CHROME);
        page.setWebDriver(webDriver);
        System.setProperty("webdriver.chrome.logfile", "C:\\chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
    }

    @AfterAll
    public static void tearDownMain() {
        SharedDriver.closeDriver();
        webDriver = null;
    }
}
