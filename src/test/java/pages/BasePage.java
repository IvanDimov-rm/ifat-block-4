package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

public class BasePage {
    public static final String BASE_URL = PropertyReader.getProperty("saucedemo.url");
    public static final String DATA_TEST_PATTERN = "[data-test='%s']";
    public static final String TEXT_LOCATOR_PATTERN = "//*[text()='%s']";
    private final By pageName = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));

    WebDriver browser;
    WebDriverWait wait;

    public BasePage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
    public boolean pageIsOpen() {
        return browser.findElement(pageName).isDisplayed();
}
}
