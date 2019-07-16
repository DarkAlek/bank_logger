package scraper.requestbuilders;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import scraper.CryptoEngine;

import javax.script.ScriptException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class CampaignGetSiteRequestBuilder extends RequestBuilder {

  private String requestId;

  public CampaignGetSiteRequestBuilder() throws MalformedURLException {
    URL uri = new URL(new URL(BASE_URL), "tmub/api/campaign_get");
    request = new WebRequest(uri, HttpMethod.POST);
  }

  @Override
  protected void addHeaders() throws ScriptException, NoSuchMethodException {
    Map<String, String> requestHeaders = new LinkedHashMap<>();
    addInitRequestsHeaders(requestHeaders);
    requestId = CryptoEngine.getRequestId() + "_1(1)_u(203)";
    requestHeaders.put("X-Request-Id",  requestId);
    request.setAdditionalHeaders(requestHeaders);
  }

  @Override
  protected void addPayload() {
    String dataPayload = "{\"request\":{\"component_list\":[{\"component_id\":\"1\"},{\"component_id\":\"999999999\"}]},\"agent\":{\"screen_width\":1855,\"app_version\":\"1.35.306.5\",\"request_id\":\"" + requestId + "\"}}";
    request.setRequestBody(dataPayload);
  }

  @Override
  public WebRequest buildRequest() throws ScriptException, NoSuchMethodException {
    addHeaders();
    addPayload();
    return request;
  }
}
