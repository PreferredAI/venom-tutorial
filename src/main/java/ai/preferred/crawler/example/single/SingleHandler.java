/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.preferred.crawler.example.single;

import ai.preferred.venom.Handler;
import ai.preferred.venom.Session;
import ai.preferred.venom.Worker;
import ai.preferred.venom.job.Scheduler;
import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.VResponse;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Ween Jiann Lee
 */
public class SingleHandler implements Handler {

  private static final Logger LOGGER = LoggerFactory.getLogger(SingleHandler.class);

  @Override
  public void handle(Request request, VResponse response, Scheduler scheduler, Session session, Worker worker) {
    LOGGER.info("Processing {}", request.getUrl());

    // Get content type
    System.out.println(response.getContentType());

    // Get HTML
    final String html = response.getHtml();
    System.out.println(html);

    // Get our IP
    final Document document = response.getJsoup();
    final String ip = document.select("#content > div.main-box > div > div.column > div > strong")
        .first().text();

    LOGGER.info("My IP is {}, let's go to {} to verify", ip, request.getUrl());
  }
}
