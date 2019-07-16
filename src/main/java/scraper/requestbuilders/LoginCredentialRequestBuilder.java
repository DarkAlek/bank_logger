package scraper.requestbuilders;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.json.simple.JSONObject;
import scraper.CryptoEngine;

import javax.script.ScriptException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginCredentialRequestBuilder extends RequestBuilder {

  private String requestId;
  private final String login;
  private Map<String, String> requestHeaders;

  public LoginCredentialRequestBuilder(String login) throws MalformedURLException {
    this.login = login;
    URL uri = new URL(new URL(BASE_URL), "tmub/api/customer_web_login/prepare");
    request = new WebRequest(uri, HttpMethod.POST);
  }


  @Override
  protected void addHeaders() throws ScriptException, NoSuchMethodException {
    requestHeaders = new LinkedHashMap<>();
    addTargetRequestsHeaders(requestHeaders);
    requestHeaders.put("DNT", "1");
    requestId = CryptoEngine.getRequestId() + "_1(3)_u(189)";
    requestHeaders.put("X-Request-Id", requestId);
  }

  @Override
  protected void addPayload() throws ScriptException, NoSuchMethodException {
    JSONObject dataPayload = createLoginCredentialPayload(login, requestId);
    requestHeaders.put("X-Ian-Zito", CryptoEngine.getIanZitoHash(dataPayload.toJSONString()));
    request.setAdditionalHeaders(requestHeaders);
    request.setRequestBody(dataPayload.toJSONString());
  }

  @Override
  public WebRequest buildRequest() throws ScriptException, NoSuchMethodException {
    addHeaders();
    addPayload();
    return request;
  }

  private static JSONObject createLoginCredentialPayload(String login, String requestId) {

    JSONObject dataPayload = new JSONObject();
    JSONObject requestFieldPayload = new JSONObject();
    requestFieldPayload.put("login", login);
    requestFieldPayload.put("action", "OK");
    requestFieldPayload.put("host", "system.t-mobilebankowe.pl");
    dataPayload.put("request", requestFieldPayload);
    addAgentDataToPayload(dataPayload, requestId);

    return dataPayload;
  }
}
