package ml.wonwoo.mavensearch.search;

import io.micrometer.core.instrument.MeterRegistry;
import ml.wonwoo.mavensearch.search.model.Docs;
import ml.wonwoo.mavensearch.search.model.Maven;
import ml.wonwoo.mavensearch.search.model.VersionDocs;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class MavenClient {

  private static final String MAVEN_BASE_URL = "http://search.maven.org";
  private final RestTemplate restTemplate;
  private final MeterRegistry meterRegistry;

  public MavenClient(RestTemplateBuilder builder, MeterRegistry meterRegistry) {
    this.restTemplate = builder
        .rootUri(MAVEN_BASE_URL)
        .build();
    this.meterRegistry = meterRegistry;
  }

  public Maven<Docs> select(String q, int row, int start) {
    ResponseEntity<Maven<Docs>> docs = restTemplate.exchange("/solrsearch/select?q={q}&rows={row}&wt=json&start={start}", HttpMethod.GET,
        null, new ParameterizedTypeReference<Maven<Docs>>() {
        },
        StringUtils.hasLength(q) ? q : "\"\"", row, start);
    increment("maven.select");
    return docs.getBody();
  }

  //FIXME bug
  public Maven<VersionDocs> versions(String g, String a, int row, int start) {
    ResponseEntity<Maven<VersionDocs>> versionDocs = restTemplate.exchange("/solrsearch/select?q=g:{g}+AND+a:{a}&rows={row}&wt=json&start={start}&core=gav", HttpMethod.GET,
        null, new ParameterizedTypeReference<Maven<VersionDocs>>() {
        },
        g, a, row, start);
    increment("maven.version");
    return versionDocs.getBody();

  }

  private void increment(String key) {
    meterRegistry.counter(key).increment();
  }
}
