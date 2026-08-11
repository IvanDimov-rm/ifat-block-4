package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div" +
            "[@class='inventory_item']//child::*[text()='Add to cart']";
    private final By pageName = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By counter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartIcon = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By addToCartBtn = By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"));

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    public String getNamePage() {
        return browser.findElement(pageName).getText();
    }

    public void addToCart(final String goodsName) {
        By goods = By.xpath(ADD_TO_CART.formatted(goodsName));
        browser.findElement(goods).click();
    }

    public void addToCart(int goodsIndex) {
        browser.findElements(addToCartBtn).get(goodsIndex).click();
    }

    public String checkCounterValue() {
        return browser.findElement(counter).getText();
    }

    public String checkCounterColorValue() {
        return browser.findElement(counter).getCssValue("background-color");
    }

    public void switchToCart() {
        browser.findElement(cartIcon).click();
    }
}