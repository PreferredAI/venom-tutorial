/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.preferred.crawler.example.single;

import ai.preferred.venom.Crawler;
import ai.preferred.venom.Handler;
import ai.preferred.venom.fetcher.AsyncFetcher;
import ai.preferred.venom.fetcher.Fetcher;
import ai.preferred.venom.request.Request;
import ai.preferred.venom.request.VRequest;
import org.slf4j.LoggerFactory;

/**
 * @author Ween Jiann Lee
 */
public class SingleCrawler {

  // You can use this to log to console
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SingleCrawler.class);

  private static final String URL = "https://whoer.net";

  public static void main(String[] args) {

    try (Crawler crawler = crawler(httpFetcher()).start()) {
      LOGGER.info("Starting crawler...");

      // pass in URL and handler
      final Request request =  new VRequest(URL);
      final Handler handler = new SingleHandler();

      crawler.getScheduler().add(request, handler);
    } catch (Exception e) {
      LOGGER.error("Could not run crawler: ", e);
    }

  }

  private static Fetcher httpFetcher() {
    // You can look in builder the different things you can add
    return AsyncFetcher.builder()
        .build();
  }

  private static Crawler crawler(Fetcher fetcher) {
    // You can look in builder the different things you can add
    return Crawler.builder()
        .fetcher(fetcher)
        .build();
  }
}
