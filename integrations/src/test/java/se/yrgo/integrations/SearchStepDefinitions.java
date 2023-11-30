package se.yrgo.integrations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import se.yrgo.integrations.pos.SearchPage;
import se.yrgo.integrations.pos.StartPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class SearchStepDefinitions {
    private final WebDriver driver = GeneralStepDefinitions.getDriver();
    private final StartPage startPage = GeneralStepDefinitions.getStartPage();
    private SearchPage searchPage;

    @When("the user navigates to the book search.")
    public void the_user_navigates_to_the_book_search() {
        searchPage = startPage.navigateToSearchPage();
    }

    @Then("they can see the search form.")
    public void they_can_see_the_search_form() {
        WebElement form = searchPage.getForm(driver);
        List<WebElement> formElements = form.findElements(By.tagName("input"));
        assertTrue(formElements.size() == 4);
    }
}
