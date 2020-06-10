package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProductDetailsPageObject {
    @FindBy(className = "cart_bt")
    public WebElement iconCart;

    @FindBy(className = "access_link")
    public WebElement iconAccess;

    @FindBy(className = "wishlist")
    public WebElement iconWishlist;

    @FindBy(className = "current")
    public WebElement currentShoeSize;

    @FindBy(className = "new_price")
    public WebElement newShoePrice;

    @FindBy(xpath = "//div[contains(@class,'prod_info')]//em")
    public WebElement ratingCounter;

    @FindBy(className = "btn_add_to_cart")
    public WebElement buttonAddToCart;

    @FindBy(className = "old_price")
    public WebElement oldShoePrice;

    public Set<By> getLaptopProductPageElements() {
        return new HashSet<>(Arrays.asList(By.id("logo"), By.xpath("//div[@class='main-menu']//li"), By.className("custom-search-input"),
                By.xpath("//div[@class='custom-search-input']/button"), By.className("cart_bt"), By.className("wishlist"),
                By.className("access_link"), By.id("shoe_name"), By.id("shoe_img"), By.className("rating"),
                By.xpath("//div[contains(@class,'prod_info')]/p"), By.xpath("//div[contains(@class,'prod_info')]//small"),
                By.xpath("//label[.='Size']"), By.className("nice-select"), By.xpath("//label[.='Quantity']"),
                By.className("numbers-row"), By.className("price_main"), By.className("btn_add_to_cart")));
    }

    public Set<By> getTabletProductPageElements() {
        return new HashSet<>(Arrays.asList(By.id("logo"), By.className("custom-search-input"),
                By.xpath("//div[@class='custom-search-input']/button"), By.className("cart_bt"), By.className("wishlist"),
                By.className("access_link"), By.id("shoe_name"), By.id("shoe_img"), By.className("rating"),
                By.xpath("//div[contains(@class,'prod_info')]/p"), By.xpath("//label[.='Size']"), By.className("nice-select"),
                By.xpath("//label[.='Quantity']"), By.className("numbers-row"), By.className("price_main"), By.className("btn_add_to_cart")));
    }

    public Set<By> getTabletProductPageHiddenElements() {
        return new HashSet<>(Arrays.asList(By.xpath("//div[@class='main-menu']//li")));
    }

    public Set<By> getMobileProductPageElements() {
        return new HashSet<>(Arrays.asList(By.id("logo"), By.className("btn_search_mob"),
                By.className("cart_bt"), By.className("wishlist"), By.className("access_link"), By.id("shoe_name"),
                By.id("shoe_img"), By.className("rating"), By.xpath("//div[contains(@class,'prod_info')]/p"),
                By.xpath("//label[.='Size']"), By.className("nice-select"), By.xpath("//label[.='Quantity']"),
                By.className("numbers-row"), By.className("price_main"), By.className("btn_add_to_cart")));
    }

    public Set<By> getMobileProductPageHiddenElements() {
        return new HashSet<>(Arrays.asList(By.xpath("//div[@class='main-menu']//li"), By.className("custom-search-input"),
                By.xpath("//div[@class='custom-search-input']/button")));
    }

    public String getIconCartPosition() {
        return iconCart.getLocation().toString();
    }

    public String getIconAccessPosition() {
        return iconAccess.getLocation().toString();
    }

    public String getIconWishlistPosition() {
        return iconWishlist.getLocation().toString();
    }

    public String getCurrentShoeSize() {
        return currentShoeSize.getText();
    }

    public String getNewPrice() {
        return newShoePrice.getText();
    }

    public String getRatingCounterPosition() {
        return ratingCounter.getLocation().toString();
    }

    public String getButtonAddToCartPosition() {
        return buttonAddToCart.getLocation().toString();
    }

    public String getOldPriceColor() {
        return Color.fromString(oldShoePrice.getCssValue("color")).asHex();
    }
}
