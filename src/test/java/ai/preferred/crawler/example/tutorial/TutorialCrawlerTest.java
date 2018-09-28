package ai.preferred.crawler.example.tutorial;

import ai.preferred.crawler.example.entity.Paper;
import ai.preferred.venom.Crawler;
import ai.preferred.venom.Session;
import ai.preferred.venom.fetcher.AsyncFetcher;
import ai.preferred.venom.fetcher.Fetcher;
import ai.preferred.venom.validator.EmptyContentValidator;
import ai.preferred.venom.validator.PipelineValidator;
import ai.preferred.venom.validator.StatusOkValidator;
import ai.preferred.venom.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TutorialCrawlerTest {

  @Test
  public void testCreateCrawler() throws Exception {
    final Crawler crawler = TutorialCrawler.createCrawler();

    Assertions.assertNotNull(crawler, "Crawler class not found! Did you create a crawler?");

    final Field field = crawler.getClass().getDeclaredField("crawlerThread");
    field.setAccessible(true);

    final Thread thread = (Thread) field.get(crawler);
    Assertions.assertTrue(thread.isAlive(), "Crawler not started found! Did you start the crawler?");

    crawler.interruptAndClose();
  }

  @Test
  public void testCreateSession() {
    final List<Paper> papers = new ArrayList<>();
    final Session session = TutorialCrawler.createSession(papers);
    final List<Paper> papersReturned = session.get(TutorialCrawler.PAPER_LIST_KEY);
    Assertions.assertEquals(papers, papersReturned,
        "Session key not found! Did you put the key/value into the session?");
  }

  @Test
  public void testCreateFetcher() throws Exception {
    final Fetcher fetcher = TutorialCrawler.createFetcher();

    Assertions.assertNotNull(fetcher, "Fetcher class not found! Did you create a fetcher?");
    Assertions.assertTrue(fetcher instanceof AsyncFetcher, "Wrong fetcher class! Did you create a AsyncFetcher?");

    final Field field = fetcher.getClass().getDeclaredField("validator");
    field.setAccessible(true);
    final Object object = field.get(fetcher);
    Assertions.assertNotNull(object, "Validator class not found! Did you create a validator?");
    Assertions.assertTrue(object instanceof Validator, "Validator class not found! Did you create a validator?");

    final Validator validator = (Validator) object;
    Assertions.assertTrue(validator instanceof PipelineValidator,
        "Wrong validator used! Did you include the right validator?");

    final PipelineValidator pipelineValidator = (PipelineValidator) validator;

    final Field field2 = pipelineValidator.getClass().getDeclaredField("validators");
    field2.setAccessible(true);
    @SuppressWarnings("unchecked") final List<Validator> validators = (List<Validator>) field2.get(pipelineValidator);

    Assertions.assertEquals(validators.size(), 3, "Incorrect number of validators found!");

    boolean emptyContent = false;
    boolean statusOk = false;
    boolean tutorial = false;
    for (Validator v : validators) {
      if (v instanceof EmptyContentValidator) {
        emptyContent = true;
      } else if (v instanceof StatusOkValidator) {
        statusOk = true;
      } else if (v instanceof TutorialValidator) {
        tutorial = true;
      }
    }

    Assertions.assertTrue(emptyContent, "Empty content validator not found! Did you include it?");
    Assertions.assertTrue(statusOk, "Status ok validator not found! Did you include it?");
    Assertions.assertTrue(tutorial, "Tutorial validator not found! Did you include it?");

    fetcher.close();
  }

  @Test
  public void testCreateCrawlerWithFetcherAndSession() throws Exception {
    final AsyncFetcher fetcher = AsyncFetcher.buildDefault();
    final Session session = Session.EMPTY_SESSION;

    final Crawler crawler = TutorialCrawler.createCrawler(fetcher, session);

    Assertions.assertNotNull(crawler, "Crawler class not found! Did you create a crawler?");

    final Field field = crawler.getClass().getDeclaredField("crawlerThread");
    field.setAccessible(true);
    final Thread thread = (Thread) field.get(crawler);
    Assertions.assertTrue(thread.isAlive(), "Crawler not started found! Did you start the crawler?");

    final Field field2 = crawler.getClass().getDeclaredField("fetcher");
    field2.setAccessible(true);
    final Fetcher fetcher1 = (Fetcher) field2.get(crawler);
    Assertions.assertEquals(fetcher, fetcher1, "Wrong fetcher found! Did you use the specified fetcher?");

    final Field field3 = crawler.getClass().getDeclaredField("session");
    field3.setAccessible(true);
    final Session session1 = (Session) field3.get(crawler);
    Assertions.assertEquals(session, session1, "Wrong session found! Did you use the specified session?");

    crawler.interruptAndClose();
  }

}
