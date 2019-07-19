package scraper.requests;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.json.simple.JSONObject;
import scraper.CryptoEngine;

import javax.script.ScriptException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginCredentialRequest {

  private final WebRequest request;
  private String requestId;
  private final Map<String, String> requestHeaders = new LinkedHashMap<>();

  public LoginCredentialRequest() throws MalformedURLException {
    URL uri = new URL(new URL(RequestBuilderTool.BASE_URL), "tmub/api/customer_web_login/prepare");
    request = new WebRequest(uri, HttpMethod.POST);
  }

  public WebRequest buildRequest(String login) throws ScriptException, NoSuchMethodException {
    addHeaders();
    addPayload(createLoginCredentialPayload(login));
    return request;
  }

  private void addHeaders() throws ScriptException, NoSuchMethodException {
    RequestBuilderTool.addTargetRequestsHeaders(requestHeaders);
    requestHeaders.put("DNT", "1");
    requestId = CryptoEngine.getRequestId() + "_1(3)_u(189)";
    requestHeaders.put("X-Request-Id", requestId);
  }

  private void addPayload(JSONObject dataPayload) throws ScriptException, NoSuchMethodException {
    requestHeaders.put("X-Ian-Zito", CryptoEngine.getIanZitoHash(dataPayload.toJSONString()));
    request.setAdditionalHeaders(requestHeaders);
    request.setRequestBody(dataPayload.toJSONString());
  }

  private JSONObject createLoginCredentialPayload(String login) {
    JSONObject dataPayload = new JSONObject();
    JSONObject requestFieldPayload = new JSONObject();
    requestFieldPayload.put("login", login);
    requestFieldPayload.put("action", "OK");
    requestFieldPayload.put("host", "system.t-mobilebankowe.pl");
    dataPayload.put("request", requestFieldPayload);
    RequestBuilderTool.addAgentDataToPayload(dataPayload, requestId);
    return dataPayload;
  }
}
