package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGooglePage {

    WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBar;


    public CloudGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSearch() {
        searchBar.click();
    }

    public void setText(String text) {
        searchBar.sendKeys(text);
    }

    public void pressSearch() {
        searchBar.submit();
    }

    public CloudGoogleSearchResultPage searchInGoogleCloud(String text) {
        clickSearch();
        setText(text);
        pressSearch();
        return new CloudGoogleSearchResultPage(driver);
    }
}
