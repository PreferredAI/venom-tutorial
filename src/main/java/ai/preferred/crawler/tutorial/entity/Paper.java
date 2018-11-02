package ai.preferred.crawler.tutorial.entity;

public class Paper {

  private final String name;

  private final String url;

  public Paper(String name, String url) {
    this.name = name;
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public String getUrl() {
    return url;
  }
}
