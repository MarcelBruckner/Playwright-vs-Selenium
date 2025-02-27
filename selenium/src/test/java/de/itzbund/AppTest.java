package de.itzbund;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Unit test for simple App.
 */
public class AppTest {

	/**
	 * Rigorous Test :-)
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void testITZBund() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://itzbund.de");

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Auswahl bestätigen')]")))
				.click();

		Thread.sleep(2000L);
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("LERNEN SIE UNS KENNEN"))).click();

		By standorte = By.linkText("STANDORTE");
		WebElement element = driver.findElement(standorte);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000L);

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(standorte))
				.click();

		assert driver.findElements(
				By.xpath("//*[contains(text(), '12 Dienstsitze bundesweit')]")).size() > 0;

		driver.quit();
	}
}
