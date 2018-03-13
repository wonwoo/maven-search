package ml.wonwoo.mavensearch.search.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = DocsDeserializer.class)
public class Docs {

  private String id;

  private String groupId;

  private String artifactId;

  private String latestVersion;

  private String repositoryId;

  private String packaging;

  private String dateTime;

  private Long timestamp;

  private Integer versionCount;

  private List<String> text;

  private List<String> ec;

  public Docs(String id, String groupId, String artifactId,
              String latestVersion, String repositoryId, String packaging,
              String dateTime, Long timestamp, Integer versionCount, List<String> text, List<String> ec) {
    this.id = id;
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.latestVersion = latestVersion;
    this.repositoryId = repositoryId;
    this.packaging = packaging;
    this.dateTime = dateTime;
    this.timestamp = timestamp;
    this.versionCount = versionCount;
    this.text = text;
    this.ec = ec;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
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

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
  public String getDateTime() {
    return this.dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
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
