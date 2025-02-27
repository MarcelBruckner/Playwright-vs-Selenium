# Playwright-vs-Selenium
Evaluierung von Playwright und Selenium

## Selenium

Zu `pom.xml` von Maven Projekt hinzufügen:
```XML
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>${selenium.version}</version>
</dependency>
```

Ausführen:
```shell
mvn test
```

## Playwright

```shell
# Installation
npm init playwright@latest

# Tests ausführen
npx playwright test
```

### Extra Features von Playwright
```shell
# Tests in UI Mode ausführen
npx playwright test --ui

# HTML Report anzeigen
npx playwright show-report

# Tests generieren
npx playwright codegen itzbund.de
```



