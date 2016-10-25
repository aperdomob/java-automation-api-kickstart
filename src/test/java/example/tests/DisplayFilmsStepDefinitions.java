package example.tests;

import static org.junit.Assert.*;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.*;

import java.util.Arrays;
import java.util.List;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import example.client.EliteMovieClient;
import example.dto.MovieDto;

public class DisplayFilmsStepDefinitions {
	
	private EliteMovieClient client;
	private MovieDto[] movies;
	
  public DisplayFilmsStepDefinitions() {
  	
  }
  
  @Given("^the main page$")
  public void theMainPage() throws Throwable {
  	this.client = new EliteMovieClient();
  }

  @When("^consult the movies list$")
  public void consultTheMoviesList() throws Throwable {
  	this.movies = this.client.getMovies();
  }

  @Then("^should be display:$")
  public void shouldBeDisplay(List<String> expectedFilms) throws Throwable {
  	String[] filmNames = Arrays
			.stream(movies)
			.map(movie -> movie.getName())
			.toArray(size -> new String[size]);

  	assertThat("", expectedFilms, containsInAnyOrder(filmNames));
  }
}
