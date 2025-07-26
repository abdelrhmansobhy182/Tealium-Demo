package frontend.tests;
import frontend.utilities.ElementUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

@Listeners(reports.ExtentTestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected ElementUtilities elementUtilities;
    protected Dotenv dotenv = Dotenv.load();

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(dotenv.get("WEBSITE_URL"));

        elementUtilities = new ElementUtilities(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
