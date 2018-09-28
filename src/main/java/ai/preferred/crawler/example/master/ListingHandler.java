/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.preferred.crawler.example.master;

import ai.preferred.crawler.example.EntityCSVStorage;
import ai.preferred.crawler.example.entity.Listing;
import ai.preferred.venom.Handler;
import ai.preferred.venom.Session;
import ai.preferred.venom.Worker;
import ai.preferred.venom.job.Scheduler;
import ai.preferred.venom.request.Request;
import ai.preferred.venom.request.VRequest;
import ai.preferred.venom.response.VResponse;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author Ween Jiann Lee
 */
public class ListingHandler implements Handler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ListingHandler.class);

  @Override
  public void handle(Request request, VResponse response, Scheduler scheduler, Session session, Worker worker) {
    LOGGER.info("Processing {}", request.getUrl());

    // Get the job listing array list we created
    final ArrayList<Listing> jobListing = session.get(ListingCrawler.JOB_LIST_KEY);

    // Get the job listing array list we created
    final EntityCSVStorage csvStorage = session.get(ListingCrawler.CSV_STORAGE_KEY);

    // Get HTML
    final String html = response.getHtml();

    // JSoup
    final Document document = response.getJsoup();

    // We will use a parser class
    final ListingParser.FinalResult finalResult = ListingParser.parse(response);
    finalResult.getListings().forEach(listing -> {
      LOGGER.info("Found job: {} in {} [{}]", listing.getName(), listing.getCompany(), listing.getUrl());

      // Add to the array list
      jobListing.add(listing);

      // Write record in CSV
      csvStorage.append(listing);
    });

    // Crawl another page if there's a next page
    if (finalResult.getNextPage() != null) {
      final String nextPageURL = finalResult.getNextPage();

      // Schedule the next page
      scheduler.add(new VRequest(nextPageURL), this);
    }

  }
}
