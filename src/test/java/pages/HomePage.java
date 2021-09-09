package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.implementation.WebPage;

public class HomePage extends WebPage {

    @FindBy(css = "a[class='new-idea-button hidden-sm-max btn btn-danger btn-lg']")
    private WebElement submitNewIdeaButton;
    @FindBy(css = "svg[class='is-svg-icon topbar-icon arrow-icon']")
    private WebElement trialQaDropDownButton;
    @FindBy(css = "a[class='dropdown-item']")
    private WebElement communitySettingsButton;
    @FindBy(css = "a[class='hidden-sm-max']")
    private WebElement homePageButton;
    @FindBy(css = "a[class='classic-link']")
    private WebElement ideaDetailsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToIdeaSubmitPage() {
        submitNewIdeaButton.click();
    }

    public void goToCommunitySettings() throws InterruptedException {
        trialQaDropDownButton.click();
        Thread.sleep (500);
        communitySettingsButton.click();
    }

    public void returnToHomePage() {
        homePageButton.click();
    }

    public void goToIdeaDetailsPage() {
        ideaDetailsButton.click();
    }

}
