# Venom Tutorial
Your preferred focused crawler based on [Venom](https://github.com/PreferredAI/Venom). 
Now in a convenient package to quickly get your projects up to speed! 

Bundled in this pack is a tutorial package to help get you up and sprinting. If you don't require a tutorial, you can access a fully functional example [here](https://github.com/PreferredAI/venom-examples).
For more information, read the tutorial guide below.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/ai.preferred/venom/badge.svg)](https://maven-badges.herokuapp.com/maven-central/ai.preferred/venom)
[![Build Status](https://travis-ci.org/PreferredAI/Venom.svg)](https://travis-ci.org/PreferredAI/Venom)
[![Coverage Status](https://coveralls.io/repos/github/PreferredAI/Venom/badge.svg)](https://coveralls.io/github/PreferredAI/Venom)
[![Javadocs](https://www.javadoc.io/badge/ai.preferred/venom.svg)](https://www.javadoc.io/doc/ai.preferred/venom)

## Overview
Check out our main [Venom](https://github.com/PreferredAI/Venom) page for more information.

### Quick links
[Website](https://venom.preferred.ai/) |
[Wiki](https://github.com/PreferredAI/venom/wiki) |
[API Reference](https://venom.preferred.ai/docs/) |
[PreferredAI](https://preferred.ai/)

## Tutorial
venom-tutorial includes a set of tutorial designed to quickly get you from 0 to 100.

There are 7 exercises located in the package ai.preferred.crawler.example.tutorial. 
Alongside the exercises are a set of test suite that automatically checks your code and provide hints on errors, 
so you do not have to worry about not knowing whether your code works.

For more information you can visit our [Wiki](https://github.com/PreferredAI/venom/wiki).

#### TutorialCrawler.java
- Exercise 1: Creating a crawler with default settings.
- Exercise 2: Creating a fetcher that includes three (3) validators.
- Exercise 3: Creating a session store with PAPER_LIST_KEY.
- Exercise 4: Creating a crawler that uses a specified fetcher and session.

#### TutorialValidator.java
- Exercise 5: Creating a validator that validate a page.

#### TutorialHandler.java
- Exercise 6: Parsing the response from the crawl.

#### TutorialCrawler.java
- Exercise 7: Putting it all together.

### Test Suite
Easily find out what went wrong by running the tests included with the exercises.

You can run this command in the project folder
```
mvn test
```
Or use your IDE to run JUnit tests
![Test Suite](https://venom.preferred.ai/wp-content/uploads/sites/2/2018/12/Test-Suite-min259.png "Test Suite")

## License

[Apache License 2.0](LICENSE)

