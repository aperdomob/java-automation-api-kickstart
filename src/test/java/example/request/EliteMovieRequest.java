package example.request;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import example.dto.MovieDto;
import example.dto.SeatParameterDto;
import example.dto.ShowtimeDto;
import utilities.AppConfig;
import utilities.BaseRequest;

public class EliteMovieRequest extends BaseRequest {
  
  public EliteMovieRequest() {
    AppConfig.getInstance().getUrlBase();
  }

  public MovieDto[] getMovies() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MovieDto[]> response = restTemplate.exchange(
      this.concatenateUrl("movie/"),
      HttpMethod.GET,
      null,
      MovieDto[].class);
    
    return response.getBody();
  }

  public ShowtimeDto getShowtime(int showtime) {
    String url = this.concatenateUrl(String.format("showtime/%d", showtime));
    
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<ShowtimeDto> response = restTemplate.exchange(
      url,
      HttpMethod.GET,
      null,
      ShowtimeDto.class);
    
    return response.getBody();
  }

  public int reserve(int showtime, SeatParameterDto[] seats) {
    String url = this.concatenateUrl(String.format("transaction/%d", showtime));

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<SeatParameterDto[]> entity = new HttpEntity<SeatParameterDto[]>(seats, headers);
    
    RestTemplate restTemplate = new RestTemplate();
    
    ResponseEntity<Integer> response = restTemplate.exchange(
      url,
      HttpMethod.POST,
      entity,
      Integer.class
    );
    
    return response.getBody();
  }
  
  public void clean() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.exchange(
      this.concatenateUrl("clean/"),
      HttpMethod.GET,
      null,
      Void.class);
  }
}
