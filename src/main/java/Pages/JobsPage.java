package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class JobsPage extends BasePage{
    public String JOBS_PAGE_URL = "http://167.99.178.249:3000/job-page";
    public final String POSITION_FIELD_XPATH = "//input[@name='position']";
    public final String LOCATION_FIELD_XPATH = "//input[@name='location']";
    public final String COMPANY_FIELD_XPATH = "//input[@name='company']";
    public final String DESCRIPTION_FIELD_XPATH = "//input[@name='description']";
    public final String SEARCH_BUTTON_XPATH = "//button[@class='search-butom'][contains(text(),'search')]";
    public final String POSITION_TITLE_XPATH = "//h2[@class='post-item clearfix']";




    @FindBy(xpath = POSITION_FIELD_XPATH)
    public WebElement POSITION_FIELD_WEBELEMENT;

    @FindBy(xpath = LOCATION_FIELD_XPATH)
    public WebElement LOCATION_FIELD_WEBELEMENT;

    @FindBy(xpath = COMPANY_FIELD_XPATH)
    public WebElement COMPANY_FIELD_WEBELEMENT;

    @FindBy(xpath = DESCRIPTION_FIELD_XPATH)
    public WebElement DESCRIPTION_FIELD_WEBELEMENT;

    @FindBy(xpath = SEARCH_BUTTON_XPATH)
    public WebElement SEARCH_BUTTON_WEBELEMENT;

    @FindBy(xpath =  "//*[contains(text(), 'found')]")
    public WebElement FOUND_SPAN_WEBELEMENT;

    @FindBy(xpath =  "//h2[@class='post-item clearfix']")
    public List<WebElement> POSITION_TITLE_WEBELEMENT;



    public JobsPage() {
        PageFactory.initElements(webDriver,this);//Этот конструктор нужен для использования @FindBy
    }
    public void navigateToJobsPage() {
        webDriver.get(JOBS_PAGE_URL);
    }
    public WebElement locationSearch(String location){
        POSITION_FIELD_WEBELEMENT.sendKeys(location);
        SEARCH_BUTTON_WEBELEMENT.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'found')]")));
        WebElement locationFound = webDriver.findElement(By.xpath("//*[contains(text(), "+location+")]"));
        if (locationFound != null) {
            return locationFound;
        }
        else {
            return null;
        }
    }
    public void positionSearch(String position){
        POSITION_FIELD_WEBELEMENT.sendKeys(position);
        SEARCH_BUTTON_WEBELEMENT.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'found')]")));

    }
    public boolean isSearchResultContainsProvidedText(String searchedValue){
        searchedValue.toUpperCase();
        ArrayList<String> incorrectSearchResults = new ArrayList<String>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='post-item clearfix'][contains(text(),'" + searchedValue + "')]")));
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//h2[@class='post-item clearfix']"));
        for( WebElement item : searchResults){
            String upperCaseItem = item.getText().toUpperCase();
            if (!upperCaseItem.contains(searchedValue)) {
                incorrectSearchResults.add(upperCaseItem);
            }
        }
        for (int i = 0;i<incorrectSearchResults.size();i++) {
            System.out.println(incorrectSearchResults.get(i));
        }
        if (incorrectSearchResults.size() > 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
