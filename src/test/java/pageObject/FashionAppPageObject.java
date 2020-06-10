package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FashionAppPageObject {
    /**
     * Web elements
     */
    @FindBy(xpath = "//*[@id='colors__Black']/..")
    public WebElement checkboxColorBlack;

    @FindBy(id = "filterBtn")
    public WebElement buttonFilter;

    @FindBy(id = "SMALL____105")
    public WebElement colorBlackFilterCounter;

    @FindBy(className = "grid_item")
    public List<WebElement> productItemList;

    @FindBy(id = "ti-filter")
    public WebElement iconFilterResults;

    @FindBy(xpath = "//div[@class='grid_item'][1]")
    private WebElement firstItemFromResults;

    @FindBy(xpath = "//div[@class='grid_item'][1]//a")
    private WebElement firstItemFromResultsAnchor;

    @FindBy(id = "product_grid")
    public WebElement productGrid;

    public Set<By> getLaptopPageElements() {
        return new HashSet<>(Arrays.asList(By.id("logo"), By.xpath("//div[@class='main-menu']//li"), By.className("custom-search-input"),
                By.xpath("//div[@class='custom-search-input']/button"), By.className("cart_bt"), By.className("wishlist"),
                By.className("access_link"), By.xpath("//div[@id='sidebar_filters']//div"), By.id("filterBtn"), By.id("resetBtn"),
                By.className("top_banner"), By.className("sort_select"), By.className("ti-view-grid"), By.className("ti-view-list"),
                By.xpath("//div[@id='product_grid']//div[@class='grid_item']")));
    }

    public Set<By> getLaptopPageHiddenElements() {
        return new HashSet<>(Arrays.asList(By.id("ti-filter"), By.className("btn_search_mob")));
    }

    public Set<By> getTabletPageElements() {
        return new HashSet<>(Arrays.asList(By.id("logo"), By.className("custom-search-input"),
                By.xpath("//div[@class='custom-search-input']/button"), By.className("cart_bt"),
                By.className("access_link"), By.className("top_banner"), By.className("sort_select"),
                By.id("ti-filter"), By.xpath("//div[@id='product_grid']//div[@class='grid_item']")));
    }

    public Set<By> getTabletPageHiddenElements() {
        return new HashSet<>(Arrays.asList(By.xpath("//div[@class='main-menu']//li"), By.className("btn_search_mob"),
                By.className("wishlist"), By.xpath("//div[@id='sidebar_filters']//div"), By.id("filterBtn"),
                By.id("resetBtn"), By.className("ti-view-grid"), By.className("ti-view-list")));
    }

    public Set<By> getMobilePageElements() {
        return new HashSet<>(Arrays.asList(By.id("logo"), By.className("btn_search_mob"), By.className("cart_bt"),
                By.className("access_link"), By.className("top_banner"), By.className("sort_select"),
                By.id("ti-filter"), By.xpath("//div[@id='product_grid']//div[@class='grid_item']")));
    }

    public Set<By> getMobilePageHiddenElements() {
        return new HashSet<>(Arrays.asList(By.xpath("//div[@class='main-menu']//li"), By.className("custom-search-input"),
                By.xpath("//div[@class='custom-search-input']/button"), By.className("wishlist"), By.id("filterBtn"),
                By.id("resetBtn"), By.xpath("//div[@id='sidebar_filters']//div"), By.className("ti-view-grid"),
                By.className("ti-view-list")));
    }

    public void clickCheckboxColorBlack() {
        checkboxColorBlack.click();
    }

    public void clickButtonFilter() {
        buttonFilter.click();
    }

    public int getColorBlackFilterCounter() {
        return Integer.parseInt(colorBlackFilterCounter.getText().replaceAll("[^0-9]", ""));
    }

    public int getProductItemListSize() {
        return productItemList.size();
    }

    public void clickIconFilterResults() {
        iconFilterResults.click();
    }

    public String getUrlForFirstItemFromResults() {
        return firstItemFromResultsAnchor.getAttribute("href");
    }

    public void clickFirstItemFromResults() {
        firstItemFromResults.click();
    }
}