import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String Expected_Success_Message = "You are now logged in as Alexey Rogozhin.";
    String Expected_Error_Message = "Wrong password or the account is disabled, or does not exist";
    Logger logger = Logger.getLogger(LoginTest.class);

    @Test
    @Description("adaassssv")
    @Epic("Epic")
    public void TestIncorrectLogin() {
        logger.info("TestIncorrectLogin()");
        mainPage.fillIncorrectLoginAndSend();
        Assert.assertEquals(mainPage.getErrorMessage(), Expected_Error_Message,
                "Actual error message is " + "'" + mainPage.getErrorMessage() + "'");
    }

    @Test
    @Description("TestCorrectLoginTestCorrectLoginTestCorrectLogin")
    public void TestCorrectLogin() {
        logger.info("TestCorrectLogin()");
        mainPage.fillCorrectLoginAndSend();
        Assert.assertEquals(mainPage.getSuccessMessage(), Expected_Success_Message,
                "Actual success message is " + "'" + mainPage.getSuccessMessage() + "'");
    }
}
