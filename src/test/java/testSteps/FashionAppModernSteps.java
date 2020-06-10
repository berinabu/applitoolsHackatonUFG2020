package testSteps;

import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObject.FashionAppPageObject;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class FashionAppModernSteps extends BaseModernSteps {
    private FashionAppPageObject fashionAppPageObject = PageFactory.initElements(getDriver(), FashionAppPageObject.class);

    public void navigateToPageAndCheckWindow(String url, String app, String testName) {
        navigateToPage(url, app, testName);
        eyes.checkWindow();
    }

    public void navigateToPage(String url, String app, String testName) {
        driver.get(url);
        eyes.open(driver, app, testName, new RectangleSize(800, 600));
    }

    public void filterResultsAndCheckProductRegion() {
        filterResults();
        eyes.checkRegion(fashionAppPageObject.productGrid);
    }

    public void filterResults() {
        if (getWindowWidth() != 1200) {
            wait.until(visibilityOf(fashionAppPageObject.iconFilterResults));
            fashionAppPageObject.iconFilterResults.click();
        }

        wait.until(visibilityOf(fashionAppPageObject.checkboxColorBlack));
        fashionAppPageObject.checkboxColorBlack.click();

        wait.until(elementToBeClickable(fashionAppPageObject.buttonFilter));
        fashionAppPageObject.buttonFilter.click();
    }

    public void openFirstItemFromResultsAndCheckWindow() {
        wait.until(visibilityOf(fashionAppPageObject.productGrid));
        Assert.assertFalse(fashionAppPageObject.productItemList.isEmpty());
        String url = fashionAppPageObject.getUrlForFirstItemFromResults();

        fashionAppPageObject.clickFirstItemFromResults();
        wait.until(urlToBe(url));
        eyes.checkWindow();
    }

    private int getWindowWidth() {
        return driver.manage().window().getSize().width;
    }
}
