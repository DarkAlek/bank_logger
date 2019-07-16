package scraper.requestbuilders;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaseSiteRequestBuilder extends RequestBuilder {

  public BaseSiteRequestBuilder() throws MalformedURLException {
    URL uri = new URL(new URL(BASE_URL), "web/login");
    request = new WebRequest(uri, HttpMethod.GET);
  }

  @Override
  protected void addHeaders() {
    Map<String, String> requestHeaders = new LinkedHashMap<>();
    addInitRequestsHeaders(requestHeaders);
    request.setAdditionalHeaders(requestHeaders);
  }


  @Override
  public WebRequest buildRequest()  {
    addHeaders();
    return request;
  }
}
