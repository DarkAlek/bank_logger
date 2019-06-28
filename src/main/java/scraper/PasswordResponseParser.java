package scraper;

import com.gargoylesoftware.htmlunit.WebResponse;
import models.Account;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class PasswordResponseParser implements ResponseParser{

    private final JSONObject responseJsonObject;
    private JSONArray addedAccountsList;
    public List<Account> accountsFinalData = new ArrayList<>();


    public PasswordResponseParser(WebResponse passwordResponse) throws ParseException {
        this.responseJsonObject = stringResponseToJsonResponse(passwordResponse.getContentAsString());
    }


    public JSONObject stringResponseToJsonResponse(String stringResponse) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(stringResponse);
    }

    public void gatherRequiredResponseData() {
        extractAccountsList();
        for (Object item : addedAccountsList) {
            JSONObject jsonItem = (JSONObject) item;
            accountsFinalData.add(new Account(
                    extractAccountName(jsonItem),
                    extractAccountBalance(jsonItem),
                    extractAccountCurrency(jsonItem),
                    extractAccountNumber(jsonItem),
                    extractAccountOpenDate(jsonItem),
                    extractAccountDescription(jsonItem),
                    extractAccountOwner(jsonItem)));
        }
    }

    private String extractAccountName(JSONObject jsonItem) {
        return jsonItem.get("account_name").toString().trim();
    }

    private String extractAccountBalance(JSONObject jsonItem) {
        JSONObject balances = (JSONObject) jsonItem.get("balance");
        return balances.get("avail").toString().trim();
    }

    private String extractAccountCurrency(JSONObject jsonItem) {
        return jsonItem.get("curr").toString().trim();
    }

    private String extractAccountNumber(JSONObject jsonItem) {
        return jsonItem.get("number").toString().trim();
    }

    private String extractAccountOpenDate(JSONObject jsonItem) {
        return jsonItem.get("open_date").toString().trim();
    }

    private String extractAccountDescription(JSONObject jsonItem) {
        return jsonItem.get("account_category_description").toString().trim();
    }

    private String extractAccountOwner(JSONObject jsonItem) {
        return jsonItem.get("owner_name").toString().trim().replaceAll(" +", " ");
    }


    private void extractAccountsList() {
        JSONObject globalData = (JSONObject) responseJsonObject.get("globals");
        JSONObject accountsData = (JSONObject) globalData.get("accounts");
        addedAccountsList = (JSONArray) accountsData.get("added");
    }

}
