package scraper.unit.parser;

import com.gargoylesoftware.htmlunit.WebResponse;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import scraper.parser.LoginResponseParser;

import static org.junit.Assert.*;

public class LoginResponseParserTest {

  @Mock
  private WebResponse loginResponse;
  private LoginResponseParser testResponseParser;


  @Before
  public void init() throws ParseException {
    MockitoAnnotations.initMocks(this);
    Mockito.when(loginResponse.getContentAsString()).thenReturn("{\"reply\": {\"action_token\": \"41llXZe7HB0KDsTHyP3xJprmV\", \"state\": \"PASSWORD-MASKED\", \"password_mask\": [0, 1, 3, 8], \"image_security\": {\"desc\": \"pizza\", \"img\": \"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\\n\", \"format\": \"PNG\"}, \"afptid_pk_allowed\": \"BLACKLIST-NO\", \"flow_id\": \"customer_web_login-0yM1NzgSKUK3nMp9UBmTmLmVt\", \"requirement_steps\": [\"PASSWORD-MASKED\"]}, \"security\": {\"transmission_key_params\": \"s09CowI2dl5jz+4mzwQr3kyH7Z0=\"}, \"system\": {\"mode\": \"ONLINE\"}, \"standard_session\": {\"absolute_timeout\": 3600, \"is_user_logged_in\": false, \"system_timestamp\": \"2019-06-28 13:03:34\", \"absolute_timeout_left\": 3599, \"lifetime\": 300}, \"request_id\": \"Vw6IDhy83KTefXKFts1ZLQURe\"}");
    Mockito.when(loginResponse.getResponseHeaderValue("X-Session-Id")).thenReturn("exampleXSessionIdHeader");
    testResponseParser = new LoginResponseParser(loginResponse);
  }

  @Test
  public void extractMaskedPassword() {
    String password = "testtesttesttesttesttest";
    assertEquals("tett", testResponseParser.extractMaskedPassword(password));
  }

  @Test
  public void extractFlowId() {
    assertEquals("customer_web_login-0yM1NzgSKUK3nMp9UBmTmLmVt", testResponseParser.extractFlowId());
  }

  @Test
  public void extractActionToken() {
    assertEquals("41llXZe7HB0KDsTHyP3xJprmV", testResponseParser.extractActionToken());
  }
}