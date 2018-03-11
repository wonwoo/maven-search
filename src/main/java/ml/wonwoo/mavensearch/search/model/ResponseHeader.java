package ml.wonwoo.mavensearch.search.model;

import java.util.Map;

public class ResponseHeader {
  private int status;
  private int QTime;
  private Map<String, String> params;

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getQTime() {
    return QTime;
  }

  public void setQTime(int QTime) {
    this.QTime = QTime;
  }

  public Map<String, String> getParams() {
    return params;
  }

  public void setParams(Map<String, String> params) {
    this.params = params;
  }
}
