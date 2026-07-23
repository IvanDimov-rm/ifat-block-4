package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {


    @Test
    public void correctlogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        boolean titleDisplayed = browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
        String titleName = browser.findElement(By.cssSelector("[data-test='title']")).getText();

        assertTrue(titleDisplayed);
        assertEquals(titleName, "Products");
    }

    @Test
    public void incorrectlogin() {
        loginPage.open();
        loginPage.login("unstandard_user", "secret_sauce");

        boolean isErrorDisplayed = browser.findElement(By.cssSelector("[data-test='error']")).isDisplayed();
                String errorText = browser.findElement(By.cssSelector("[data-test='error']")).getText();

        assertTrue(isErrorDisplayed);
        assertEquals(errorText, "Epic face: Username and password do not match any user in this service");
    }

    }