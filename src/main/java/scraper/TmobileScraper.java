package scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import org.json.simple.parser.ParseException;

import javax.script.ScriptException;
import java.io.IOException;

public class TmobileScraper {

    private final WebClient client = new WebClient();
    private ResponseParser responseParser;
    private final String login;
    private final String password;


    public TmobileScraper(String login, String password){
        this.login = login;
        this.password = password;
        this.client.getOptions().setCssEnabled(false);
        this.client.getOptions().setJavaScriptEnabled(false);
        this.client.getCookieManager().setCookiesEnabled(true);
        this.client.getOptions().setTimeout(1000000);

    }

    public void enterLoginSite() throws IOException, ScriptException, NoSuchMethodException {
        WebRequest baseSiteRequest = RequestBuilder.createBaseSiteRequest();
        WebRequest campaignGetSiteRequest = RequestBuilder.createCampaignGetSiteRequest();
        WebRequest configSiteRequest = RequestBuilder.createConfigSiteRequest();
        client.getPage(baseSiteRequest).getWebResponse();
        client.getPage(campaignGetSiteRequest).getWebResponse();
        client.getPage(configSiteRequest).getWebResponse();
    }

    public void enterLoginCredentials() throws IOException, ParseException, ScriptException, NoSuchMethodException {
        WebRequest enterLoginCredentialsRequest = RequestBuilder.createLoginCredentialRequest(login);
        WebResponse enterLoginCredentialsResponse = client.getPage(enterLoginCredentialsRequest).getWebResponse();
        responseParser = new LoginResponseParser(enterLoginCredentialsResponse, password);
    }

    public void enterPasswordCredentials() throws IOException, ParseException, ScriptException, NoSuchMethodException {
        responseParser.gatherRequiredResponseData();
        WebRequest enterPasswordCredentialsRequest = RequestBuilder.createPasswordCredentialRequest(((LoginResponseParser)responseParser).responseRequiredData);
        WebResponse enterPasswordCredentialsResponse = client.getPage(enterPasswordCredentialsRequest).getWebResponse();
        responseParser = new PasswordResponseParser(enterPasswordCredentialsResponse);
    }

    public void printAccountInformationData() throws NullPointerException {
        responseParser.gatherRequiredResponseData();
        System.out.println(((PasswordResponseParser)responseParser).accountsFinalData);
    }

}
