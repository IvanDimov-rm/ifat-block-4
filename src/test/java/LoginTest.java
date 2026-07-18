import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

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
