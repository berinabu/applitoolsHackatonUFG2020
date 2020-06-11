## Technology stack
* Maven 3.7.0
* Java 1.8.0_201
* TestNG 6.14.3
* Selenium 3.141.59
* Allure 2.10.0
* Appitools 3.165.0

## Project setup
* Install Java JDK and setup JAVA_HOME as environment variable
* Install Maven and setup MAVEN_HOME as environment variables
* Clone the repository
* Install dependencies with command `mvn clean verify -DskipTests`
* Install Allure report, check instructions https://docs.qameta.io/allure/#_get_started

## Running tests
* To run test suite use command `mvn clean test`
* To run Traditional approach test suite use command `mvn clean test -Dgroups=traditional`
* To run Moder approach test suite use command `mvn clean test -Dgroups=modern`

## Browser support
* Chrome, Firefox and Edge (Windows, Linux and OSX)
* Default browser is Chrome
* If you want to specify browser you can use command `mvn clean test -Dbrowser=firefox`
* To run Traditional approach on Firefox use command `mvn clean test -Dgroups=traditional -Dbrowser=firefox`
* To run Traditional approach on Edge use command `mvn clean test -Dgroups=traditional -Dbrowser=edge`

### Test results
* To generate test result use command `allure serve target/allure-results`