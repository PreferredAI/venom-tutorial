/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.preferred.crawler.example.master;

import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.Response;
import ai.preferred.venom.response.VResponse;
import ai.preferred.venom.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ween Jiann Lee
 */
public class ListingValidator implements Validator {

  private static final Logger LOGGER = LoggerFactory.getLogger(ListingValidator.class);

  /**
   * Use this to positively validate your page.
   * <p>
   * For example, if you are crawling store ABC, you would find.
   * </p>
   *
   * @param request  The request used to fetch.
   * @param response The response fetched using request.
   * @return status of the validation
   */
  @Override
  public Status isValid(Request request, Response response) {
    final VResponse vResponse = new VResponse(response);

    // Do some checks here
    if (vResponse.getHtml().contains("Jobs in Singapore")) {
      return Status.VALID;
    }

    return Status.INVALID_CONTENT;
  }

}
