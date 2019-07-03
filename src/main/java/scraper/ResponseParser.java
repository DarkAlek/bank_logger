package scraper;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

interface ResponseParser {

    JSONObject stringResponseToJsonResponse(String stringResponse) throws ParseException;
    void gatherRequiredResponseData();
}
