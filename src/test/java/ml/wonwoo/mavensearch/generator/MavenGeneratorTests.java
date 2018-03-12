package ml.wonwoo.mavensearch.generator;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MavenGeneratorTests {

    private final Generator mavenGenerator = new MavenGenerator();

    @Test
    public void generatorTest() {
        Mono<String> generator = mavenGenerator.generator("com.github.wonwoo",
                "dynamodb-spring-boot", "1.0.1-RELEASE");
        StepVerifier.create(generator)
                .expectNext("<dependency>\n"
                        + "\t<groupId>com.github.wonwoo</groupId>\n"
                        + "\t<artifactId>dynamodb-spring-boot</artifactId>\n"
                        + "\t<version>1.0.1-RELEASE</version>\n"
                        + "</dependency>")
                .expectComplete().verify(Duration.ofSeconds(1));
    }
}