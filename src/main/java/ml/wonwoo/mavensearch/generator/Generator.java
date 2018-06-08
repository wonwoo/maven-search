package ml.wonwoo.mavensearch.generator;

public interface Generator {

  String generator(String groupId, String artifactId, String version);
}
