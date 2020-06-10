## Technology stack
* Maven 3.7.0
* Java 1.8.0_201
* TestNG 6.14.3
* Selenium 3.141.59
* Allure 2.10.0

## Project setup
* Install Java JDK and setup JAVA_HOME as environment variable
* Insatll Maven and setup MAVEN_HOME as environment variables
* Clone the repository
* Install dependencies with command `mvn clean verify -DskipTests`
* Install Allure report, check instructions https://docs.qameta.io/allure/#_get_started

## Running tests
* To run test suite use command `mvn clean test`
* To run specific group, run `mvn clean test -Dgroups=group1,group2`
* Test groups added regression, sanity

## Browser support
* Chrome, Firefox (Windows, Linux and OSX)
* Default browser is Chrome
* If you want to specify browser you can use command `mvn clean test -Dbrowser=firefox`

### Test results
* To generate test result use command `allure serve target/allure-results`