package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGoogleSearchResultPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='gs-title']/a/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement neededSearchResult;

    CloudGoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSearchResult() {
        neededSearchResult.click();
    }

    public CloudGoogleCalculatorPage findSearchResult() {
        clickSearchResult();
        return new CloudGoogleCalculatorPage(driver);
    }
}
