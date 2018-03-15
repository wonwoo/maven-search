package ml.wonwoo.mavensearch.generator;

import reactor.core.publisher.Mono;

public interface Generator {

  Mono<String> generator(String groupId, String artifactId, String version);
}
