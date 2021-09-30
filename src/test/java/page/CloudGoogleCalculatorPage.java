package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaitCondition;

public class CloudGoogleCalculatorPage {

    WebDriver driver;

    @FindBy(xpath = "//devsite-iframe/iframe[contains(@src,'calculator')]")
    private WebElement externalCalculatorFrame;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement internalCalculatorFrame;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_61']")
    private WebElement seriesDropDown;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement requiredSeries;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_62']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement requiredMachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGpuCheckBox;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_397']")
    private WebElement numberOfGPUDropDown;

    @FindBy(xpath = "//md-option[@id='select_option_404']")
    private WebElement requiredNumberOfGPU;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_398']")
    private WebElement typeOfGPUDropDown;

    @FindBy(xpath = "//md-option[@id='select_option_411']")
    private WebElement requiredTypeOfGPU;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_359']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//md-option[@id='select_option_386']")
    private WebElement requiredSSD;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_63']")
    private WebElement dataCenterLocationDropDown;

    @FindBy(xpath = "//md-option[@id='select_option_207']")
    private WebElement requiredDataCenterLocation;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_64']")
    private WebElement commitedUsageDropDown;

    @FindBy(xpath = "//md-option[@id='select_option_99']")
    private WebElement requiredCommitedUsage;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']/div/button[@aria-label='Add to Estimate']")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[2]/div")
    private WebElement checkVMclass;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[3]/div")
    private WebElement checkInstanceType;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[4]/div")
    private WebElement checkRegion;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[5]/div")
    private WebElement checkSSD;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[6]/div")
    private WebElement checkCommitmentTerm;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[7]/div/b")
    private WebElement checkCost;

    public CloudGoogleCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String setCheckVMclass() {
        return checkVMclass.getText();
    }

    public String setCheckSSD() {
        return checkSSD.getText();
    }

    public String setCheckInstanceType() {
        return checkInstanceType.getText();
    }

    public String setCheckRegion() {
        return checkRegion.getText();
    }

    public String setCheckCommitmentTerm() {
        return checkCommitmentTerm.getText();
    }

    public String setCheckCost() {
        return checkCost.getText();
    }

    public void switchToCalculatorFrame() {
        driver.switchTo().frame(externalCalculatorFrame);
        driver.switchTo().frame(internalCalculatorFrame);
    }

    public void fillNumberOfInstances(String inputInstances) {
        numberOfInstances.sendKeys(inputInstances);
    }


    public void chooseSeries() {
        seriesDropDown.click();
        WaitCondition waitCondition = new WaitCondition(driver);
        waitCondition.waitForVisibilityOfElementLocatedBy(requiredSeries);
        requiredSeries.click();
    }


    public void chooseMachineType() {
        machineTypeDropDown.click();
        WaitCondition waitCondition = new WaitCondition(driver);
        waitCondition.waitForVisibilityOfElementLocatedBy(requiredMachineType);
        requiredMachineType.click();
    }

    public void addGPU() {
        WaitCondition waitCondition = new WaitCondition(driver);
        addGpuCheckBox.click();
        numberOfGPUDropDown.click();
        waitCondition.waitForVisibilityOfElementLocatedBy(requiredNumberOfGPU);
        requiredNumberOfGPU.click();
        typeOfGPUDropDown.click();
        waitCondition.waitForVisibilityOfElementLocatedBy(requiredTypeOfGPU);
        requiredTypeOfGPU.click();
        localSSDDropDown.click();
        waitCondition.waitForVisibilityOfElementLocatedBy(requiredSSD);
        requiredSSD.click();
        dataCenterLocationDropDown.click();
        waitCondition.waitForVisibilityOfElementLocatedBy(requiredDataCenterLocation);
        requiredDataCenterLocation.click();
        commitedUsageDropDown.click();
        waitCondition.waitForVisibilityOfElementLocatedBy(requiredCommitedUsage);
        requiredCommitedUsage.click();
    }

    public void estimate() {
        addToEstimateButton.click();
    }

}
