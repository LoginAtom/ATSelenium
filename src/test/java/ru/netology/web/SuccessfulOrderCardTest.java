package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessfulOrderCardTest {



    ;
    @BeforeEach
    public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get ("http://localhost:9999");
    }

    @AfterEach
    public void afterEach () {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldBeSuccessfulForm () {

        driver.findElement(By.cssSelector("[data-test-id = 'name'] input")).sendKeys("Петров Пётр Петрович");
        driver.findElement(By.cssSelector("[data-test-id = 'phone'] input")).sendKeys("+73652147852");
        driver.findElement(By.cssSelector("[data-test-id = 'agreement'] ")).cklick();
        driver.findElement(By.cssSelector(".button")).cklick();
        WebElement actualElement = driver.findElement(By.cssSelector("[data-test-id=order-success]"));
        String actualText = actualElement.getText().trim();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", actualText);
        assertTrue(actualElement.isDisplayed());
    }
}

