package scraper.unit.parser;

import com.gargoylesoftware.htmlunit.WebResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class LoginResponseParser {

  private final JSONObject responseJsonObject;


  public LoginResponseParser(WebResponse loginResponse) throws ParseException {
    this.responseJsonObject = stringResponseToJsonResponse(loginResponse.getContentAsString());
  }

  private static JSONObject stringResponseToJsonResponse(String stringResponse) throws ParseException {
    JSONParser jsonParser = new JSONParser();
    return (JSONObject) jsonParser.parse(stringResponse);
  }

  public String extractMaskedPassword(String password){
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


  public String extractFlowId() {
    JSONObject replyJsonField = (JSONObject) responseJsonObject.get("reply");
    return replyJsonField.get("flow_id").toString();
  }

  public String extractActionToken() {
    JSONObject replyJsonField = (JSONObject) responseJsonObject.get("reply");
    return replyJsonField.get("action_token").toString();
  }

}
