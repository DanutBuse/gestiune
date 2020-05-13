import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class RequestGeneratorScript {

  @Test
  public void generateRequests() throws IOException {
    RestTemplate restTemplate = new RestTemplate();
    String path = "src/test/resources/json/maximal-market";
    String jsonBody = new String(Files.readAllBytes(Paths.get(path)));
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> request =
        new HttpEntity<>(jsonBody, headers);

    List<Supplier> suppliers = new LinkedList<>();
    for (int i = 0; i < 35; i++) {
      suppliers.add(() ->
          restTemplate.postForObject(URI.create("http://173.193.99.209:8081/market"), request, String.class));
    }
    suppliers.parallelStream().forEach(Supplier::get);

  }

}
