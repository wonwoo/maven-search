package ml.wonwoo.mavensearch.generator;

import org.springframework.stereotype.Service;

@Service
public class MavenGenerator implements Generator {

  @Override
  public String generator(String groupId, String artifactId, String version) {
    return "<dependency>"
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
        + "</dependency>";
  }
}
