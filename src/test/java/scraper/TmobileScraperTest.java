package scraper;

import models.Account;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static scraper.Credentials.STATIC_LOGIN;
import static scraper.Credentials.STATIC_PASSWORD;

public class TmobileScraperTest extends BaseScraperTest {

  private final TmobileScraper scraper = new TmobileScraper(STATIC_LOGIN, STATIC_PASSWORD, client);
  private HashMap<String, String> requiredData;

  @Before
  public void init() throws FileNotFoundException, ScriptException {
    CryptoEngine.setInvocable(initInvocableEngine());
  }

  @Test
  public void enterLoginSite() throws NoSuchMethodException, ScriptException, IOException {
    String statusCodes = scraper.enterLoginSite();
    assertEquals("200200200", statusCodes);
  }

  @Test
  public void enterLoginCredentials() throws NoSuchMethodException, ScriptException, ParseException, IOException {
    scraper.enterLoginSite();
    requiredData = scraper.enterLoginCredentials();
    assertEquals("[xSessionId, maskedPassword, actionToken, flowId]", requiredData.keySet().toString());
    assertNotNull(requiredData.get("xSessionId"));
    assertNotNull(requiredData.get("maskedPassword"));
    assertNotNull(requiredData.get("actionToken"));
    assertNotNull(requiredData.get("flowId"));

  }

  @Test
  public void enterPasswordCredentials() throws NoSuchMethodException, ScriptException, ParseException, IOException {
    if(requiredData == null){
      scraper.enterLoginSite();
      requiredData = scraper.enterLoginCredentials();
    }
    List<Account> accounts = scraper.enterPasswordCredentials(requiredData);
    assertNotNull(accounts);
    assertTrue(accounts.size() > 0);
    assertNotNull(accounts.get(0).accountName);
    assertNotNull(accounts.get(0).accountBalance);
    assertNotNull(accounts.get(0).accountCurrency);
    assertNotNull(accounts.get(0).accountNumber);
    assertNotNull(accounts.get(0).accountOpenDate);
    assertNotNull(accounts.get(0).accountDescription);
    assertNotNull(accounts.get(0).accountOwner);
  }
}