
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import org.json.simple.parser.ParseException;
import scraper.TmobileScraper;

import javax.script.ScriptException;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        TmobileScraper scraper = new TmobileScraper("", "");
        try{
            scraper.enterLoginSite();
            scraper.enterLoginCredentials();
            scraper.enterPasswordCredentials();
            scraper.printAccountInformationData();
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
}
