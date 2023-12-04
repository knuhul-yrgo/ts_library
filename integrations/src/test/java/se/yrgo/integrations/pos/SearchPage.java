package se.yrgo.integrations.pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import se.yrgo.integrations.CustomConditions;
import se.yrgo.integrations.Utils;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    public SearchPage(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getForm(final WebDriver driver) {
        WebElement form = driver.findElement(By.tagName("form"));
        return form;
    }

    public void enterIsbn(String existingIsbn) {
        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        var isbnInput = Utils.find(driver, By.xpath("//input[@placeholder='ISBN']"));
        wait.until(CustomConditions.elementHasBeenClicked(isbnInput));
        isbnInput.sendKeys(existingIsbn);
    }

    public void pressSearchButton() {
        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        var searchButton = Utils.find(driver, By.xpath("//input[@value='Search']"));
        wait.until(CustomConditions.elementHasBeenClicked(searchButton));
    }

    public void enterAuthor(String existingAuthor) {
        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        var authorInput = Utils.find(driver, By.xpath("//input[@placeholder='Author']"));
        wait.until(CustomConditions.elementHasBeenClicked(authorInput));
        authorInput.sendKeys(existingAuthor);
    }

    public WebElement getResult() {
        final var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        var matchingBooks = Utils.find(driver, By.xpath("//table[contains(.,'Matching books')]"));
        if (matchingBooks == null) {
            throw new NullPointerException("No matching books found");
        }
        return matchingBooks;
    }
}
