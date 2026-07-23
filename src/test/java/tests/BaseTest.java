package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    public WebDriver browser;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        loginPage = new LoginPage(browser);
    }

    @AfterMethod
    public void close() {
        browser.quit();
    }
}
