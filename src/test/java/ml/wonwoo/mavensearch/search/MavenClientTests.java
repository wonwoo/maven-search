package ml.wonwoo.mavensearch.search;

import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import ml.wonwoo.mavensearch.search.model.Docs;
import ml.wonwoo.mavensearch.search.model.Maven;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(MavenClient.class)
public class MavenClientTests {

    @Autowired
    private MavenClient mavenClient;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void select() {
        this.server.expect(requestTo(
                "/solrsearch/select?q=\"test\"&rows=20&wt=json&start=0"))
                .andRespond(withSuccess(new ClassPathResource("maven.json"), MediaType.APPLICATION_JSON));
        Mono<Maven<Docs>> select = mavenClient.select("test", 20, 0);

        StepVerifier.create(select)
                .consumeNextWith(docsMaven -> {
                    Docs docs = docsMaven.getResponse().getDocs().get(0);
                    assertThat(docs.getGroupId()).isEqualTo("com.google.inject");
                    assertThat(docs.getArtifactId()).isEqualTo("");
                })
                .expectComplete()
                .verify(Duration.ofSeconds(3));
    }
}