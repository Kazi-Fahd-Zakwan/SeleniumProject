import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.IdeaPage;
import pages.IdeaSubmitPage;
import pages.LoginPage;

// 2. Idea submission under this campaign

public class Task2Test {

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
    public void Task2Testing() throws InterruptedException {
        //Browser URL for the test
        driver.get("https://trialqa.ideascale.com");

        //Object creation of all the necessary classes
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        IdeaSubmitPage ideaSubmitPage = new IdeaSubmitPage(driver);
        IdeaPage ideaPage = new IdeaPage(driver);

        loginPage.acceptCookies();
        Thread.sleep (1000);

        loginPage.login(emailAddress, password);
        Thread.sleep (1000);

        homePage.goToIdeaSubmitPage();
        Thread.sleep (1000);

        ideaSubmitPage.chooseCampaign();
        Thread.sleep (500);

        ideaSubmitPage.insertTitle(title);
        Thread.sleep (500);

        ideaSubmitPage.insertDescription("Ideascale Rocks");
        Thread.sleep (1000);

        ideaSubmitPage.submitIdea();
        Thread.sleep (1000);

        ideaPage.postVote();
        Thread.sleep (1000);

        ideaPage.postComment("Ideascale Rocks");
        Thread.sleep (3000);
    }

    @AfterAll
    public static void tearDownDriver() {
        driver.close();
    }
}
