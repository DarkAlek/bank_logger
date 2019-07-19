package scraper.requestbuilders;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseSiteRequest {

  private final WebRequest request;
  private final Map<String, String> requestHeaders = new LinkedHashMap<>();

  public BaseSiteRequest() throws MalformedURLException {
    URL uri = new URL(new URL(RequestBuilderTool.BASE_URL), "web/login");
    request = new WebRequest(uri, HttpMethod.GET);
  }

  public WebRequest buildRequest()  {
    addHeaders();
    return request;
  }

  private void addHeaders() {
    RequestBuilderTool.addInitRequestsHeaders(requestHeaders);
    request.setAdditionalHeaders(requestHeaders);
  }
}
