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

public class EliteMovieRequest {

  public MovieDto[] getMovies() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<MovieDto[]> response = restTemplate.exchange(
      "http://localhost:8080/rest/movie/",
      HttpMethod.GET,
      null,
      MovieDto[].class);
    
    return response.getBody();
  }

  public ShowtimeDto getShowtime() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<ShowtimeDto> response = restTemplate.exchange(
      "http://localhost:8080/rest/showtime/3",
      HttpMethod.GET,
      null,
      ShowtimeDto.class);
    
    return response.getBody();
  }

  public int reserve(SeatParameterDto[] seats) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<SeatParameterDto[]> entity = new HttpEntity<SeatParameterDto[]>(seats, headers);
    
    RestTemplate restTemplate = new RestTemplate();
    
    ResponseEntity<Integer> response = restTemplate.exchange(
      "http://localhost:8080/rest/transaction/3",
      HttpMethod.POST,
      entity,
      Integer.class
    );
    
    return response.getBody();
  }
  
  public void clean() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.exchange(
      "http://localhost:8080/rest/clean/",
      HttpMethod.GET,
      null,
      Void.class);
  }
}
