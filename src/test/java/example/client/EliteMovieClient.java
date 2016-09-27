package example.client;

import example.dto.MovieDto;
import example.dto.SeatParameterDto;
import example.dto.ShowtimeDto;
import example.request.EliteMovieRequest;

public class EliteMovieClient {
  
  private EliteMovieRequest request;
  
  public EliteMovieClient() {
    this.request = new EliteMovieRequest();
  }
  
  public MovieDto[] getMovies() {
    return this.request.getMovies();
  }
  
  public int reserve(SeatParameterDto[] seats) {
    return this.request.reserve(seats);
  }
  
  public ShowtimeDto getShowtime() {
    return this.request.getShowtime();
  }

  public void clean() {
    this.request.clean();
  }
}
