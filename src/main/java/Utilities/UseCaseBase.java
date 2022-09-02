package Utilities;
import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UseCaseBase {
    protected static WebDriver webDriver;
    private static BasePage page;
    public WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        webDriver = SharedDriver.getWebDriver(SharedDriver.Broswer.CHROME);
        page.setWebDriver(webDriver);
    }
/*
    @AfterAll
    public static void tearDownMain() {
        SharedDriver.closeDriver();
        webDriver = null;
    }

 */
}
