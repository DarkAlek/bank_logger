package scraper;

import com.gargoylesoftware.htmlunit.WebClient;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Objects;

public class InitTool {

  public static WebClient initClient() {
    WebClient client = new WebClient();
    client.getOptions().setCssEnabled(false);
    client.getOptions().setJavaScriptEnabled(false);
    client.getCookieManager().setCookiesEnabled(true);
    client.getOptions().setTimeout(1000000);
    return client;
  }

  public static Invocable initInvocableEngine() throws FileNotFoundException, ScriptException {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    String file = Objects.requireNonNull(CryptoEngine.class.getClassLoader().getResource("javascript_method_provider.js")).getFile();
    Reader reader = new FileReader(file);
    engine.eval(reader);
    return (Invocable) engine;
  }

}
