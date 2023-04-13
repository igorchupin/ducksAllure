package pageOblects;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {

    private static final By Email = By.xpath("//input[@name='email']");
    private static final By Password = By.xpath("//input[@name='password']");
    private static final By Button_Login = By.xpath("//button[@value='Login']");
    private static final By Error_Message = By.xpath("//div[@class='notice errors']");
    private static final By Success_Message = By.xpath("//div[@class='notice success']");
    String Correct_Email = "anex92@seznam.cz";
    String Incorrect_Email = "babex@seznam.cz";
    String Correct_Password = "777794362";
    String Incorrect_Password = "123";
    Logger logger = Logger.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectLoginAndSend() {
        logger.info("start filling with " + Incorrect_Email);
        $(Email).shouldBe(Condition.exist).sendKeys(Incorrect_Email);
        logger.info("start filling with " + Incorrect_Password);
        $(Password).shouldBe(Condition.exist).sendKeys(Incorrect_Password);
        logger.info("start clicking Button login");
        $(Button_Login).shouldBe(Condition.exist).click();
        logger.info("Method ends");
    }

    public void fillCorrectLoginAndSend() {
        logger.info("start filling with " + Correct_Email);
        $(Email).shouldBe(Condition.exist).sendKeys(Correct_Email);
        logger.info("start filling with " + Correct_Password);
        $(Password).shouldBe(Condition.exist).sendKeys(Correct_Password);
        logger.info("start clicking Button login");
        $(Button_Login).shouldBe(Condition.exist).click();
        logger.info("Method ends");
    }

    public String getErrorMessage() {
        logger.info("message: " + $(Error_Message).shouldBe(Condition.visible).getText());
        return $(Error_Message).shouldBe(Condition.visible).getText();
    }

    public String getSuccessMessage() {
        logger.info("message: " + $(Success_Message).shouldBe(Condition.visible).getText());
        return $(Success_Message).shouldBe(Condition.visible).getText();
    }
}