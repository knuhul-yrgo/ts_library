package se.yrgo.integrations;

import io.cucumber.java.en.And;
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
    private final String EXISTING_AUTHOR = "Astrid Lindgren";
    private final String EXISTING_ISBN = "9789129697285";
    private SearchPage searchPage;

    @When("the user navigates to the book search.")
    public void the_user_navigates_to_the_book_search() {
        searchPage = startPage.navigateToSearchPage();
    }

    @And("the user types in an existing isbn.")
    public void the_user_types_in_an_existing_isbn() {
        searchPage.enterIsbn(EXISTING_ISBN);
    }

    @And("the user types in an existing author.")
    public void the_user_types_in_an_existing_author() {
        searchPage.enterAuthor(EXISTING_AUTHOR);
    }

    @And("the user presses the search button.")
    public void the_user_presses_the_search_button() {
        searchPage.pressSearchButton();
    }
    @Then("they can see the search form.")
    public void they_can_see_the_search_form() {
        WebElement form = searchPage.getForm(driver);
        List<WebElement> formElements = form.findElements(By.tagName("input"));
        assertTrue(formElements.size() == 4);
    }

    @Then("information about the book is shown.")
    public void information_about_the_book_is_shown() {
        WebElement booklist = searchPage.getResult();
        assertTrue(booklist.getText().contains(EXISTING_ISBN));
    }

    @Then("the books by the author is shown.")
    public void the_books_by_the_author_is_shown() {
        WebElement bookList = searchPage.getResult();
        assertTrue(bookList.getText().contains(EXISTING_AUTHOR));
    }
}
