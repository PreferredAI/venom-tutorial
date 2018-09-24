package ai.preferred.crawler.example.entity;

/**
 * This class allows you to store your entities. Define the
 * properties of your entities in this class.
 *
 * @author Ween Jiann Lee
 */
public class Listing {

  private final String url;

  private final String name;

  private final String company;

  public Listing(String url, String name, String company) {
    this.url = url;
    this.name = name;
    this.company = company;
  }

  public String getUrl() {
    return url;
  }

  public String getName() {
    return name;
  }

  public String getCompany() {
    return company;
  }
}
