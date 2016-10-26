package example.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import example.dto.MovieDto;
import example.dto.SeatParameterDto;
import example.dto.ShowtimeDto;
import utilities.BaseRequest;
import utilities.Request;

public class EliteMovieRequest extends BaseRequest {

  public MovieDto[] getMovies() {
    return Request.exchange(
      this.concatenateUrl("movie/"),
      HttpMethod.GET,
      null,
      MovieDto[].class);
  }
  
  public ShowtimeDto getShowtime(int showtime) {
    String url = this.concatenateUrl(String.format("showtime/%d", showtime));

    return Request.exchange(
      url,
      HttpMethod.GET,
      null,
      ShowtimeDto.class);
  }

  public int reserve(int showtime, SeatParameterDto[] seats) {
    String url = this.concatenateUrl(String.format("transaction/%d", showtime));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<SeatParameterDto[]> requestEntity = new HttpEntity<SeatParameterDto[]>(seats, headers);
    
    return Request.exchange(
      url,
      HttpMethod.POST,
      requestEntity,
      Integer.class);
  }
  
  public void clean() {
    Request.exchange(
      this.concatenateUrl("clean/"),
      HttpMethod.GET,
      null,
      Void.class);
  }
}
