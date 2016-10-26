package utilities;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Request {

  public static <T> T exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) {

    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<T> response = restTemplate.exchange(url, method, requestEntity, responseType);

    return response.getBody();
  }
}
