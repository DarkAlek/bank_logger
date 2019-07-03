package scraper.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public interface ResponseParser {

    JSONObject stringResponseToJsonResponse(String stringResponse) throws ParseException;
    void gatherRequiredResponseData();
}
