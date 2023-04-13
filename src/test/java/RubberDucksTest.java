import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDucksTest extends BaseTest {

    int expected_Quantity_Ducks = 5;
    String Expected_price_by_Date = "$18";
    String Expected_price_by_Name = "$20";

    @Test
    public void quantityDucksTest() {
        rubberDucksPage.clickRubberDucks();
        Assert.assertEquals(rubberDucksPage.getQuantityDucks(), expected_Quantity_Ducks,
                "Actual quantity ducks = " + rubberDucksPage.getQuantityDucks());
    }

    @Test
    public void sortByDateTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickDate();
        Assert.assertEquals(rubberDucksPage.getPriceByDate(), Expected_price_by_Date,
                "Actual first's duck price sorted by Date = " + rubberDucksPage.getPriceByDate());
    }

    @Test
    public void sortByNameTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickName();
        Assert.assertEquals(rubberDucksPage.getPriceByName(), Expected_price_by_Name,
                "Actual first's duck price sorted by Name = " + rubberDucksPage.getPriceByName());
    }
}

