package scraper;

import com.gargoylesoftware.htmlunit.WebClient;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TmobileScraperTest {

    WebClient client = initClient();
    TmobileScraper scraper = new TmobileScraper("9234901", "testtesttesttesttesttesttest", client);

    @Test
    public void enterLoginSite() throws NoSuchMethodException, ScriptException, IOException {
        String statusCodes = scraper.enterLoginSite();
        assertEquals("200200200", statusCodes);
    }

    @Test
    public void enterLoginCredentials() throws NoSuchMethodException, ScriptException, ParseException, IOException {
        HashMap<String, String> requiredData = scraper.enterLoginCredentials();
        assertEquals("[xSessionId, maskedPassword, actionToken, flowId]", requiredData.keySet().toString());


    }

    private static WebClient initClient() {
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        client.getCookieManager().setCookiesEnabled(true);
        client.getOptions().setTimeout(1000000);
        return client;
    }
}