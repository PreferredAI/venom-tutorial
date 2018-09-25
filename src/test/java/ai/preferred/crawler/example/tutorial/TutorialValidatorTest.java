package ai.preferred.crawler.example.tutorial;

import ai.preferred.venom.request.Request;
import ai.preferred.venom.request.VRequest;
import ai.preferred.venom.response.BaseResponse;
import ai.preferred.venom.response.Response;
import ai.preferred.venom.validator.Validator;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class TutorialValidatorTest {

  private byte[] getContent(String filename) throws IOException {
    final InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);
    Assertions.assertNotNull(stream);
    return IOUtils.toByteArray(
        new BufferedInputStream(
            new GZIPInputStream(stream)
        )
    );
  }

  @Test
  public void testValidateAbout() throws IOException {
    final String page = "About – Preferred.AI.html.gz";

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, getContent(page), contentType, headers, proxy);

    Assertions.assertEquals(new TutorialValidator().isValid(request, response), Validator.Status.INVALID_CONTENT);
  }

  @Test
  public void testValidateContactUs() throws IOException {
    final String page = "Contact Us – Preferred.AI.html.gz";

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, getContent(page), contentType, headers, proxy);

    Assertions.assertEquals(new TutorialValidator().isValid(request, response), Validator.Status.INVALID_CONTENT);
  }

  @Test
  public void testValidateOurProjects() throws IOException {
    final String page = "Get to Know Our Projects – Preferred.AI.html.gz";

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, getContent(page), contentType, headers, proxy);

    Assertions.assertEquals(new TutorialValidator().isValid(request, response), Validator.Status.INVALID_CONTENT);
  }

  @Test
  public void testValidateOurPapersDec2017() throws IOException {
    final String page = "Read Our Papers – Preferred.AI - Dec 2017.html.gz";

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, getContent(page), contentType, headers, proxy);

    Assertions.assertEquals(new TutorialValidator().isValid(request, response), Validator.Status.VALID);
  }

  @Test
  public void testValidateOurPapersJan2017() throws IOException {
    final String page = "Read Our Papers – Preferred.AI - Jan 2017.html.gz";

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, getContent(page), contentType, headers, proxy);

    Assertions.assertEquals(new TutorialValidator().isValid(request, response), Validator.Status.VALID);
  }

  @Test
  public void testValidateOurPapersJul2018() throws IOException {
    final String page = "Read Our Papers – Preferred.AI - July 2018.html.gz";

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, getContent(page), contentType, headers, proxy);

    Assertions.assertEquals(new TutorialValidator().isValid(request, response), Validator.Status.VALID);
  }

  @Test
  public void testValidateOurPapersSep2018() throws IOException {
    final String page = "Read Our Papers – Preferred.AI - Sep 2018.html.gz";

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, getContent(page), contentType, headers, proxy);

    Assertions.assertEquals(new TutorialValidator().isValid(request, response), Validator.Status.VALID);
  }


}
