package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.implementation.WebPage;

public class CreateCampaignSettingsPage extends WebPage {

    @FindBy(css = "[name='name']")
    private WebElement nameField;
    @FindBy(css = "button[class='btn btn-primary btn-sm dropdown-toggle']")
    private WebElement dropDownButton;
    @FindBy(css = "button[class='dropdown-item']")
    private WebElement saveAndContinueButton;
    @FindBy(linkText = "Schedule")
    private WebElement scheduleButton;
    @FindBy(css = "button[class='btn btn-link btn-sm font-weight-bold']")
    private WebElement launchButton;


    public CreateCampaignSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void fillUpBasicInfoAndSave(String name) {
        nameField.sendKeys(name);
        dropDownButton.click();
        saveAndContinueButton.click();
    }

    public void goToScheduleAndLaunch() throws InterruptedException {
        scheduleButton.click();
        Thread.sleep (500);
        launchButton.click();
    }

}
