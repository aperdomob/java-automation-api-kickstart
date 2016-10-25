package example.tests;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.tests.features.elitemovie.DisplayFilms;

public class EliteMovieStepDefinition {
  
  private DisplayFilms displayFilms;

  public EliteMovieStepDefinition() {
  }
  
  @Given("^the main page$")
  public void the_main_page() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @When("^consult the movies list$")
  public void consult_the_movies_list() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @Then("^should be display:$")
  public void should_be_display(DataTable arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      // For automatic transformation, change DataTable to one of
      // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
      // E,K,V must be a scalar (String, Integer, Date, enum etc)
      throw new PendingException();
  }

  @Given("^the showtime <showtime>$")
  public void the_showtime_showtime() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @Given("^the seats:$")
  public void the_seats(DataTable arg1) throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      // For automatic transformation, change DataTable to one of
      // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
      // E,K,V must be a scalar (String, Integer, Date, enum etc)
      throw new PendingException();
  }

  @When("^reserve the seats$")
  public void reserve_the_seats() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }

  @Then("^the seats should be booked$")
  public void the_seats_should_be_booked() throws Throwable {
      // Write code here that turns the phrase above into concrete actions
      throw new PendingException();
  }
}
