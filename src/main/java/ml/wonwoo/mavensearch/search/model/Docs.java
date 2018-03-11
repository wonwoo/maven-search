package ml.wonwoo.mavensearch.search.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public class Docs {

  private String id;

  @JsonProperty("g")
  private String graupId;

  @JsonProperty("a")
  private String artifactId;

  private String latestVersion;

  private String repositoryId;

  @JsonProperty("p")
  private String packaging;

  private Instant timestamp;

  private int versionCount;

  private List<String> text;

  private List<String> ec;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGraupId() {
    return graupId;
  }

  public void setGraupId(String graupId) {
    this.graupId = graupId;
  }

  public String getArtifactId() {
    return artifactId;
  }

  public void setArtifactId(String artifactId) {
    this.artifactId = artifactId;
  }

  public String getLatestVersion() {
    return latestVersion;
  }

  public void setLatestVersion(String latestVersion) {
    this.latestVersion = latestVersion;
  }

  public String getRepositoryId() {
    return repositoryId;
  }

  public void setRepositoryId(String repositoryId) {
    this.repositoryId = repositoryId;
  }

  public String getPackaging() {
    return packaging;
  }

  public void setPackaging(String packaging) {
    this.packaging = packaging;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public int getVersionCount() {
    return versionCount;
  }

  public void setVersionCount(int versionCount) {
    this.versionCount = versionCount;
  }

  public List<String> getText() {
    return text;
  }

  public void setText(List<String> text) {
    this.text = text;
  }

  public List<String> getEc() {
    return ec;
  }

  public void setEc(List<String> ec) {
    this.ec = ec;
  }
}
