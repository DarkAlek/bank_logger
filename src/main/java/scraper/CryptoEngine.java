package scraper;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Objects;

public class CryptoEngine {

  private static Invocable invocable = null;

  static {
    try {
      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine engine = manager.getEngineByName("JavaScript");
      String file = Objects.requireNonNull(CryptoEngine.class.getClassLoader().getResource("javascript_method_provider.js")).getFile();
      Reader reader = new FileReader(file);
      engine.eval(reader);
      invocable = (Invocable) engine;
    } catch (FileNotFoundException|ScriptException e) {
      System.out.println("ERROR: Problem with CryptoEngine initialization");
      e.printStackTrace();
      System.exit(0);
    }
  }

  public static String getPasswordHash(String password) throws ScriptException, NoSuchMethodException {
    Object passwordHash = invocable.invokeFunction("get_password_hash", password);
    return passwordHash.toString();
  }

  public static String getIanZitoHash(String requestPayload) throws ScriptException, NoSuchMethodException {
    Object ianZitoHash = invocable.invokeFunction("get_ian_zito", requestPayload);
    return ianZitoHash.toString();
  }

  public static String getRequestId() throws ScriptException, NoSuchMethodException {
    Object requestId = invocable.invokeFunction("get_request_id");
    return requestId.toString();
  }

  public static String getClientTime(){
    String unixTime = String.format("%.3f", System.currentTimeMillis()/1000.0);
    if(checkIfZeroLastCharacter(unixTime)){
      unixTime = removeZeroLastCharacter(unixTime);
    }
    return unixTime;
  }

  private static boolean checkIfZeroLastCharacter(String unixTime) {
    return unixTime.charAt(unixTime.length() - 1) == '0';
  }

  private static String removeZeroLastCharacter(String unixTime) {
    return unixTime.substring(0, unixTime.length() - 2);
  }


}
