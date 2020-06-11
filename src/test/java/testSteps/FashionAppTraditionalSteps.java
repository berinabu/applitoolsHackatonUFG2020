package testSteps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import pageObject.FashionAppPageObject;
import pageObject.ProductDetailsPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertFalse;

public class FashionAppTraditionalSteps extends BasePageSteps {
    private FashionAppPageObject fashionAppPageObject = PageFactory.initElements(getDriver(), FashionAppPageObject.class);
    private ProductDetailsPageObject productDetailsPageObject = PageFactory.initElements(getDriver(), ProductDetailsPageObject.class);

    @Step("Set screen size")
    public void setWindowDimension(Dimension dimension) {
        // Set window dimension
        driver.manage().window().setSize(dimension);
    }

    @Step("Navigate to Applitools Fashion App")
    public void navigateToFashionApp(String uri) {
        // Navigate to page and validate title
        driver.get(uri);
        wait.until(ExpectedConditions.titleIs("Applitools UltraFastGrid | Cross Browser Testing Demo App"));
    }

    @Step("Validate visible and hidden elements on Applitools Fashion App")
    public void validateElementsOnFashionApp() {
        // Validate visible and hidden elements on page including different devices
        switch (seleniumCommon.getDeviceName()) {
            case "Laptop":
            default:
                checkElementsVisibility(fashionAppPageObject.getLaptopPageElements(), 1);
                checkHiddenElements(fashionAppPageObject.getLaptopPageHiddenElements(), 1);
                break;
            case "Tablet":
                checkElementsVisibility(fashionAppPageObject.getTabletPageElements(), 1);
                checkHiddenElements(fashionAppPageObject.getTabletPageHiddenElements(), 1);
                break;
            case "Mobile":
                checkElementsVisibility(fashionAppPageObject.getMobilePageElements(), 1);
                checkHiddenElements(fashionAppPageObject.getMobilePageHiddenElements(), 1);
                break;
        }
    }

