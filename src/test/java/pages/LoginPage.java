package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By loginInput = By.cssSelector(DATA_TEST_PATTERN.formatted("username"));
    private final By passwordInput = By.cssSelector(DATA_TEST_PATTERN.formatted("password"));
    private final By loginBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("login-button"));
    private final By error = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void open() {
        browser.get(BASE_URL);
    }

    public void login(User user) {
        browser.findElement(loginInput).sendKeys(user.getLogin());
        browser.findElement(passwordInput).sendKeys(user.getPassword());
        browser.findElement(loginBtn).click();
    }

    public boolean isErrorDisplayed() {
        return browser.findElement(error).isDisplayed();
    }

    public String getErrorText() {
        return browser.findElement(error).getText();
    }
}
