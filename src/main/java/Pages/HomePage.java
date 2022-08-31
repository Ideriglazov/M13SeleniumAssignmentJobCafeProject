package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public static final String HOME_PAGE_URL = "http://167.99.178.249:3000/";
    public static final String LOGO = "//img[@src='assets/img/logo.png']";
    public static final String COMING_SOON = "/img/JC_comingSoon.jpg";

    @FindBy(xpath = "//a[@name='About']")
    public WebElement ABOUT_BUTTON;

    public void navigateToHomePage() {
        webDriver.get(HOME_PAGE_URL);
    }
    public boolean isLogoVisible(){
        return elementExists(LOGO);
    }
    public boolean isComingSoonVisible(){
        return elementExists(COMING_SOON);
    }
}
