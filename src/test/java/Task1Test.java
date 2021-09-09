import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;

// 1. Create a campaign

public class Task1Test {

    //Declaring all the variables
    private static WebDriver driver;
    private static int value;
    private static String title;
    private static String emailAddress;
    private static String password;

    @BeforeAll
    public static void setUpDriver() {
        //Setting up the WebDriver
        WebDriverManager.chromedriver().setup();

        //For this test, we will be using Google Chrome browser
        driver = new ChromeDriver();

        //Maximizing the browser window
        driver.manage().window().maximize();

        //Generating a random integer value
        value = (int) (Math.random() * 10000);

        //Converting the integer into string and adding another string to generate a unique title
        title = "Ideascale Rocks " + String.valueOf(value);

        //User credential email address
        emailAddress = "trialqa.ideascale@gmail.com";

        //User credential password
        password = "a@123456#";
    }

    @Test
    public void Task1Testing() throws InterruptedException {
        //Browser URL for the test
        driver.get("https://trialqa.ideascale.com");

        //Object creation of all the necessary classes
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        SettingsPage settingsPage = new SettingsPage(driver);
        CreateCampaignSettingsPage createCampaignSettingsPage = new CreateCampaignSettingsPage(driver);

        loginPage.acceptCookies();
        Thread.sleep (1000);

        loginPage.login(emailAddress, password);
        Thread.sleep (1000);

        homePage.goToCommunitySettings();
        Thread.sleep (1000);

        //Window handlers
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

        //Switching to the next window
        driver.switchTo().window(tabs2.get(1));

        settingsPage.goToCampaignSettings();
        Thread.sleep (500);

        settingsPage.addNewCampaign();
        Thread.sleep (1000);

        createCampaignSettingsPage.fillUpBasicInfoAndSave(title);
        Thread.sleep (500);

        createCampaignSettingsPage.goToScheduleAndLaunch();
        Thread.sleep (2000);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.quit();
    }
}
