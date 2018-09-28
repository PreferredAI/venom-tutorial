package ai.preferred.crawler.example.tutorial;

import ai.preferred.crawler.example.entity.Paper;
import ai.preferred.venom.Crawler;
import ai.preferred.venom.Session;
import ai.preferred.venom.fetcher.Fetcher;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TutorialCrawler {

  // You can use this to log to console
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TutorialCrawler.class);

  /**
   * Exercise 1: Creating a crawler with default settings.
   * <p>
   * The crawler class is the "brain" behind the fetcher. It
   * checks the queue and tells the fetcher what to crawl, and
   * where should the response be processed. Creating a default
   * crawler will automatically create a default fetcher.
   * </p>
   *
   * @return a new instance of crawler
   */
  public static Crawler createCrawler() {
    // Create the crawler here
    final Crawler crawler = null;

    return crawler;
  }

  /**
   * Exercise 2: Creating a fetcher that includes these (3) validators:
   * - EmptyContentValidator,
   * - StatusOkValidator,
   * - TutorialValidator.
   * <p>
   * The fetcher class is like a internet browser, it allows
   * you to fetch a page given a request (URL). You can also constrain
   * the validity of the page by using validators.
   * </p>
   *
   * @return a new instance of fetcher
   */
  public static Fetcher createFetcher() {
    // Create the fetcher here
    final Fetcher fetcher = null;

    return fetcher;
  }

  // Create session keys for things you would like to retrieve in/from handler
  static final Session.Key<List<Paper>> PAPER_LIST_KEY = new Session.Key<>();

  /**
   * Exercise 3: Creating a session store with PAPER_LIST_KEY.
   * <p>
   * A session store allows you to exchange information/objects between
   * your main method and your handler. As our crawler runs asynchronously,
   * you will not be able to directly pass parameters to or directly
   * return objects from the handler. To overcome this, we will use a session
   * store. We have already created the session key above, your task will be
   * to insert this key into a session.
   * </p>
   *
   * @return a new instance of session
   */
  public static Session createSession(List<Paper> papers) {
    final Session session = null;

    return session;
  }

  /**
   * Exercise 4: Creating a crawler that uses a specified fetcher and session.
   * <p>
   * The crawler class is the "brain" behind the fetcher. It
   * checks the queue and tells the fetcher what to crawl, and
   * where should the response be processed. To use the fetcher and
   * session you created you should put it into crawler's builder.
   * </p>
   *
   * @return a new instance of fetcher
   */
  public static Crawler createCrawler(Fetcher fetcher, Session session) {
    // Create the crawler here
    final Crawler crawler = null;

    return crawler;
  }

  /**
   * Exercise 7: Putting it all together.
   * <p>
   * To run your crawler, you have to put it together into a main
   * method. In this exercise you will be crawling the page
   * {@literal https://preferred.ai/publications/}. Use this space
   * to initialise your crawler and schedule the request.
   * </p>
   */
  public static void main(String[] args) throws Exception {
    final List<Paper> papers = new ArrayList<>();

    // try-with block automatically closes the crawler upon completion.
    try (final Crawler crawler = null) {

    }

    LOGGER.info("You have crawled {} papers.", papers.size());
    papers.forEach(paper -> LOGGER.info("Name: {}, Url: {}", paper.getName(), paper.getUrl()));
  }
}
