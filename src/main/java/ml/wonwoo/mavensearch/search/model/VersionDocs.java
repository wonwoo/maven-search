package ml.wonwoo.mavensearch.search.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = VersionDocsDeserializer.class)
public class VersionDocs {

  private String id;

  private String groupId;

  private String artifactId;

  private String latestVersion;

  private String repositoryId;

  private String packaging;

  private String dateTime;

  private Long timestamp;

  private String version;

  private List<String> text;

  private List<String> tags;

  public VersionDocs(String id, String groupId, String artifactId,
          String latestVersion, String repositoryId, String packaging,
          String dateTime, Long timestamp, String version, List<String> text, List<String> tags) {
    this.id = id;
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.latestVersion = latestVersion;
    this.repositoryId = repositoryId;
    this.packaging = packaging;
    this.dateTime = dateTime;
    this.timestamp = timestamp;
    this.version = version;
    this.text = text;
    this.tags = tags;
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

  public String getDateTime() {
    return dateTime;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public List<String> getText() {
    return text;
  }

  public void setText(List<String> text) {
    this.text = text;
  }

  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }
}
