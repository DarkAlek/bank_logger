package scraper.parser;

import com.gargoylesoftware.htmlunit.WebResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AccountResponseParser {

  private final JSONObject responseJsonObject;

  public AccountResponseParser(WebResponse passwordResponse) throws ParseException {
    this.responseJsonObject = stringResponseToJsonResponse(passwordResponse.getContentAsString());
  }

  private static JSONObject stringResponseToJsonResponse(String stringResponse) throws ParseException {
    JSONParser jsonParser = new JSONParser();
    return (JSONObject) jsonParser.parse(stringResponse);
  }

  public static String extractAccountName(JSONObject account) {
    return account.get("account_name").toString().trim();
  }

  public static String extractAccountBalance(JSONObject account) {
    JSONObject balances = (JSONObject) account.get("balance");
    return balances.get("avail").toString().trim();
  }

  public static String extractAccountCurrency(JSONObject account) {
    return account.get("curr").toString().trim();
  }

  public static String extractAccountNumber(JSONObject account) {
    return account.get("number").toString().trim();
  }

  public static String extractAccountOpenDate(JSONObject account) {
    return account.get("open_date").toString().trim();
  }

  public static String extractAccountDescription(JSONObject account) {
    return account.get("account_category_description").toString().trim();
  }

  public static String extractAccountOwner(JSONObject account) {
    return account.get("owner_name").toString().trim().replaceAll(" +", " ");
  }


  public JSONArray extractAccountsList() {
    JSONObject globalData = (JSONObject) responseJsonObject.get("globals");
    JSONObject accountsData = (JSONObject) globalData.get("accounts");
    return (JSONArray) accountsData.get("added");
  }

}
