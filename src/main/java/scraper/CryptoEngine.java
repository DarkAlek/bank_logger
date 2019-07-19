package scraper;

import javax.script.Invocable;
import javax.script.ScriptException;

public class CryptoEngine {

  private static Invocable invocable;

  public static String getPasswordHash(String password) throws ScriptException, NoSuchMethodException {
    Object passwordHash = getInvocable().invokeFunction("get_password_hash", password);
    return passwordHash.toString();
  }

  public static String getIanZitoHash(String requestPayload) throws ScriptException, NoSuchMethodException {
    Object ianZitoHash = getInvocable().invokeFunction("get_ian_zito", requestPayload);
    return ianZitoHash.toString();
  }

  public static String getRequestId() throws ScriptException, NoSuchMethodException {
    Object requestId = getInvocable().invokeFunction("get_request_id");
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


  public static Invocable getInvocable() {
    return invocable;
  }

  public static void setInvocable(Invocable invocable) {
    CryptoEngine.invocable = invocable;
  }
}
