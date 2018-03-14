package ml.wonwoo.mavensearch.search;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.micrometer.core.instrument.MeterRegistry;
import ml.wonwoo.mavensearch.search.model.Docs;
import ml.wonwoo.mavensearch.search.model.Maven;
import ml.wonwoo.mavensearch.search.model.VersionDocs;
import reactor.core.publisher.Mono;

@Service
public class MavenRepository {

  private static final String MAVEN_BASE_URL = "http://search.maven.org";
  private final WebClient webClient;
  private final MeterRegistry meterRegistry;

  public MavenRepository(WebClient.Builder builder, MeterRegistry meterRegistry) {
    this.webClient = builder
        .baseUrl(MAVEN_BASE_URL)
        .build();
    this.meterRegistry = meterRegistry;
  }

  public Mono<Maven<Docs>> select(String q, int row, int start) {
    return this.webClient
            .get()
            .uri("/solrsearch/select?q=\"{q}\"&rows={row}&wt=json&start={start}", q, row, start)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<Maven<Docs>>() {})
            .doFinally(signalType -> increment("maven.versions"));
  }

  public Mono<Maven<VersionDocs>> versions(String g, String a, int row, int start) {
    String url = String.format("/solrsearch/select?q=g:%s+AND+a:%s&rows=%s&wt=json&start=%s&core=gav",
        g, a, row, start);
    return this.webClient
        .get()
        .uri(url)
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<Maven<VersionDocs>>() {})
        .doFinally(signalType -> increment("maven.versions"));
  }

  private void increment(String key) {
    meterRegistry.counter(key).increment();
  }
}
