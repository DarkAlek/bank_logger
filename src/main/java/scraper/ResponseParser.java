package scraper;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.HashMap;

public interface ResponseParser {

    JSONObject stringResponseToJsonResponse(String stringResponse) throws ParseException;
    void gatherRequiredResponseData();
}
