package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public final String COMPANY_TITLE_XPATH = "//b";
    public final String FOUND_SPAN_XPATH = "//*[contains(text(), 'found')]";
    public final String NO_RESULTS_MESSAGE_XPATH = "//span[@class='boom']";
    public final String RESET_BUTTON_XPATH = "//button[contains(text(), 'reset')]";
    public final String LOCATION_TITLE_XPATH = "//li[@class='entry-content']//span[2]";




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
    public WebElement POSITION_TITLE_WEBELEMENT;

    @FindBy(xpath = COMPANY_TITLE_XPATH)
    public WebElement COMPANY_TITLE_WEBELEMENT;

    @FindBy(xpath = NO_RESULTS_MESSAGE_XPATH)
    public WebElement NO_RESULTS_MESSAGE_WEBELEMENT;

    @FindBy(xpath = RESET_BUTTON_XPATH)
    public WebElement RESET_BUTTON_WEBELEMENT;



    public JobsPage() {
        PageFactory.initElements(webDriver,this);//Этот конструктор нужен для использования @FindBy
    }
    public void navigateToJobsPage() {
        webDriver.get(JOBS_PAGE_URL);
    }
    public void elementSearch(String searchValue,WebElement field){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(field).build().perform();
        field.clear();
        field.sendKeys(searchValue);
        actions.moveToElement(SEARCH_BUTTON_WEBELEMENT).build().perform();
        SEARCH_BUTTON_WEBELEMENT.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FOUND_SPAN_XPATH)));
        field.clear();
    }
    public boolean isSearchResultContainsProvidedText(String searchedValue, String xpath){
        searchedValue = searchedValue.toUpperCase();
        try {
            List<WebElement> searchResults = webDriver.findElements(By.xpath(xpath));
            for( WebElement item : searchResults){
                String upperCaseItem = item.getText().toUpperCase();
                if (!upperCaseItem.contains(searchedValue)) {
                    searchResults.remove(item.getText());
                }
            }
            if (searchResults.size() == 10) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> searchResults = webDriver.findElements(By.xpath(xpath));
            for( WebElement item : searchResults){
                String upperCaseItem = item.getText().toUpperCase();
                if (!upperCaseItem.contains(searchedValue)) {
                    searchResults.remove(item.getText());
                }
            }
            if (searchResults.size() == 10) {
                return true;
            }
            else {
                return false;
            }
        }

    }

    public boolean isMessageDisplayed(WebElement element){
        return element.isDisplayed();
    }
    public void resetButtonCheck() {
        POSITION_FIELD_WEBELEMENT.clear();
        LOCATION_FIELD_WEBELEMENT.clear();
        COMPANY_FIELD_WEBELEMENT.clear();
        DESCRIPTION_FIELD_WEBELEMENT.clear();
        POSITION_FIELD_WEBELEMENT.sendKeys("1");
        wait.until(ExpectedConditions.textToBePresentInElementValue(POSITION_FIELD_WEBELEMENT,"1"));
        LOCATION_FIELD_WEBELEMENT.sendKeys("1");
        wait.until(ExpectedConditions.textToBePresentInElementValue(LOCATION_FIELD_WEBELEMENT,"1"));
        COMPANY_FIELD_WEBELEMENT.sendKeys("1");
        wait.until(ExpectedConditions.textToBePresentInElementValue(POSITION_FIELD_WEBELEMENT,"1"));
        DESCRIPTION_FIELD_WEBELEMENT.sendKeys("1");
        wait.until(ExpectedConditions.textToBePresentInElementValue(POSITION_FIELD_WEBELEMENT,"1"));
        RESET_BUTTON_WEBELEMENT.click();
    }

}
