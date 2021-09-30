package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.CloudGoogleCalculatorPage;
import page.CloudGooglePage;
import page.CloudGoogleSearchResultPage;
import utility.DriverSet;

public class CalculatorEstimationTest {

    WebDriver driver;
    private static final String URL = "https://cloud.google.com/";
    private static final String searchText = "Google Cloud Platform Pricing Calculator";
    private static final String vmClass = "VM class: regular";
    private static final String instanceType = "Instance type: n1-standard-8";
    private static final String region = "Region: Frankfurt";
    private static final String ssd = "Total available local SSD space 2x375 GiB";
    private static final String commitmentTerm = "Commitment term: 1 Year";
    private static final String finalPrice = "Estimated Component Cost: USD 1,082.77 per 1 month";

    @BeforeMethod
    public void setupBrowser() {
        driver = DriverSet.getDriver();
        driver.get(URL);
    }

    @Test
    public void HurtMePlantyTest() {
        CloudGooglePage cloudGooglePage = new CloudGooglePage(driver);
        CloudGoogleSearchResultPage googleSearchResultPage = cloudGooglePage.searchInGoogleCloud(searchText);
        CloudGoogleCalculatorPage googleCalculatorPage = googleSearchResultPage.findSearchResult();
        googleCalculatorPage.switchToCalculatorFrame();
        googleCalculatorPage.fillNumberOfInstances("4");
        googleCalculatorPage.chooseSeries();
        googleCalculatorPage.chooseMachineType();
        googleCalculatorPage.addGPU();
        googleCalculatorPage.estimate();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(googleCalculatorPage.setCheckVMclass().equals(vmClass));
        softAssert.assertTrue(googleCalculatorPage.setCheckInstanceType().equals(instanceType));
        softAssert.assertTrue(googleCalculatorPage.setCheckRegion().equals(region));
        softAssert.assertTrue(googleCalculatorPage.setCheckCommitmentTerm().equals(commitmentTerm));
        softAssert.assertTrue(googleCalculatorPage.setCheckSSD().equals(ssd));
        softAssert.assertTrue(googleCalculatorPage.setCheckCost().equals(finalPrice));
        softAssert.assertAll();
    }
}
