import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {
    //1. открыть нужный браузер
    //2. зайти на сайт saucedemo.com
    //3. залогиниться
    //4. проверить что залогинились

    @Test
    public void login() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        browser.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("[value='Login']")).click();
        browser.findElement(By.cssSelector("[id='shopping_cart_container']")).isDisplayed();

        browser.quit();
    }
}
