package scraper.requestbuilders;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.json.simple.JSONObject;
import scraper.CryptoEngine;

import javax.script.ScriptException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PasswordCredentialRequestBuilder extends RequestBuilder {

  private String requestId;
  private final HashMap<String, String> requiredData;
  private Map<String, String> requestHeaders;

  public PasswordCredentialRequestBuilder(HashMap<String, String> requiredData) throws MalformedURLException {
    this.requiredData = requiredData;
    URL uri = new URL(new URL(BASE_URL), "tmub/api/customer_web_login/password_masked");
    request = new WebRequest(uri, HttpMethod.POST);
  }


  @Override
  protected void addHeaders() throws ScriptException, NoSuchMethodException {
    requestHeaders = new LinkedHashMap<>();
    addTargetRequestsHeaders(requestHeaders);
    requestHeaders.put("X-Session-Id", requiredData.get("xSessionId"));
    requestId = CryptoEngine.getRequestId() + "_1(4)_u(191)";
    requestHeaders.put("X-Request-Id", requestId);
  }

  @Override
  protected void addPayload() throws ScriptException, NoSuchMethodException {
    JSONObject dataPayload = createPasswordCredentialPayload(requiredData, requestId);
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

  private static JSONObject createPasswordCredentialPayload(HashMap<String, String> requiredData, String requestId) throws ScriptException, NoSuchMethodException {

    JSONObject dataPayload = new JSONObject();
    String passwordHash = CryptoEngine.getPasswordHash(requiredData.get("maskedPassword"));
    JSONObject requestFieldPayload = new JSONObject();
    requestFieldPayload.put("action", "OK");
    requestFieldPayload.put("password", passwordHash);
    requestFieldPayload.put("flow_id", requiredData.get("flowId"));
    requestFieldPayload.put("action_token", requiredData.get("actionToken"));
    dataPayload.put("request", requestFieldPayload);
    addAgentDataToPayload(dataPayload, requestId);

    return dataPayload;
  }
}
