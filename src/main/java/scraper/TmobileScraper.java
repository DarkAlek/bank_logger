package scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import models.Account;
import org.json.simple.parser.ParseException;
import scraper.parser.LoginResponseParser;
import scraper.parser.AccountResponseParser;
import scraper.parser.ResponseParser;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TmobileScraper {

    private final WebClient client;
    private ResponseParser responseParser;
    private final String login;
    private final String password;


    public TmobileScraper(String login, String password, WebClient client){
        this.login = login;
        this.password = password;
        this.client = client;
    }

    public void enterLoginSite() throws IOException, ScriptException, NoSuchMethodException {
        WebRequest baseSiteRequest = RequestBuilder.createBaseSiteRequest();
        WebRequest campaignGetSiteRequest = RequestBuilder.createCampaignGetSiteRequest();
        WebRequest configSiteRequest = RequestBuilder.createConfigSiteRequest();
        client.getPage(baseSiteRequest).getWebResponse();
        client.getPage(campaignGetSiteRequest).getWebResponse();
        client.getPage(configSiteRequest).getWebResponse();
    }

    public HashMap<String, String> enterLoginCredentials() throws IOException, ParseException, ScriptException, NoSuchMethodException {
        WebRequest enterLoginCredentialsRequest = RequestBuilder.createLoginCredentialRequest(login);
        WebResponse enterLoginCredentialsResponse = client.getPage(enterLoginCredentialsRequest).getWebResponse();
        responseParser = new LoginResponseParser(enterLoginCredentialsResponse, password);
        responseParser.gatherRequiredResponseData();
        return ((LoginResponseParser)responseParser).responseRequiredData;
    }

    public List<Account> enterPasswordCredentials(HashMap<String, String> requiredData) throws IOException, ParseException, ScriptException, NoSuchMethodException {
        WebRequest enterPasswordCredentialsRequest = RequestBuilder.createPasswordCredentialRequest(requiredData);
        WebResponse enterPasswordCredentialsResponse = client.getPage(enterPasswordCredentialsRequest).getWebResponse();
        responseParser = new AccountResponseParser(enterPasswordCredentialsResponse);
        responseParser.gatherRequiredResponseData();
        return ((AccountResponseParser)responseParser).accountsFinalData;
    }

}
