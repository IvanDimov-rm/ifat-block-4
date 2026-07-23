package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By loginInput = By.xpath("//*[@id='user-name']");
    private final By passwordInput = By.xpath("//*[@id='password']");
    private final By loginBtn = By.cssSelector("#login-button");

    WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open(){
            browser.get("https://www.saucedemo.com/");
    }

    public void login(final String userName, final String password){
        browser.findElement(loginInput).sendKeys(userName);
        browser.findElement(passwordInput).sendKeys(password);
        browser.findElement(loginBtn).click();
    }


}
