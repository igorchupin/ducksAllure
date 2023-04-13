package pageOblects;

import com.codeborne.selenide.Condition;
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

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillIncorrectLoginAndSend() {
        $(Email).shouldBe(Condition.exist).sendKeys(Incorrect_Email);
        $(Password).shouldBe(Condition.exist).sendKeys(Incorrect_Password);
        $(Button_Login).shouldBe(Condition.exist).click();
    }

    public void fillCorrectLoginAndSend() {
        $(Email).shouldBe(Condition.exist).sendKeys(Correct_Email);
        $(Password).shouldBe(Condition.exist).sendKeys(Correct_Password);
        $(Button_Login).shouldBe(Condition.exist).click();
    }

    public String getErrorMessage() {
        return $(Error_Message).shouldBe(Condition.visible).getText();
    }

    public String getSuccessMessage() {
        return $(Success_Message).shouldBe(Condition.visible).getText();
    }
}