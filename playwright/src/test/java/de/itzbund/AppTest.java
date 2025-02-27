package de.itzbund;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.AriaRole;

import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AppTest {

    @Test
    void testITZBund() {
        Playwright playwright = Playwright.create();
        LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false);
        Browser browser = playwright.chromium().launch(headless);
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://itzbund.de");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Auswahl bestätigen")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Lernen Sie uns kennen")).click();
        page.locator("a").filter(new Locator.FilterOptions().setHasText("Standorte")).nth(3).click();
        assertThat(page.getByText("12 Dienstsitze bundesweit")).isVisible();

        context.close();
    }
}