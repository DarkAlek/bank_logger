package scraper.requestbuilders;

import com.gargoylesoftware.htmlunit.WebRequest;
import org.json.simple.JSONObject;
import scraper.CryptoEngine;

import javax.script.ScriptException;
import java.util.Map;

abstract class RequestBuilder {

  static final String BASE_URL = "https://system.t-mobilebankowe.pl";
  WebRequest request;

  protected void addHeaders() throws ScriptException, NoSuchMethodException {}
  protected void addPayload() throws ScriptException, NoSuchMethodException {}
  public WebRequest buildRequest() throws ScriptException, NoSuchMethodException {
    return request;
  }

  static void addInitRequestsHeaders(Map<String, String> requestHeaders){
    requestHeaders.put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0");
    requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    requestHeaders.put("Accept-Language", "en-US,en;q=0.5");
    requestHeaders.put("Connection", "keep-alive");
    requestHeaders.put("Origin", "https://system.t-mobilebankowe.pl");
    requestHeaders.put("Content-Type", "application/json; charset=utf-8");
    requestHeaders.put("Referer", "https://system.t-mobilebankowe.pl/");
    requestHeaders.put("X-Channel-Id", "WWW");
    requestHeaders.put("X-Device-Id", "www-vyQpZD6iic_6OFv3fXJF9HvZ12s");
    requestHeaders.put("X-Client-Time", CryptoEngine.getClientTime());
  }

  static void addTargetRequestsHeaders(Map<String, String> requestHeaders){
    requestHeaders.put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0");
    requestHeaders.put("Accept", "*/*");
    requestHeaders.put("Accept-Language", "en-US,en;q=0.5");
    requestHeaders.put("Referer", "https://system.t-mobilebankowe.pl/");
    requestHeaders.put("Content-Type", "application/json; charset=utf-8");
    requestHeaders.put("X-Channel-Id", "WWW");
    requestHeaders.put("X-Device-Id", "www-vyQpZD6iic_6OFv3fXJF9HvZ12s");
    requestHeaders.put("X-Client-Time", CryptoEngine.getClientTime());
    requestHeaders.put("Origin", "https://system.t-mobilebankowe.pl");
    requestHeaders.put("Connection", "keep-alive");
  }

  static void addAgentDataToPayload(JSONObject dataPayload, String requestId){
    JSONObject requestFieldAgent = new JSONObject();
    requestFieldAgent.put("screen_width", 1855);
    requestFieldAgent.put("app_version", "1.35.306.5");
    requestFieldAgent.put("request_id", requestId);
    dataPayload.put("agent", requestFieldAgent);
  }

}
