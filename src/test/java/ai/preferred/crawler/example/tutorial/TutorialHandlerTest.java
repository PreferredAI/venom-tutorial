package ai.preferred.crawler.example.tutorial;

import ai.preferred.crawler.example.entity.Paper;
import ai.preferred.venom.Session;
import ai.preferred.venom.ThreadedWorkerManager;
import ai.preferred.venom.Worker;
import ai.preferred.venom.job.FIFOScheduler;
import ai.preferred.venom.request.Request;
import ai.preferred.venom.request.VRequest;
import ai.preferred.venom.response.BaseResponse;
import ai.preferred.venom.response.Response;
import ai.preferred.venom.response.VResponse;
import ai.preferred.venom.utils.InlineExecutorService;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class TutorialHandlerTest {

  private Map<String, String> getPapers(Document document) {
    final Map<String, String> papers = new HashMap<>();

    final Elements elements = document.select("#post-39 > div > ul > li");
    for (Element element : elements) {
      final String url = element.select("a").attr("abs:href");
      final String name = element.select("a").text().trim();
      papers.put(url, name);
    }

    return papers;
  }

  @Test
  public void testHandler() throws IOException {
    final String page = "Read Our Papers – Preferred.AI - Sep 2018.html.gz";

    final InputStream stream = getClass().getClassLoader().getResourceAsStream(page);
    Assertions.assertNotNull(stream);
    final byte[] content = IOUtils.toByteArray(
        new BufferedInputStream(
            new GZIPInputStream(stream)
        )
    );

    final int statusCode = 200;
    final String url = "https://preferred.ai/";
    final ContentType contentType = ContentType.create("text/html", StandardCharsets.UTF_8);
    final Header[] headers = {};
    final HttpHost proxy = null;

    final ArrayList<Paper> papers = new ArrayList<>();

    final Request request = new VRequest(page);
    final Response response = new BaseResponse(statusCode, url, content, contentType, headers, proxy);
    final FIFOScheduler scheduler = new FIFOScheduler();
    final Session session = Session.builder().put(TutorialCrawler.PAPER_LIST_KEY, papers).build();
    final Worker worker = new ThreadedWorkerManager(new InlineExecutorService()).getWorker();

    final VResponse vResponse = new VResponse(response);
    final Map<String, String> papersTest = getPapers(vResponse.getJsoup());

    new TutorialHandler().handle(request, response, scheduler, session, worker);

    Assertions.assertTrue(papers.size() >= papersTest.size(),
        "Not all the papers are found! Did you pick the right selector?");

    final Set<String> urls = new HashSet<>();
    for (Paper paper : papers) {
      final String paperUrl = paper.getUrl();
      Assertions.assertTrue(papersTest.containsKey(paperUrl),
          "Not such paper URL found! Are you sure '" + paper.getUrl() + "' is a url?");

      final String name = papersTest.get(paperUrl);
      Assertions.assertEquals(name, paper.getName().trim(),
          "Paper name different! Are you sure you selected the right text?");
      Assertions.assertEquals(name, paper.getName(),
          "Paper name different! Did you trim whitespaces from your text?");
      urls.add(paperUrl);
    }

    Assertions.assertEquals(papersTest.size(), urls.size(), "Not all the papers are found! Did you select duplicates?");
  }

}
