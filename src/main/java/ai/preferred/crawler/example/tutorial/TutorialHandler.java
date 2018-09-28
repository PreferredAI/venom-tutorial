package ai.preferred.crawler.example.tutorial;

import ai.preferred.crawler.example.entity.Paper;
import ai.preferred.venom.Handler;
import ai.preferred.venom.Session;
import ai.preferred.venom.Worker;
import ai.preferred.venom.job.Scheduler;
import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.VResponse;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TutorialHandler implements Handler {

  private static final Logger LOGGER = LoggerFactory.getLogger(TutorialHandler.class);

  /**
   * Exercise 6: Parsing the response from the crawl.
   * <p>
   * The handle method will be called once the page has been successfully
   * crawled by our fetcher. You should use this space to extract the
   * relevant information you require. For this exercise you are required
   * to extract all paper name and url and use it to create {@code Paper}
   * object. Lastly, add all the {@code Paper} objects into papers array
   * list for the test to pass.
   * </p>
   *
   * @param request   request fetched.
   * @param response  venom response received.
   * @param scheduler scheduler used for this request.
   * @param session   session variables defined when the crawler is initiated.
   * @param worker    provides the ability to run code in a separate thread.
   */
  @Override
  public void handle(Request request, VResponse response, Scheduler scheduler, Session session, Worker worker) {
    // Log when there's activity
    LOGGER.info("Processing {}", request.getUrl());

    // The array list to put your results
    final List<Paper> papers = session.get(TutorialCrawler.PAPER_LIST_KEY);

    // Some vars you may need
    final String html = response.getHtml();
    final Document document = response.getJsoup();

    // Get all the papers
    final Elements elements = null;
    papers.add(null);

  }

}
