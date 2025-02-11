# Selenium Test Automation Framework

This repository contains functional tests for the search page filtering, navigation, and validation functionalities using **Selenium**, **Java**, and **TestNG**. The framework is designed for parallel execution, with a modular structure following best practices for test automation.

## Project Structure

```
src
│── main
│   ├── java/com/selenium/ft
│   │   ├── constants
│   │   │   ├── Constants.java
│   │   ├── pages
│   │   │   ├── BasePage.java
│   │   │   ├── EditorPage.java
│   │   │   ├── ImagePage.java
│   │   │   ├── SearchPage.java
│   │   │   ├── SignInModal.java
│   │   ├── setup
│   │   │   ├── ConfigReader.java
│   │   │   ├── DriverFactory.java
│   │   ├── utils
│   │   │   ├── Util.java
│   ├── resources
│   │   ├── configuration.properties
│── test/java/com/selenium/ft
│   ├── BaseTest.java
│   ├── FilterTest.java
│── target
│── PicsartTask.iml
│── README.md
│── pom.xml
│── testng.xml
```

## Framework Highlights

### 1. **Driver Management**  
- Uses `WebDriverManager` to automatically manage the browser drivers.  
- Thread-safe `DriverFactory` ensures parallel test execution without interference.

### 2. **Parallel Execution**  
- Tests are executed in parallel with different resolutions using TestNG's `@Parameters`.  
- Resolutions are passed to the `BaseTest` setup method:

  ```java
  @Parameters({"width", "height"})
  public void setUp(@Optional("1920") int width, @Optional("1080") int height) {
      // Browser window dimensions and URL initialization
  }
  ```

### 3. **Modular Design**  
- **Pages Folder**: Contains a `BasePage` for reusable methods (e.g., explicit waits, click actions) and separate classes for each page and pop-ups.  
- **Utils Folder**: Includes helper functions (e.g., `sleep()`) and other general-purpose utilities.  
- **Tests Folder**: Organized by functionality, with individual classes for specific pages or features.

### 4. **Property-Driven Configuration**  
- Configurations (e.g., base URL) are loaded from a property file using `ConfigReader`.  
- Enables easy updates via key-value pairs.

### 5. **Soft Assertions**  
- Soft assertions ensure multiple verifications are executed within a single test, even if some fail.

### 6. **Iframe Handling**  
- The search page includes iframes.  
- Ensure to switch to the correct iframe before locating elements using the `data-testid` locators.

## Technologies Used  
- **Java** (JDK 15+)  
- **Selenium WebDriver** (v4.28.1)  
- **TestNG** (v7.10.2)  
- **WebDriverManager** (v5.9.2)  
- **Allure** for reporting (v2.29.1)  

## Test Execution  

### 1. Clone the Repository:  
```bash
git clone https://github.com/Astghik-90/PicsartTask.git
```

### 2. Ensure Maven and JDK 15+ are Installed.  

### 3. Run Tests Using Maven:  
```bash
mvn test
```
- By default, the `testng.xml` file executes tests in parallel for multiple resolutions.

## Sample `testng.xml` for Parallel Execution  
```xml
<suite name="Functional Tests" parallel="tests" thread-count="3">
    <test name="Search Page Tests">
        <parameter name="width" value="1920"/>
        <parameter name="height" value="1080"/>
        <classes>
            <class name="com.selenium.ft.FilterTest"/>
        </classes>
    </test>
</suite>
```

## Contributing  
Feel free to open issues or create pull requests to enhance the framework.

## License  
This project is licensed under the MIT License.
