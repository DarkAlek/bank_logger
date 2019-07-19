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

public class PasswordCredentialRequest extends RequestBuilderTool {

  private final WebRequest request;
  private String requestId;
  private final Map<String, String> requestHeaders = new LinkedHashMap<>();

  public PasswordCredentialRequest() throws MalformedURLException {
    URL uri = new URL(new URL(BASE_URL), "tmub/api/customer_web_login/password_masked");
    request = new WebRequest(uri, HttpMethod.POST);
  }

  public WebRequest buildRequest(HashMap<String, String> requiredData) throws ScriptException, NoSuchMethodException {
    addHeaders(requiredData.get("xSessionId"));
    addPayload(createPasswordCredentialPayload(
            requiredData.get("maskedPassword"),
            requiredData.get("flowId"),
            requiredData.get("actionToken")));
    return request;
  }

  private void addHeaders(String xSessionId) throws ScriptException, NoSuchMethodException {
    addTargetRequestsHeaders(requestHeaders);
    requestHeaders.put("X-Session-Id", xSessionId);
    requestId = CryptoEngine.getRequestId() + "_1(4)_u(191)";
    requestHeaders.put("X-Request-Id", requestId);
  }

  private void addPayload(JSONObject dataPayload) throws ScriptException, NoSuchMethodException {
    requestHeaders.put("X-Ian-Zito", CryptoEngine.getIanZitoHash(dataPayload.toJSONString()));
    request.setAdditionalHeaders(requestHeaders);
    request.setRequestBody(dataPayload.toJSONString());
  }

  private JSONObject createPasswordCredentialPayload(String maskedPassword, String flowId, String actionToken) throws ScriptException, NoSuchMethodException {
    JSONObject dataPayload = new JSONObject();
    String passwordHash = CryptoEngine.getPasswordHash(maskedPassword);
    JSONObject requestFieldPayload = new JSONObject();
    requestFieldPayload.put("action", "OK");
    requestFieldPayload.put("password", passwordHash);
    requestFieldPayload.put("flow_id", flowId);
    requestFieldPayload.put("action_token", actionToken);
    dataPayload.put("request", requestFieldPayload);
    addAgentDataToPayload(dataPayload, requestId);
    return dataPayload;
  }
}
