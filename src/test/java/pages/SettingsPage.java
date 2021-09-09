package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.implementation.WebPage;

public class SettingsPage extends WebPage {

    @FindBy(linkText = "Engagement")
    private WebElement engagementButton;
    @FindBy(linkText = "Campaigns")
    private WebElement campaignButton;
    @FindBy(linkText = "Add New Campaign")
    private WebElement addNewCampaignButton;

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void goToCampaignSettings() throws InterruptedException {
        engagementButton.click();
        Thread.sleep (500);
        campaignButton.click();
    }

    public void addNewCampaign() {
        addNewCampaignButton.click();
    }
}
