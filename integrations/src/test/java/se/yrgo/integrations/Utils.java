package se.yrgo.integrations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.yrgo.integrations.pos.StartPage;

import java.time.Duration;

public class Utils {
    private Utils() {}

    public static WebElement find(WebDriver driver, By locator) {
        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public static StartPage openStartPage(WebDriver driver) {
        driver
            .manage()
            .timeouts()
            .implicitlyWait(Duration.ofSeconds(5));
        driver
            .manage()
            .window()
            .maximize();

        driver.get("http://frontend");
        if (!"The Library".equals(driver.getTitle())) {
            throw new IllegalStateException("Not on the start page");
        }
        return new StartPage(driver);
    }
}