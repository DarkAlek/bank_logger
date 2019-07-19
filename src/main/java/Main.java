
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import models.Account;
import org.json.simple.parser.ParseException;
import scraper.CryptoEngine;
import scraper.InitTool;
import scraper.TmobileScraper;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static scraper.Credentials.STATIC_LOGIN;
import static scraper.Credentials.STATIC_PASSWORD;

class Main {
  public static void main(String[] args){
    final WebClient client = InitTool.initClient();
    final TmobileScraper scraper = new TmobileScraper(STATIC_LOGIN, STATIC_PASSWORD, client);  // here login and password to your account :D
    try{
      CryptoEngine.setInvocable(InitTool.initInvocableEngine());
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

  private static List<Account> scrapeAccountData(TmobileScraper scraper) throws NoSuchMethodException, ScriptException, IOException, ParseException {
    scraper.enterLoginSite();
    HashMap<String, String> requiredData =  scraper.enterLoginCredentials();
    return scraper.enterPasswordCredentials(requiredData);
  }


  private static void printAccountInformationData(List<Account> accounts) throws NullPointerException {
    System.out.println(accounts);
  }

}
