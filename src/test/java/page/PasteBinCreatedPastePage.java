package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinCreatedPastePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement nameTitle;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement pasteText;

    @FindBy(xpath = "//span[@class='kw2']")
    private WebElement bashTextColor;

    @FindBy(xpath = "//div[@class='expire']")
    private WebElement experationTime;

    public PasteBinCreatedPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPasteText() {
        return pasteText.getText();
    }

    public String getPasteName() {
        return nameTitle.getText();
    }

    public String getExperationTime() {
        return experationTime.getText();
    }

    public String getBashTextColor() {
        return bashTextColor.getCssValue("color");
    }


}
