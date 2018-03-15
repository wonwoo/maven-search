package ml.wonwoo.mavensearch.search.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import ml.wonwoo.mavensearch.utils.Utils;

public class DocsDeserializer extends JsonObjectDeserializer<Docs> {

  @Override
  protected Docs deserializeObject(JsonParser jsonParser,
          DeserializationContext context,
          ObjectCodec codec, JsonNode jsonNode) {

    String id = nullSafeValue(jsonNode.get("id"), String.class);
    String groupId = nullSafeValue(jsonNode.get("g"), String.class);
    String artifactId = nullSafeValue(jsonNode.get("a"), String.class);
    String latestVersion = nullSafeValue(jsonNode.get("latestVersion"), String.class);
    String repositoryId = nullSafeValue(jsonNode.get("repositoryId"), String.class);
    String packaging = nullSafeValue(jsonNode.get("p"), String.class);
    Long timestamp = nullSafeValue(jsonNode.get("timestamp"), Long.class);
    Integer versionCount = nullSafeValue(jsonNode.get("versionCount"), Integer.class);
    List<String> text = toList((ArrayNode) jsonNode.get("text"));
    List<String> ec = toList((ArrayNode) jsonNode.get("ec"));
    return new Docs(id, groupId, artifactId, latestVersion, repositoryId,
            packaging, Utils.formatToEnglish(timestamp), timestamp, versionCount, text, ec);
  }

  private static List<String> toList(ArrayNode nodes) {
    if (nodes == null) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();
    for (JsonNode node : nodes) {
      result.add(node.asText());
    }
    return result;
  }
}
