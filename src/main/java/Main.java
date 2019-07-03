
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import models.Account;
import org.json.simple.parser.ParseException;
import scraper.TmobileScraper;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        final WebClient client = initClient();
        final TmobileScraper scraper = new TmobileScraper("", "", client);  // here login and password to your account :D
        try{
            scraper.enterLoginSite();
            HashMap<String, String> requiredData =  scraper.enterLoginCredentials();
            List<Account> accounts = scraper.enterPasswordCredentials(requiredData);
            printAccountInformationData(accounts);
        }
        catch(ParseException|IOException|ScriptException|NoSuchMethodException|FailingHttpStatusCodeException|NullPointerException e){
            if(e instanceof IOException)
                System.out.println("ERROR: Problem with request sending");
            if(e instanceof  ParseException)
                System.out.println("ERROR: Problem with JSON parsing");
            if(e instanceof ScriptException || e instanceof NoSuchMethodException)
                System.out.println("ERROR: Problem with javascript execution");
            if(e instanceof FailingHttpStatusCodeException)
                System.out.println("ERROR: Failing http status code [" + ((FailingHttpStatusCodeException) e).getStatusCode() + "]");
            if(e instanceof NullPointerException)
                System.out.println("ERROR: Probably problem with gathering data from response");
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

    private static void printAccountInformationData(List<Account> accounts) throws NullPointerException {
        System.out.println(accounts);
    }
}
