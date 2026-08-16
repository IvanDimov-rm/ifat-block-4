package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.List;

import static user.UserFactory.*;
import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Backpack",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Bolt T-Shirt");

    @Step("Проверяем добавление товаров в корзину")
    @Test
    @Owner("Ivan Dimov Ivandimov981pushok@gmail.com")
    public void checkGoodsAdded() {
        System.out.println("ProductsTest.checkGoodsAdded running in thread: " + Thread.currentThread().getName());
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.pageIsOpen();

        for (String goodName : goodsList) {
            productsPage.addToCart(goodName);
        }

        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}
