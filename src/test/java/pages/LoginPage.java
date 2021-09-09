package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.implementation.WebPage;

public class LoginPage extends WebPage {

    @FindBy(css = "button[class='btn btn-primary flex-fill json-link']")
    private WebElement accept;
    @FindBy(css = "[name='emailAddress']")
    private WebElement insertEmail;
    @FindBy(css = "[name='password']")
    private WebElement insertPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        accept.click();
    }

    public void login(String email, String password) {
        insertEmail.sendKeys(email);
        insertPassword.sendKeys(password);
        insertPassword.sendKeys(Keys.ENTER);
    }

}
