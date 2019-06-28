package scraper;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class CryptoEngine {

    private ScriptEngineManager manager = new ScriptEngineManager();
    private ScriptEngine engine;
    private Invocable invocable;

    public CryptoEngine() throws FileNotFoundException, ScriptException {
        engine = manager.getEngineByName("JavaScript");
        String file = getClass().getClassLoader().getResource("javascript_method_provider.js").getFile();
        Reader reader = new FileReader(file);
        engine.eval(reader);
        invocable = (Invocable) engine;
    }

    public String getPasswordHash(String password) throws ScriptException, NoSuchMethodException {
        Object passwordHash = invocable.invokeFunction("get_password_hash", password);
        return passwordHash.toString();
    }

    public String getIanZitoHash(String requestPayload) throws ScriptException, NoSuchMethodException {
        Object ianZitoHash = invocable.invokeFunction("get_ian_zito", requestPayload);
        return ianZitoHash.toString();
    }

    public String getRequestId() throws ScriptException, NoSuchMethodException {
        Object requestId = invocable.invokeFunction("get_request_id");
        return requestId.toString();
    }



}
