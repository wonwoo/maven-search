package ml.wonwoo.mavensearch.search.model;

public class Maven<T> {
  private ResponseHeader responseHeader;
  private Response<T> response;

  public ResponseHeader getResponseHeader() {
    return responseHeader;
  }

  public void setResponseHeader(ResponseHeader responseHeader) {
    this.responseHeader = responseHeader;
  }

  public Response<T> getResponse() {
    return response;
  }

  public void setResponse(Response<T> response) {
    this.response = response;
  }
}
