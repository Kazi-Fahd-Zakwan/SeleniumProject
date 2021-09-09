package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.implementation.WebPage;

public class IdeaSubmitPage extends WebPage {

    @FindBy(css = "span[class='select2-selection__rendered']")
    private WebElement chooseCampaignButton;
    @FindBy(css = "li[class='select2-results__option']")
    private WebElement campaignName;
    @FindBy(css = "[name='title']")
    private WebElement title;
    @FindBy(css = "[name='text']")
    private WebElement description;
    @FindBy(css = "[name='save']")
    private WebElement submitButton;

    public IdeaSubmitPage(WebDriver driver) {
        super(driver);
    }

    public void chooseCampaign() throws InterruptedException {
        chooseCampaignButton.click();
        Thread.sleep (500);
        campaignName.click();
        Thread.sleep (500);
    }

    public void insertTitle(String titleValue) {
        title.sendKeys(titleValue);
    }

    public void insertDescription(String descriptionValue) {
        description.sendKeys(descriptionValue);
    }

    public void submitIdea() {
        submitButton.sendKeys(Keys.ENTER);
    }

}
