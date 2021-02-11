package ai.preferred.crawler.tutorial.master;

import ai.preferred.crawler.tutorial.entity.Paper;
import ai.preferred.venom.Crawler;
import ai.preferred.venom.Session;
import ai.preferred.venom.fetcher.Fetcher;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TutorialCrawler {

  // You can use this to log to console
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TutorialCrawler.class);

  /*
   * After each exercise, you can run the included Junit tests to
   * see whether you have done it right. Most JAVA IDE provide a
   * way to run Junit tests, please consult their respective manual.
   */

  /**
   * Exercise 1: Creating a crawler with default settings.
   * <p>
   * The crawler class is the "brain" behind the fetcher. It
   * checks the queue and tells the fetcher what to crawl, and
   * where should the response be processed. Creating a default
   * crawler will automatically create a default fetcher.
   * <p>
   * Do remember to start it up!
   * <p>
   * Ref: https://github.com/PreferredAI/venom/wiki/Getting-Started:-Overview#how-did-the-magic-happen
   * </p>
   *
   * @return a new instance of crawler
   */
  public static Crawler createCrawler() {
    // Create a new crawler here
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
   * <p>
   * Ref: https://github.com/PreferredAI/venom-examples/blob/fcb983dfb156f6c6746f23d9def0fdc6b39b9ae9/src/main/java/ai/preferred/crawler/iproperty/master/ListingCrawler.java#L54
   * </p>
   *
   * @return a new instance of fetcher
   */
  public static Fetcher createFetcher() {
    // Create a new fetcher here
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
   * store. We have already created the session key above {@see PAPER_LIST_KEY},
   * your task will be to insert this key into a session.
   * <p>
   * Ref: https://github.com/PreferredAI/venom-examples/blob/fcb983dfb156f6c6746f23d9def0fdc6b39b9ae9/src/main/java/ai/preferred/crawler/iproperty/master/ListingCrawler.java#L34
   * </p>
   *
   * @return a new instance of session
   */
  public static Session createSession(List<Paper> papers) {
    // Create a session here
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
   * <p>
   * Do remember to start it up!
   * <p>
   * Ref: https://github.com/PreferredAI/venom-examples/blob/fcb983dfb156f6c6746f23d9def0fdc6b39b9ae9/src/main/java/ai/preferred/crawler/iproperty/master/ListingCrawler.java#L63
   * </p>
   *
   * @return a new instance of fetcher
   */
  public static Crawler createCrawler(Fetcher fetcher, Session session) {
    // Create a new crawler here
    final Crawler crawler = null;

    return crawler;
  }

  /*
   * Looking for Exercise 5?
   * Look in ai.preferred.crawler.tutorial.master.TutorialValidator
   */

  /**
   * Exercise 7: Putting it all together.
   * <p>
   * To run your crawler, you have to put it together into a main
   * method. In this exercise you will be crawling the page
   * {@literal https://preferred.ai/publications/}. Use this space
   * to initialise your crawler and schedule the request. You should use
   * the methods from Exercise 2-4 to help you.
   *
   * Ref: https://github.com/PreferredAI/venom-examples/blob/fcb983dfb156f6c6746f23d9def0fdc6b39b9ae9/src/main/java/ai/preferred/crawler/iproperty/master/ListingCrawler.java#L40
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

  /*
   * To check whether Exercise 7 is done correctly, please run the main
   * method of this class directly. This will crawl our web page in realtime.
   */
}
