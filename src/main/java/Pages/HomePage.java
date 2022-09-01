package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public String HOME_PAGE_URL = "http://167.99.178.249:3000/";

    public final String COMING_SOON = "//img[@src='/img/JC_comingSoon.jpg']";
    public static final String ABOUT_BUTTON_XPATH = "//a[@name='About']";

    @FindBy(xpath = "//a[@name='About']")
    public WebElement ABOUT_BUTTON;

    public HomePage() {
        PageFactory.initElements(webDriver,this);//Этот конструктор нужен для использования @FindBy
    }

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
