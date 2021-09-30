package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.PasteBinCreatedPastePage;
import page.PasteBinNewPastePage;
import utility.DriverSet;

public class PasteCreationAndPropertiesTest {

    WebDriver driver;
    private static final String text = "Hello From WebDriver";
    private static final String name = "helloweb";
    private static final String URL = "https://pastebin.com/";
    private static final String experation = "10 MIN";
    private static final String color = "rgba(194, 12, 185, 1)";

    private static final String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String title = "how to gain dominance among developers";

    @BeforeMethod
    public void setupBrowser() {
        driver = DriverSet.getDriver();
        driver.get(URL);
    }

    @Test
    public void iCanWinTest() {
        PasteBinNewPastePage newPastePage = new PasteBinNewPastePage(driver);
        PasteBinCreatedPastePage createdPastePage = newPastePage.postNewCustomPaste(text, name);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(createdPastePage.getPasteText().equals(text));
        softAssert.assertTrue(createdPastePage.getPasteName().equals(name));
        softAssert.assertTrue(createdPastePage.getExperationTime().equals(experation));
        softAssert.assertAll();
        driver.close();
    }

    @Test
    public void bringItOnTest() {
        PasteBinNewPastePage newPastePage = new PasteBinNewPastePage(driver);
        PasteBinCreatedPastePage createdPastePage = newPastePage.postNewHighLightedCustomPaste(code, title);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(createdPastePage.getPasteText().equals(code));
        softAssert.assertTrue(createdPastePage.getPasteName().equals(title));
        softAssert.assertTrue(createdPastePage.getExperationTime().equals(experation));
        softAssert.assertTrue(createdPastePage.getBashTextColor().equals(color));
        softAssert.assertAll();
    }

}
