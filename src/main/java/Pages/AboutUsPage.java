package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class AboutUsPage extends BasePage {
    public String ABOUT_US_PAGE_URL = "http://167.99.178.249:3000/about";
    public boolean isLogoVisible(){
        return elementExists(LOGO);
    }
}
