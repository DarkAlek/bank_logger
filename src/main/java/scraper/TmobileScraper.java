package scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import models.Account;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import scraper.parser.LoginResponseParser;
import scraper.parser.AccountResponseParser;
import scraper.requestbuilders.*;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TmobileScraper {

  private final WebClient client;
  private final String login;
  private final String password;


  public TmobileScraper(String login, String password, WebClient client){
    this.login = login;
    this.password = password;
    this.client = client;
  }

  public String enterLoginSite() throws IOException, ScriptException, NoSuchMethodException {
    WebRequest baseSiteRequest = (new BaseSiteRequest()).buildRequest();
    WebRequest campaignGetSiteRequest = (new CampaignGetSiteRequest()).buildRequest();
    WebRequest configSiteRequest = (new ConfigSiteRequest()).buildRequest();
    return String.valueOf(client.getPage(baseSiteRequest).getWebResponse().getStatusCode()) +
            client.getPage(campaignGetSiteRequest).getWebResponse().getStatusCode() +
            client.getPage(configSiteRequest).getWebResponse().getStatusCode();
  }

  public HashMap<String, String> enterLoginCredentials() throws IOException, ParseException, ScriptException, NoSuchMethodException {
    WebRequest enterLoginCredentialsRequest = (new LoginCredentialRequest()).buildRequest(login);
    WebResponse enterLoginCredentialsResponse = client.getPage(enterLoginCredentialsRequest).getWebResponse();
    return extractRequiredLoginResponseData(enterLoginCredentialsResponse);
  }

  public List<Account> enterPasswordCredentials(HashMap<String, String> requiredData) throws IOException, ParseException, ScriptException, NoSuchMethodException {
    WebRequest enterPasswordCredentialsRequest = (new PasswordCredentialRequest()).buildRequest(requiredData);
    WebResponse enterPasswordCredentialsResponse = client.getPage(enterPasswordCredentialsRequest).getWebResponse();
    return extractRequiredAccountResponseData(enterPasswordCredentialsResponse);
  }

  private HashMap<String, String> extractRequiredLoginResponseData(WebResponse enterLoginCredentialsResponse) throws ParseException {
    HashMap<String, String> responseRequiredData = new HashMap<>();
    LoginResponseParser responseParser = new LoginResponseParser(enterLoginCredentialsResponse);
    responseRequiredData.put("maskedPassword", responseParser.extractMaskedPassword(password));
    responseRequiredData.put("flowId", responseParser.extractFlowId());
    responseRequiredData.put("actionToken", responseParser.extractActionToken());
    responseRequiredData.put("xSessionId", enterLoginCredentialsResponse.getResponseHeaderValue("X-Session-Id"));
    return responseRequiredData;
  }

  private static List<Account> extractRequiredAccountResponseData(WebResponse enterPasswordCredentialsResponse) throws ParseException {
    List<Account> accountsFinalData = new ArrayList<>();
    AccountResponseParser responseParser = new AccountResponseParser(enterPasswordCredentialsResponse);
    JSONArray addedAccountsList = responseParser.extractAccountsList();
    for (Object account : addedAccountsList) {
      JSONObject jsonAccount = (JSONObject) account;
      accountsFinalData.add(new Account(
        AccountResponseParser.extractAccountName(jsonAccount),
        AccountResponseParser.extractAccountBalance(jsonAccount),
        AccountResponseParser.extractAccountCurrency(jsonAccount),
        AccountResponseParser.extractAccountNumber(jsonAccount),
        AccountResponseParser.extractAccountOpenDate(jsonAccount),
        AccountResponseParser.extractAccountDescription(jsonAccount),
        AccountResponseParser.extractAccountOwner(jsonAccount)));
    }
    return accountsFinalData;
  }


}
