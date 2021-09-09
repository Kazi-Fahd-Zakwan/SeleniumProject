package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.implementation.WebPage;

public class IdeaPage extends WebPage {

    @FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/article[1]/div[5]/section[1]/div[1]/div[1]/strong[1]")
    private WebElement conditionCheckForVote;
    @FindBy(css = "a[class='vote-up json-link']")
    private WebElement upVote;
    @FindBy(css = "a[class='vote-up json-link idea-voted']")
    private WebElement upVotedAlready;
    @FindBy(css = "a[class='vote-down json-link']")
    private WebElement downVote;
    @FindBy(css = "a[class='vote-down json-link-voted']")
    private WebElement downVotedAlready;
    @FindBy(css = "[name='text']")
    private WebElement comment;
    @FindBy(css = "input[class='btn btn-lg btn-primary disabled-when-loading']")
    private WebElement commentSubmitButton;

    public IdeaPage(WebDriver driver) {
        super(driver);
    }

    public void postVote() throws InterruptedException {

        String typeValue = conditionCheckForVote.getText();
        System.out.println(typeValue);

        if (typeValue.equals("-1")) {
            upVote.click();
            Thread.sleep (1000);
        }
        else if(typeValue.equals("1")) {
            downVote.click();
            Thread.sleep (1000);
            upVote.click();
            Thread.sleep (1000);
        }
        else {
            upVote.click();
            Thread.sleep (1000);
        }
    }

    public void postComment(String commentValue) {
        comment.sendKeys(commentValue);
        commentSubmitButton.submit();
    }
}
