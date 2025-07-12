# 📸 Selfie Styler

**Selfie Styler** is a test automation project built using Java and TestNG for automating UI tests of a fashion web application. It uses a page-object model (POM) design and supports test execution with screenshots, error logging, and test reporting.

---

## 📁 Project Structure

```
Selfie_styler/
├── pom.xml                      # Maven configuration file
├── .settings/                  # Eclipse-specific settings
├── FailedTestsScreenshots/     # Screenshots of failed test cases
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Utility/        # Utility classes (Browser, Screenshot, Sync, Reporter)
│   │   │   └── com/pages/      # Page Object classes
│   │   └── resources/          # Config files (TestNG, properties)
│   └── test/
│       ├── java/
│       │   ├── Console/Error/  # JavaScript console error detection tests
│       │   └── Deployment/     # Core test cases for signup, login, fitting room, etc.
```

---

## 🔧 Technologies Used

- Java
- Maven
- TestNG
- Selenium WebDriver
- Page Object Model (POM)
- Extent Reports (custom reporting)
- Eclipse IDE

---

## ✅ Features

- Modular test design using POM.
- Console error verification for all major pages.
- Error handling for signup/login.
- Fitting room UI & product validation.
- Screenshots on failure (saved in `FailedTestsScreenshots/`).
- TestNG XML configurations for grouped test runs.
- Utility classes for reusability (e.g., browser setup, waits, screenshots, highlighting).

---

## 🚀 Getting Started

### Prerequisites

- Java 8+
- Maven
- ChromeDriver (or appropriate WebDriver)
- IDE like IntelliJ or Eclipse

### Clone the Repository

```bash
git clone https://github.com/abdullahned/Selfie_styler.git
cd Selfie_styler
```

### Import in IDE

- Open Eclipse or IntelliJ.
- Import as **Maven Project**.
- Let dependencies resolve via `pom.xml`.

### Run Tests

You can run the tests using TestNG:

```bash
mvn test
```

Or run specific test groups using `Deployment_testng.xml` or `testng.xml` inside the `resources/`.

---

## 🧪 Key Packages

| Package                          | Description                               |
|----------------------------------|-------------------------------------------|
| `com.pages`                      | Page Object classes for all modules       |
| `Utility`                        | Browser and test utilities (screenshot, sync, etc.) |
| `Console.Error`                  | JavaScript console error tests            |
| `Deployment.Testcases`          | Functional test cases for all modules     |

---

## 📷 Screenshots

Screenshots of failed test cases are saved in:

```
FailedTestsScreenshots/
```

These help in debugging failures with actual UI evidence.

---

## 📝 Configuration

You can update test parameters in:

```
src/main/resources/configuration.properties
```

Update things like:

- Base URL
- Timeout
- Browser type

---

## 👤 Author

- **Abdullah NED**
- GitHub: [@abdullahned](https://github.com/abdullahned)
