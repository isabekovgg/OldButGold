package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCondition {

    private static final int DELAY = 5;

    private WebDriverWait webDriverWait;

    public WaitCondition(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, DELAY);
    }

    public WebElement waitForVisibilityOfElementLocatedBy(WebElement locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(locator));
    }
}