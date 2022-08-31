import Pages.BasePage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.*;
public class HomePageNavigateTest extends UseCaseBase{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();
    @Test
    public void openHomePage() {
        homePage.navigateToHomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(homePage.LOGO)));
        boolean isLoadedButton = homePage.isLogoVisible();
        assertTrue(isLoadedButton);
        assertEquals(homePage.HOME_PAGE_URL,webDriver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(homePage.COMING_SOON)));
        boolean isComingSoon = homePage.isComingSoonVisible();
        assertTrue(isComingSoon);
    }
}
