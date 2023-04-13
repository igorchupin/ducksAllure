package pageOblects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksPage extends BasePage {
    private static final By Button_Rubber_Ducks = By.xpath("//a[text()='Rubber Ducks']");
    private static final By Button_Date = By.xpath("//a[text()='Date']");
    private static final By Button_Name = By.xpath("//a[text()='Name']");
    private static final By Ducks = By.xpath("//li[@class='product column shadow hover-light']");
    private static final By price_first_duck_By_Date = By.xpath("//a[@title='Yellow Duck']/div//strong");
    private static final By price_first_duck_By_Name = By.xpath("//a[@title='Blue Duck']/div/span");

    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public void verifyLoadDuck(){
        $(Ducks).shouldBe(Condition.visible);
    }
    public void clickRubberDucks() {
        $(Button_Rubber_Ducks).shouldBe(Condition.exist).click();
        verifyLoadDuck();
    }

    public void clickDate() {
        $(Button_Date).shouldBe(Condition.exist).click();
        verifyLoadDuck();
    }

    public void clickName() {
        $(Button_Name).shouldBe(Condition.exist).click();
        verifyLoadDuck();
    }

    public int getQuantityDucks() {
        ElementsCollection listElements = $$(Ducks);
        return listElements.size();
    }

    public String getPriceByName() {
        return $(price_first_duck_By_Name).shouldBe(Condition.exist).getText();
    }

    public String getPriceByDate() {
        return $(price_first_duck_By_Date).shouldBe(Condition.exist).getText();
    }
}