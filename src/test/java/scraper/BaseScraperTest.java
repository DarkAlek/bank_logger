package scraper;

import com.gargoylesoftware.htmlunit.WebClient;

class BaseScraperTest {

  final WebClient client = initClient();

  private static WebClient initClient() {
    WebClient client = new WebClient();
    client.getOptions().setCssEnabled(false);
    client.getOptions().setJavaScriptEnabled(false);
    client.getCookieManager().setCookiesEnabled(true);
    client.getOptions().setTimeout(1000000);
    return client;
  }

}
