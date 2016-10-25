package example.tests.features.elitemovie;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.StepdefBody.A0;
import cucumber.api.java8.StepdefBody.A1;
import example.client.EliteMovieClient;
import example.dto.MovieDto;

public class DisplayFilms {
  
  private EliteMovieClient client;
  private MovieDto[] movies;

  public A0 theMainPage() {
    return () -> {
      this.client = new EliteMovieClient();
    };
  }

  public A0 consultTheMovieList() {
    return () -> {
      this.movies = client.getMovies();
    };
  }
  
  public A1<List<String>> filmList() {
    return (List<String> expectedFilms) -> {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    };
  }
}
