# 🧪 Ecommerce Tealium Demo Website

This project is a **TestNG-based UI automation framework** built using the **Page Object Design Pattern**, with support for **helper classes**, **factories**, and **reporting via ExtentReports**. It targets the registration, login, and product purchase flows of a web e-commerce platform.

---

## 📁 Project Structure

```
├── build.gradle
├── Dockerfile
├── src
│   ├── main
│   │   ├── java
│   │   │   └── frontend
│   │   │       ├── enums
│   │   │       ├── Factories
│   │   │       ├── helpers
│   │   │       ├── models
│   │   │       ├── pages
│   │   │       └── utilities
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── frontend
│       │   │   └── tests
│       │   └── reports
│       └── resources
├── test-output
│   ├── ExtentReport.html
│   └── screenshots
```

---

## 🔧 Tools & Technologies

- **Java 21**
- **Selenium WebDriver**
- **TestNG**
- **ExtentReports**
- **Java Faker** (for random test data)
- **Page Object Model (POM)**
- **Docker** 
- **Gradle** 

---

## 🚀 How to Run the Project

### ✅ Pre-requisites

- Java 17 or later
- Gradle
- Chrome browser
- Docker

---

### 🔄 Without Docker

1. **Clone the project**:
   ```bash
   git clone https://github.com/your-username/frontend-automation.git
   cd frontend-automation
   ```

2. **Configure environment variables** 

3. **Run tests with Gradle**:
   ```bash
   ./gradlew test
   ```

4. **View the report**:
   After execution, open `test-output/extent-report.html`.

---

### 🐳 With Docker

> Ensure Docker is installed and the Docker daemon is running.

1. **Build the Docker image**:
   ```bash
   docker build -t selenium-tests .
   ```

2. **Run the tests inside Docker**:
   ```bash
   docker run --rm selenium-tests
   ```
---

## 🧠 Design Patterns Used

- **Page Object Design Pattern**: Encapsulates page logic in reusable classes.
- **Helper Classes**: Shared logic to register users or create products.
- **Factory Pattern**: Generates random test data using `UserFactory`.
- **POJO Models**: Clean data modeling for users and other entities.

---

## 🔧 Upcoming Improvements

Some enhancements planned for the next iterations of this project:

- 🗂 **Use JSON files for data providing**  
  Replace hardcoded test data with structured and maintainable JSON files.

- 🔄 **Use API-based helper methods for test data preparation**  
  Create users or products directly via API to speed up setup and reduce UI dependencies.

- 📊 **Include test run summary in reports**  
  Add environment info and API response logs to ExtentReports.
  
  ---


## 📄 Reports

Test reports are generated using **ExtentReports** with rich HTML output.

> File: `test-output/extent-report.html`



