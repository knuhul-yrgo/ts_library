package se.yrgo.integrations.pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.yrgo.integrations.CustomConditions;
import se.yrgo.integrations.Utils;

import java.time.Duration;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver){
        this.driver = driver;
    }

    public SearchPage navigateToSearchPage() {
        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        final var searchLink = Utils.find(driver, By.xpath("//a[contains(.,'Find a book')]"));
        wait.until(CustomConditions.elementHasBeenClicked(searchLink));
        return new SearchPage(driver);
    }
}
