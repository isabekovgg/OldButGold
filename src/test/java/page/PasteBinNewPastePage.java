package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinNewPastePage {

    WebDriver driver;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement pasteTextArea;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement experationDownlist;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement experation10Minutes;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement nameTextArea;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createPasteButton;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement syntaxHighLightingDownList;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashHighLighting;

    public PasteBinNewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public PasteBinCreatedPastePage postNewCustomPaste(String text, String name) {
        pasteTextArea.sendKeys(text);
        experationDownlist.click();
        experation10Minutes.click();
        nameTextArea.sendKeys(name);
        createPasteButton.click();
        return new PasteBinCreatedPastePage(driver);
    }

    public PasteBinCreatedPastePage postNewHighLightedCustomPaste(String text, String name) {
        pasteTextArea.sendKeys(text);
        syntaxHighLightingDownList.click();
        bashHighLighting.click();
        experationDownlist.click();
        experation10Minutes.click();
        nameTextArea.sendKeys(name);
        createPasteButton.click();
        return new PasteBinCreatedPastePage(driver);
    }
}
