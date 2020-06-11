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
        // Check page window
        eyes.checkWindow();
    }

    public void navigateToPage(String url, String app, String testName) {
        // Navigate to page
        driver.get(url);
        eyes.open(driver, app, testName, new RectangleSize(800, 600));
    }

    public void filterResultsAndCheckProductRegion() {
        filterResults();
        // Check product grid
        eyes.checkRegion(fashionAppPageObject.productGrid);
    }

    public void filterResults() {
        // For tablets and mobile click on icon filter
        if (getWindowWidth() != 1200) {
            wait.until(visibilityOf(fashionAppPageObject.iconFilterResults));
            fashionAppPageObject.iconFilterResults.click();
        }

        // Choose filter color black
        wait.until(visibilityOf(fashionAppPageObject.checkboxColorBlack));
        fashionAppPageObject.checkboxColorBlack.click();

        // Click Filter button
        wait.until(elementToBeClickable(fashionAppPageObject.buttonFilter));
        fashionAppPageObject.buttonFilter.click();
    }

    public void openFirstItemFromResultsAndCheckWindow() {
        // Check product is not empty and get url for first item
        wait.until(visibilityOf(fashionAppPageObject.productGrid));
        Assert.assertFalse(fashionAppPageObject.productItemList.isEmpty());
        String url = fashionAppPageObject.getUrlForFirstItemFromResults();

        // Click on first item from list
        fashionAppPageObject.clickFirstItemFromResults();
        wait.until(urlToBe(url));

        // Check window
        eyes.checkWindow();
    }

    private int getWindowWidth() {
        return driver.manage().window().getSize().width;
    }
}
