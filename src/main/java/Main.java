
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import models.Account;
import org.json.simple.parser.ParseException;
import scraper.CryptoEngine;
import scraper.TmobileScraper;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static scraper.Credentials.STATIC_LOGIN;
import static scraper.Credentials.STATIC_PASSWORD;

class Main {
  public static void main(String[] args){
    final WebClient client = initClient();
    final TmobileScraper scraper = new TmobileScraper(STATIC_LOGIN, STATIC_PASSWORD, client);  // here login and password to your account :D
    try{
      CryptoEngine.setInvocable(initInvocableEngine());
      List<Account> accounts = scrapeAccountData(scraper);
      printAccountInformationData(accounts);
    }
    catch(ParseException|IOException|ScriptException|NoSuchMethodException|FailingHttpStatusCodeException|NullPointerException e){
      if(e instanceof IOException)
        System.out.println("ERROR: Problem with request sending or file reading");
      if(e instanceof  ParseException)
        System.out.println("ERROR: Problem with JSON parsing");
      if(e instanceof ScriptException || e instanceof NoSuchMethodException)
        System.out.println("ERROR: Problem with javascript execution");
      if(e instanceof FailingHttpStatusCodeException)
        System.out.println("ERROR: Failing http status code [" + ((FailingHttpStatusCodeException) e).getStatusCode() + "]");
      if(e instanceof NullPointerException)
        System.out.println("ERROR: Probably problem with gathering data from response [e.g. wrong credentials]");
      e.printStackTrace();
    }
  }

  private static WebClient initClient() {
    WebClient client = new WebClient();
    client.getOptions().setCssEnabled(false);
    client.getOptions().setJavaScriptEnabled(false);
    client.getCookieManager().setCookiesEnabled(true);
    client.getOptions().setTimeout(1000000);
    return client;
  }

  private static Invocable initInvocableEngine() throws FileNotFoundException, ScriptException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    String file = Objects.requireNonNull(CryptoEngine.class.getClassLoader().getResource("javascript_method_provider.js")).getFile();
    Reader reader = new FileReader(file);
    engine.eval(reader);
    return (Invocable) engine;
  }

  private static List<Account> scrapeAccountData(TmobileScraper scraper) throws NoSuchMethodException, ScriptException, IOException, ParseException {
    scraper.enterLoginSite();
    HashMap<String, String> requiredData =  scraper.enterLoginCredentials();
    return scraper.enterPasswordCredentials(requiredData);
  }


  private static void printAccountInformationData(List<Account> accounts) throws NullPointerException {
    System.out.println(accounts);
  }
}
