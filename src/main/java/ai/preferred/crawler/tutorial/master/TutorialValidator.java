/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.preferred.crawler.tutorial.master;

import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.Response;
import ai.preferred.venom.response.VResponse;
import ai.preferred.venom.validator.Validator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Ween Jiann Lee
 */
public class TutorialValidator implements Validator {

  private static final Logger LOGGER = LoggerFactory.getLogger(TutorialValidator.class);

  /**
   * Exercise 5: Creating a validator that validate the page
   * {@literal https://preferred.ai/publications/} against other pages.
   *
   * <p>
   * Validators should withstand the test of time. You should find
   * some persistent information on the page to identify it. We
   * will be testing your validation against multiple timeline and
   * different pages on https://preferred.ai/. Return {@code Status.Valid}
   * if the page is right and {@code Status.INVALID_CONTENT} if wrong.
   * </p>
   *
   * @param request  The request used to fetch.
   * @param response The response fetched using request.
   * @return status of the validation
   */
  @Override
  public Status isValid(Request request, Response response) {
    // Log when there's activity
    LOGGER.info("Validating {}", request.getUrl());

    final VResponse vResponse = new VResponse(response);

    // Some vars you may need
    final String html = vResponse.getHtml();
    final Document document = vResponse.getJsoup();

    // Do some checks here
    final Element el = document.select("#page > div > div > div > div.content > div > div > h2").first();
    if (el != null && el.text().equals("Read Our Papers")) {
      return Status.VALID;
    }

    return Status.INVALID_CONTENT;
  }

}
