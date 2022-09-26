package test;

import config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTest {
    private WebDriver driver;
    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }
    @Test
    public void testGoogle(){
        String title = driver.getTitle();
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("qa engineer");
        searchInput.submit();
        Assertions.assertEquals("Google", title);
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }

}
