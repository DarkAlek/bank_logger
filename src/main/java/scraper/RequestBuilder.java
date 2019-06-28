package scraper;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.json.simple.JSONObject;

import javax.script.ScriptException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestBuilder {


    // create two before requests: campaign_get and config OK
    // make request_id random (maybe better inside javascript) OK
    // make client-time real OK
    // make seed inside javascript random OK

    private static CryptoEngine cryptoEngine;

    static {
        try {
            cryptoEngine = new CryptoEngine();
        } catch (Exception e) {
            System.out.println("ERROR: Problem with CryptoEngine initialization");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static WebRequest createBaseSiteRequest() throws MalformedURLException {
        URL uri = new URL(new URL(Consts.BASE_URL) , "web/login");
        WebRequest request = new WebRequest(uri, HttpMethod.GET);
        Map<String, String> requestHeaders = new LinkedHashMap<>();
        requestHeaders.put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0");
        requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        requestHeaders.put("Accept-Language", "en-US,en;q=0.5");
        requestHeaders.put("Connection", "keep-alive");
        request.setAdditionalHeaders(requestHeaders);
        return request;
    }

    public static WebRequest createCampaignGetSiteRequest() throws MalformedURLException, ScriptException, NoSuchMethodException {
        URL uri = new URL(new URL(Consts.BASE_URL) , "tmub/api/campaign_get");
        WebRequest request = new WebRequest(uri, HttpMethod.POST);
        Map<String, String> requestHeaders = new LinkedHashMap<>();
        requestHeaders.put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0");
        requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        requestHeaders.put("Accept-Language", "en-US,en;q=0.5");
        requestHeaders.put("Connection", "keep-alive");
        requestHeaders.put("Origin", "https://system.t-mobilebankowe.pl");
        requestHeaders.put("Content-Type", "application/json; charset=utf-8");
        requestHeaders.put("Referer", "https://system.t-mobilebankowe.pl/");
        requestHeaders.put("X-Channel-Id", "WWW");
        requestHeaders.put("X-Device-Id", "www-vyQpZD6iic_6OFv3fXJF9HvZ12s");
        String requestId = cryptoEngine.getRequestId() + "_1(1)_u(203)";
        requestHeaders.put("X-Request-Id", requestId  + "_1(1)_u(203)");
        requestHeaders.put("X-Client-Time", getClientTime());
        request.setAdditionalHeaders(requestHeaders);

        String dataPayload =  "{\"request\":{\"component_list\":[{\"component_id\":\"1\"},{\"component_id\":\"999999999\"}]},\"agent\":{\"screen_width\":1855,\"app_version\":\"1.35.306.5\",\"request_id\":\"" + requestId + "\"}}";

        request.setRequestBody(dataPayload);
        return request;
    }

    public static WebRequest createConfigSiteRequest() throws MalformedURLException, ScriptException, NoSuchMethodException {
        URL uri = new URL(new URL(Consts.BASE_URL) , "tmub/api/config");
        WebRequest request = new WebRequest(uri, HttpMethod.POST);
        Map<String, String> requestHeaders = new LinkedHashMap<>();
        requestHeaders.put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0");
        requestHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        requestHeaders.put("Accept-Language", "en-US,en;q=0.5");
        requestHeaders.put("Connection", "keep-alive");
        requestHeaders.put("Origin", "https://system.t-mobilebankowe.pl");
        requestHeaders.put("Content-Type", "application/json; charset=utf-8");
        requestHeaders.put("Referer", "https://system.t-mobilebankowe.pl/");
        requestHeaders.put("X-Channel-Id", "WWW");
        requestHeaders.put("X-Device-Id", "www-vyQpZD6iic_6OFv3fXJF9HvZ12s");
        String requestId = cryptoEngine.getRequestId() + "_1(2)_u(39)";
        requestHeaders.put("X-Request-Id", requestId);
        requestHeaders.put("X-Client-Time", getClientTime());
        request.setAdditionalHeaders(requestHeaders);

        String dataPayload =  "{\"request\":{\"flags\":[\"PREPAID-TOPUP\",\"DEPOSIT\",\"DEPONENT-INFO\",\"PAYCARD-LAYOUTS\",\"MONEY-BOX\",\"CLIENT-DETAILS\",\"AGREEMENTS\",\"HISTORY\",\"LEADS\",\"LOAN\",\"TRANSFER\",\"INTEREST\",\"EU-COUNTRY-LIST\",\"COUNTRY-LIST\",\"COUNTRY-EOG\",\"COUNTRY-INFO-LIST\",\"BALANCE-AUTOFILL-INFO\",\"INBOX\",\"PREVIOUS-VERSION-LINK-POSITION\",\"PBL-BFO-MIGRATION\",\"INFO-COMPONENTS\",\"TRANSFER-ZUS-DICT\",\"ACCOUNT-HISTORY-EXPORT\",\"LOGOUT-IFRAME\",\"FATCA\"]},\"agent\":{\"screen_width\":1855,\"app_version\":\"1.35.306.5\",\"request_id\":\"" + requestId + "\"}}";

        request.setRequestBody(dataPayload);
        return request;
    }



    public static WebRequest createLoginCredentialRequest(String login) throws MalformedURLException, ScriptException, NoSuchMethodException {
        URL uri = new URL(new URL(Consts.BASE_URL) , "tmub/api/customer_web_login/prepare");
        WebRequest request = new WebRequest(uri, HttpMethod.POST);
        Map<String, String> requestHeaders = new LinkedHashMap<>();
        requestHeaders.put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0");
        requestHeaders.put("Accept", "*/*");
        requestHeaders.put("Accept-Language", "en-US,en;q=0.5");
        requestHeaders.put("Referer", "https://system.t-mobilebankowe.pl/");
        requestHeaders.put("X-Ian-Zito", "iVnsT+s5XwHSzBXmmKYLSwSqUBqbXsTZ0GraydZqaqo=");
        requestHeaders.put("Content-Type", "application/json; charset=utf-8");
        requestHeaders.put("X-Channel-Id", "WWW");
        String requestId = cryptoEngine.getRequestId() + "_1(3)_u(189)";
        requestHeaders.put("X-Request-Id", requestId);
        requestHeaders.put("X-Device-Id", "www-vyQpZD6iic_6OFv3fXJF9HvZ12s");
        requestHeaders.put("X-Client-Time", getClientTime());
        requestHeaders.put("Origin", "https://system.t-mobilebankowe.pl");
        requestHeaders.put("DNT", "1");
        requestHeaders.put("Connection", "keep-alive");
        request.setAdditionalHeaders(requestHeaders);

        JSONObject dataPayload = new JSONObject();
        JSONObject requestFieldPayload = new JSONObject();
        requestFieldPayload.put("login", login);
        requestFieldPayload.put("action", "OK");
        requestFieldPayload.put("host", "system.t-mobilebankowe.pl");
        JSONObject requestFieldAgent = new JSONObject();
        requestFieldAgent.put("screen_width", 1855);
        requestFieldAgent.put("app_version", "1.35.306.5");
        requestFieldAgent.put("request_id", requestId);

        dataPayload.put("request", requestFieldPayload );
        dataPayload.put("agent", requestFieldAgent);

        request.setRequestBody(dataPayload.toJSONString());
        return request;
    }

    public static WebRequest createPasswordCredentialRequest(HashMap<String, String> requiredData) throws MalformedURLException, ScriptException, NoSuchMethodException {
        URL uri = new URL(new URL(Consts.BASE_URL) , "tmub/api/customer_web_login/password_masked");
        WebRequest request = new WebRequest(uri, HttpMethod.POST);
        Map<String, String> requestHeaders = new LinkedHashMap<>();
        requestHeaders.put("Accept", "*/*");
        requestHeaders.put("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:67.0) Gecko/20100101 Firefox/67.0");
        requestHeaders.put("Accept-Language", "en-US,en;q=0.5");
        requestHeaders.put("Referer", "https://system.t-mobilebankowe.pl/");
        requestHeaders.put("Content-Type", "application/json; charset=utf-8");
        requestHeaders.put("X-Session-Id", requiredData.get("xSessionId"));
        requestHeaders.put("X-Channel-Id", "WWW");
        String requestId = cryptoEngine.getRequestId() + "_1(4)_u(191)";
        requestHeaders.put("X-Request-Id", requestId);
        requestHeaders.put("X-Device-Id", "www-vyQpZD6iic_6OFv3fXJF9HvZ12s");
        requestHeaders.put("X-Client-Time", getClientTime());
        requestHeaders.put("Origin", "https://system.t-mobilebankowe.pl");
        requestHeaders.put("Connection", "keep-alive");

        String passwordHash = cryptoEngine.getPasswordHash(requiredData.get("maskedPassword"));

        JSONObject dataPayload = new JSONObject();
        JSONObject requestFieldPayload = new JSONObject();
        requestFieldPayload.put("action", "OK");
        requestFieldPayload.put("password", passwordHash);
        requestFieldPayload.put("flow_id", requiredData.get("flowId"));
        requestFieldPayload.put("action_token", requiredData.get("actionToken"));
        JSONObject requestFieldAgent = new JSONObject();
        requestFieldAgent.put("screen_width", 1855);
        requestFieldAgent.put("app_version", "1.35.306.5");
        requestFieldAgent.put("request_id", requestId);

        dataPayload.put("request", requestFieldPayload );
        dataPayload.put("agent", requestFieldAgent);

        String ianZitoHash = cryptoEngine.getIanZitoHash(dataPayload.toJSONString());
        requestHeaders.put("X-Ian-Zito", ianZitoHash);
        request.setAdditionalHeaders(requestHeaders);

        request.setRequestBody(dataPayload.toJSONString());

        return request;
    }

    private static String getClientTime(){
        String unixTime = String.format("%.3f", System.currentTimeMillis()/1000.0);
        if(unixTime.charAt(unixTime.length() - 1) == '0'){
            unixTime = unixTime.substring(0, unixTime.length() - 1);
        }
        return unixTime;
    }
}