# SpringBoot/Selenium/Cucumber test framework for WEB application testing.

### Preconditions:

* Installed Java 17
* Installed Maven
* Installed Docker - only for selenium grid 
* Installed Docker-compose - only for selenium grid

### Test execution:

- Run mvn clean install
- Scenarios can be found in resources/features
- For local run from IDE - open Cucumber.feature and select test to run from button or feature to run all test 
### Remote execution on Selenium hub:

- Run command ```docker-compose up -d --scale chrome=5``` from a root project folder to start selenium hub and 5 chrome nodes.
- Go to http://localhost:4444/grid/console to check 'Grid Console'.
- You can check if hub was started by CURL GET http://localhost:4444/wd/hub/status

- Run command ```mvn clean install -D"spring.profiles.active=remote"``` - will start tests on remote selenium hub.
- To activate settings you should specify required 'properties' files for spring configuration 
- 
### CI integration:

- On each comment push to master branch/pull request tests will be executed with GitHub Actions.
- You can check the results of the execution in the 'Actions' tab of the repository.

### Useful links:

- About cucumber https://habr.com/ru/articles/332754/
- Spring bean scopes https://docs.spring.io/spring-framework/reference/core/beans/factory-scopes.html
- Cucumber parallel test execution https://cucumber.io/docs/guides/parallel-execution/?lang=java
- Cucumber reporting https://github.com/damianszczepanik/maven-cucumber-reporting
- cucumber-report-annotations-action https://github.com/deblockt/cucumber-report-annotations-action
- GitHub Pages https://pages.github.com/
- GitHub Action to deploy your static files to GitHub Page https://github.com/peaceiris/actions-gh-pages
- Selenium Wait Commands: Implicit, Explicit, and Fluent Wait https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
- Selenium Grid https://www.browserstack.com/guide/selenium-grid-tutorial
- Selenium Grid https://www.selenium.dev/documentation/en/grid/
- Configure android device connection https://developer.android.com/studio/debug/dev-options.html
- Test cards https://www.checkout.com/docs/developer-resources/testing/test-cards