package se.yrgo.integrations.pos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
