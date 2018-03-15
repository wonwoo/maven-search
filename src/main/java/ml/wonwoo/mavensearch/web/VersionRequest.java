package ml.wonwoo.mavensearch.web;

public class VersionRequest {

  private String g;
  private String a;
  private String v;
  private int row = 20;
  private int start = 0;

  public String getG() {
    return g;
  }

  public void setG(String g) {
    this.g = g;
  }

  public String getA() {
    return a;
  }

  public void setA(String a) {
    this.a = a;
  }

  public String getV() {
    return v;
  }

  public void setV(String v) {
    this.v = v;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }
}
