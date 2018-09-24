# Venom-Example
A focused crawler based on venom.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/ai.preferred/venom/badge.svg)](https://maven-badges.herokuapp.com/maven-central/ai.preferred/venom)
[![Build Status](https://travis-ci.org/PreferredAI/Venom.svg)](https://travis-ci.org/PreferredAI/Venom)
[![Coverage Status](https://coveralls.io/repos/github/PreferredAI/Venom/badge.svg)](https://coveralls.io/github/PreferredAI/Venom)
[![Javadocs](https://www.javadoc.io/badge/ai.preferred/venom.svg)](https://www.javadoc.io/doc/ai.preferred/venom)

## Overview
Our aim is to create a blazing fast, fully customizable and robust crawler that is simple and handy to use.

### Quick links
[Website](https://venom.preferred.ai/) |
[API Reference](https://venom.preferred.ai/docs/) |
[PreferredAI](https://preferred.ai/)

### Features
- Multi-threaded out of the box
- Structured crawling with JSoup integration
- Page Validation
- Automatic Retries
- Proxy support

## Getting started

### Install
Add dependencies to your pom.xml:
```xml
<dependency>
    <!-- Venom: A focused crawler framework @ https://venom.preferred.ai/ -->
    <groupId>ai.preferred</groupId>
    <artifactId>venom</artifactId>
    <version>[4.0,4.1)</version>
</dependency>
```

### Example
```java
public class Example {
 
    private static class VenomHandler implements Handler {
 
        @Override
        public void handle(Request request,
                           VResponse response,
                           Scheduler scheduler,
                           Session session,
                           Worker worker) {
 
            String about = response.getJsoup().select(".about p").text();
            System.out.println("ABOUT: " + about);
 
        }
 
    }
 
    public static void main(String[] args) throws Exception {
        try (Crawler c = Crawler.buildDefault().start()) {
            Request r = new VRequest("https://venom.preferred.ai");
            c.getScheduler().add(r, new VenomHandler());
        }
    }
 
}
```

## License

[Apache License 2.0](LICENSE)
