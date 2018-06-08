package ml.wonwoo.mavensearch.generator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MavenGeneratorTests {

  private final Generator mavenGenerator = new MavenGenerator();

  @Test
  public void generatorTest() {
    String generator = mavenGenerator.generator("com.github.wonwoo",
            "dynamodb-spring-boot", "1.0.1-RELEASE");
    assertThat(generator).isEqualTo("<dependency>\n"
        + "\t<groupId>com.github.wonwoo</groupId>\n"
        + "\t<artifactId>dynamodb-spring-boot</artifactId>\n"
        + "\t<version>1.0.1-RELEASE</version>\n"
        + "</dependency>");
  }
}