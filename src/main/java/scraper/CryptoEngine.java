package scraper;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

class CryptoEngine {

    private Invocable invocable;

    CryptoEngine() throws FileNotFoundException, ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String file = getClass().getClassLoader().getResource("javascript_method_provider.js").getFile();
        Reader reader = new FileReader(file);
        engine.eval(reader);
        invocable = (Invocable) engine;
    }

    String getPasswordHash(String password) throws ScriptException, NoSuchMethodException {
        Object passwordHash = invocable.invokeFunction("get_password_hash", password);
        return passwordHash.toString();
    }

    String getIanZitoHash(String requestPayload) throws ScriptException, NoSuchMethodException {
        Object ianZitoHash = invocable.invokeFunction("get_ian_zito", requestPayload);
        return ianZitoHash.toString();
    }

    String getRequestId() throws ScriptException, NoSuchMethodException {
        Object requestId = invocable.invokeFunction("get_request_id");
        return requestId.toString();
    }

    String getClientTime(){
        String unixTime = String.format("%.3f", System.currentTimeMillis()/1000.0);
        if(unixTime.charAt(unixTime.length() - 1) == '0'){
            unixTime = unixTime.substring(0, unixTime.length() - 1);
        }
        return unixTime;
    }



}
