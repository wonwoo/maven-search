package ml.wonwoo.mavensearch.generator;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class MavenXmlGenerator implements Generator {

    @Override
    public Mono<String> generator(String groupId, String artifactId, String version) {
        return Mono.just("<dependency>"
                + "\n\t"
                + "<groupId>"
                + groupId
                + "</groupId>"
                + "\n\t"
                + "<artifactId>"
                + artifactId
                + "</artifactId>"
                + "\n\t"
                + "<version>"
                + version
                + "</version>"
                + "\n"
                + "</dependency>");
    }
}
