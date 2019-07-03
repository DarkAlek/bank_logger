package scraper;

import com.gargoylesoftware.htmlunit.WebResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;

public class LoginResponseParser implements ResponseParser {

    private final WebResponse loginResponse;
    private final JSONObject responseJsonObject;
    private final String password;
    public final HashMap<String, String> responseRequiredData = new HashMap<>();


    public LoginResponseParser(WebResponse loginResponse, String password) throws ParseException {
        this.loginResponse = loginResponse;
        this.responseJsonObject = stringResponseToJsonResponse(loginResponse.getContentAsString());
        this.password = password;
    }

    public JSONObject stringResponseToJsonResponse(String stringResponse) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(stringResponse);
    }

    public void gatherRequiredResponseData(){
        responseRequiredData.put("maskedPassword", extractMaskedPassword());
        responseRequiredData.put("flowId", extractFlowId());
        responseRequiredData.put("actionToken", extractActionToken());
        responseRequiredData.put("xSessionId", extractXSessionId());
    }

    private String extractMaskedPassword(){
        StringBuilder maskedPassword = new StringBuilder();
        JSONArray maskedArray = extractMaskedArrayFromJsonObject();
        for (Object item : maskedArray) {
            Long itemLong = (Long) item;
            maskedPassword.append(password.charAt(itemLong.intValue()));
        }
        return maskedPassword.toString();
    }

    private JSONArray extractMaskedArrayFromJsonObject(){
        JSONObject replyJsonField = (JSONObject) responseJsonObject.get("reply");
        return (JSONArray) replyJsonField.get("password_mask");
    }


    private String extractFlowId() {
        JSONObject replyJsonField = (JSONObject) responseJsonObject.get("reply");
        return replyJsonField.get("flow_id").toString();
    }

    private String extractActionToken() {
        JSONObject replyJsonField = (JSONObject) responseJsonObject.get("reply");
        return replyJsonField.get("action_token").toString();
    }

    private String extractXSessionId() {
        return loginResponse.getResponseHeaderValue("X-Session-Id");
    }

}
