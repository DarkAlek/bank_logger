package scraper.requestbuilders;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import scraper.CryptoEngine;

import javax.script.ScriptException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigSiteRequestBuilder extends RequestBuilder {

  private String requestId;

  public ConfigSiteRequestBuilder() throws MalformedURLException {
    URL uri = new URL(new URL(BASE_URL), "tmub/api/config");
    request = new WebRequest(uri, HttpMethod.POST);
  }


  @Override
  protected void addHeaders() throws ScriptException, NoSuchMethodException {
    Map<String, String> requestHeaders = new LinkedHashMap<>();
    addInitRequestsHeaders(requestHeaders);
    requestId = CryptoEngine.getRequestId() + "_1(2)_u(39)";
    requestHeaders.put("X-Request-Id", requestId);
    request.setAdditionalHeaders(requestHeaders);
  }

  @Override
  protected void addPayload() {
    String dataPayload = "{\"request\":{\"flags\":[\"PREPAID-TOPUP\",\"DEPOSIT\",\"DEPONENT-INFO\",\"PAYCARD-LAYOUTS\",\"MONEY-BOX\",\"CLIENT-DETAILS\",\"AGREEMENTS\",\"HISTORY\",\"LEADS\",\"LOAN\",\"TRANSFER\",\"INTEREST\",\"EU-COUNTRY-LIST\",\"COUNTRY-LIST\",\"COUNTRY-EOG\",\"COUNTRY-INFO-LIST\",\"BALANCE-AUTOFILL-INFO\",\"INBOX\",\"PREVIOUS-VERSION-LINK-POSITION\",\"PBL-BFO-MIGRATION\",\"INFO-COMPONENTS\",\"TRANSFER-ZUS-DICT\",\"ACCOUNT-HISTORY-EXPORT\",\"LOGOUT-IFRAME\",\"FATCA\"]},\"agent\":{\"screen_width\":1855,\"app_version\":\"1.35.306.5\",\"request_id\":\"" + requestId + "\"}}";
    request.setRequestBody(dataPayload);
  }

  @Override
  public WebRequest buildRequest() throws ScriptException, NoSuchMethodException {
    addHeaders();
    addPayload();
    return request;
  }
}
