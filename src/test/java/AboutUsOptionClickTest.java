import Pages.AboutUsPage;
import Pages.BasePage;
import Pages.HomePage;
import Utilities.UseCaseBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;
public class AboutUsOptionClickTest extends UseCaseBase{
    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();
    AboutUsPage aboutUsPage = new AboutUsPage();
    @Test
    public void aboutUsOptionClick() {
        homePage.navigateToHomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(homePage.ABOUT_BUTTON_XPATH)));
        homePage.ABOUT_BUTTON.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(basePage.LOGO)));
        assertEquals(aboutUsPage.ABOUT_US_PAGE_URL,webDriver.getCurrentUrl());
    }
}
