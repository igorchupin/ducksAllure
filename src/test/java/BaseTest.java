import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageOblects.MainPage;
import pageOblects.RubberDucksPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

//@Listeners (Listener.class)

public class BaseTest {
    protected String base_URL = "https://litecart.stqa.ru/en/";
    protected WebDriver webDriver;
    protected MainPage mainPage;
    protected RubberDucksPage rubberDucksPage;
    Logger logger = Logger.getLogger(BaseTest.class);
/*
    @BeforeClass
    public void beforeClass() {
        mainPage = new MainPage(webDriver);
        rubberDucksPage = new RubberDucksPage(webDriver);
    }
*/
    @BeforeClass
    public void beforeTest() {
        logger.info("Before test started");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        WebDriverRunner.setWebDriver(webDriver);
        mainPage = new MainPage(webDriver);
        rubberDucksPage = new RubberDucksPage(webDriver);
        logger.info("Before test ended");
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Before method deleting cookies");
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        logger.info("Openning " + base_URL);
        open(base_URL);
    }

    @AfterClass
    public void afterTest() {
        logger.info("Tests ended");
        webDriver.quit();
    }

}