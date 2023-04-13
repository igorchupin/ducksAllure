import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    Logger logger = Logger.getLogger(Listener.class);
    @Override
    public void onTestStart(ITestResult result) {
       logger.info("Test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       logger.info("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult tr){
        byte[] srcFile =  ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }




    @Override
    public void onStart(ITestContext context) {
      logger.info("On Start");
    }

    @Override
    public void onFinish(ITestContext context) {
       logger.info("On finish");
    }

}