    @Step("Sort results by filter color Black and validate results")
    public void setFilterBlackColorAndValidateResults() {
        SoftAssert softAssert = new SoftAssert();

        switch (seleniumCommon.getDeviceName()) {
            case "Tablet":
            case "Mobile":
                softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Element is displayed",
                        fashionAppPageObject.iconFilterResults.getAttribute("id"), fashionAppPageObject.iconFilterResults.isDisplayed()));
                softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Element is enabled",
                        fashionAppPageObject.iconFilterResults.getAttribute("id"), fashionAppPageObject.iconFilterResults.isEnabled()));

                // Click on icon filter
                fashionAppPageObject.clickIconFilterResults();
                break;
        }
        wait.until(ExpectedConditions.visibilityOf(fashionAppPageObject.checkboxColorBlack));
        softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Element is displayed",
                fashionAppPageObject.checkboxColorBlack.getAttribute("id"), fashionAppPageObject.checkboxColorBlack.isDisplayed()));
        softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Element is enabled",
                fashionAppPageObject.checkboxColorBlack.getAttribute("id"), fashionAppPageObject.checkboxColorBlack.isEnabled()));

        // Click filter color Black
        fashionAppPageObject.clickCheckboxColorBlack();
        wait.until(ExpectedConditions.elementToBeClickable(fashionAppPageObject.buttonFilter));

        softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Element is displayed",
                fashionAppPageObject.buttonFilter.getAttribute("id"), fashionAppPageObject.buttonFilter.isDisplayed()));
        softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Element is enabled",
                fashionAppPageObject.buttonFilter.getAttribute("id"), fashionAppPageObject.buttonFilter.isEnabled()));

        // Click button Filter
        fashionAppPageObject.clickButtonFilter();

        softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Element is displayed",
                fashionAppPageObject.colorBlackFilterCounter.getAttribute("id"), fashionAppPageObject.colorBlackFilterCounter.isDisplayed()));
        fashionAppPageObject.productItemList.forEach(item -> softAssert.assertTrue(seleniumCommon.hackathonReporter(2,
                "Element is displayed", item.getAttribute("id"), item.isDisplayed())));

        // Validate result list
        softAssert.assertTrue(seleniumCommon.hackathonReporter(2, "Result list should have had same number " +
                        "of items as filter counter", fashionAppPageObject.colorBlackFilterCounter.getAttribute("id"),
                fashionAppPageObject.getProductItemListSize() == fashionAppPageObject.getColorBlackFilterCounter()));

        softAssert.assertAll();
    }

    @Step("Sort results by filter color Black and validate results")
    public void setFilterBlackColor() {
        switch (seleniumCommon.getDeviceName()) {
            case "Tablet":
            case "Mobile":
                wait.until(ExpectedConditions.visibilityOf(fashionAppPageObject.iconFilterResults));

                // Click on icon filter
                fashionAppPageObject.clickIconFilterResults();
                break;
        }
        wait.until(ExpectedConditions.visibilityOf(fashionAppPageObject.checkboxColorBlack));

        // Click filter color Black
        fashionAppPageObject.clickCheckboxColorBlack();
        wait.until(ExpectedConditions.elementToBeClickable(fashionAppPageObject.buttonFilter));

        // Click button Filter
        fashionAppPageObject.clickButtonFilter();

        // Validate result list is not empty
        assertFalse(fashionAppPageObject.productItemList.isEmpty());
    }

    public void selectFirstItemFromResultsAndValidateProductPage() {
        String productUrl = fashionAppPageObject.getUrlForFirstItemFromResults();

        // Click on first item from list and validate redirection
        fashionAppPageObject.clickFirstItemFromResults();
        wait.until(ExpectedConditions.urlToBe(productUrl));

        // Validate product details
        switch (seleniumCommon.getDeviceName()) {
            case "Laptop":
            default:
                checkElementsVisibility(productDetailsPageObject.getLaptopProductPageElements(), 3);
                break;
            case "Tablet":
                checkElementsVisibility(productDetailsPageObject.getTabletProductPageElements(), 3);
                checkHiddenElements(productDetailsPageObject.getTabletProductPageHiddenElements(), 3);
                break;
            case "Mobile":
                checkElementsVisibility(productDetailsPageObject.getMobileProductPageElements(), 3);
                checkHiddenElements(productDetailsPageObject.getMobileProductPageHiddenElements(), 3);
                break;
        }
    }

    private void checkElementsVisibility(Set<By> elements, int taskNumber) {
        SoftAssert softAssert = new SoftAssert();

        // Assert visible element on page
        getListOfElementsBySelector(elements).forEach(pageElement -> softAssert.assertTrue(seleniumCommon.hackathonReporter(
                taskNumber, "Element is displayed", pageElement.getAttribute("id"), pageElement.isDisplayed())));
        softAssert.assertAll();
    }

    private void checkHiddenElements(Set<By> elements, int taskNumber) {
        SoftAssert softAssert = new SoftAssert();

        // Assert hidden element on page
        getListOfElementsBySelector(elements).forEach(pageElement -> softAssert.assertTrue(seleniumCommon.hackathonReporter(
                taskNumber, "Element is hidden", pageElement.getAttribute("id"), !pageElement.isDisplayed())));
        softAssert.assertAll();
    }

    public void checkElementAttributes() {
        SoftAssert softAssert = new SoftAssert();

        // Validate size and current price
        softAssert.assertTrue(seleniumCommon.hackathonReporter(
                3, "Element text is same", productDetailsPageObject.currentShoeSize.getAttribute("id"),
                productDetailsPageObject.getCurrentShoeSize().equals("Small (S)")));
        softAssert.assertTrue(seleniumCommon.hackathonReporter(
                3, "Element text is same", productDetailsPageObject.newShoePrice.getAttribute("id"),
                productDetailsPageObject.getNewPrice().equals("$33.00")));

        // Validate elements position
        switch (seleniumCommon.getDeviceName()) {
            case "Tablet":
                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.iconCart.getAttribute("id"),
                        productDetailsPageObject.getIconCartPosition().equals("(727, 51)")));

                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.iconAccess.getAttribute("id"),
                        productDetailsPageObject.getIconAccessPosition().equals("(635, 51)")));

                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.iconWishlist.getAttribute("id"),
                        productDetailsPageObject.getIconWishlistPosition().equals("(681, 51)")));

                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.ratingCounter.getAttribute("id"),
                        productDetailsPageObject.getRatingCounterPosition().equals("(105, 642)")));

                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.buttonAddToCart.getAttribute("id"),
                        productDetailsPageObject.getButtonAddToCartPosition().equals("(399, 884)")));
                break;
            case "Mobile":
                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.iconCart.getAttribute("id"),
                        productDetailsPageObject.getIconCartPosition().equals("(459, 61)")));

                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.iconAccess.getAttribute("id"),
                        productDetailsPageObject.getIconAccessPosition().equals("(367, 61)")));

                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.iconWishlist.getAttribute("id"),
                        productDetailsPageObject.getIconWishlistPosition().equals("(413, 61)")));

                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element location is same", productDetailsPageObject.ratingCounter.getAttribute("id"),
                        productDetailsPageObject.getRatingCounterPosition().equals("(105, 600)")));

                // Validate element color attribute
                softAssert.assertTrue(seleniumCommon.hackathonReporter(
                        3, "Element color is same", productDetailsPageObject.oldShoePrice.getAttribute("id"),
                        productDetailsPageObject.getOldPriceColor().equals("#999999")));
                break;
        }
        softAssert.assertAll();
    }

    private List<WebElement> getListOfElementsBySelector(Set<By> elements) {
        List<WebElement> webElementsList = new ArrayList<>();

        // Get list of elements by provided Set<By>
        elements.forEach(byItem -> {
            if (byItem.toString().contains("main-menu") || byItem.toString().contains("sidebar_filters") || byItem.toString().contains("grid_item"))
                webElementsList.addAll(driver.findElements(byItem));
            else
                webElementsList.add(driver.findElement(byItem));
        });

        return webElementsList;
    }
}