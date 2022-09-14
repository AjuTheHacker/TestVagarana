import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Movie {
	WebDriver driver;

	@BeforeClass
	private void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions c = new ChromeOptions();
		c.setPageLoadStrategy(PageLoadStrategy.EAGER);
		c.addArguments("start-maximized");
		driver = new ChromeDriver(c);
	}

	@Test
	private void test() {
		driver.get("https://www.imdb.com/title/tt9389998/");
		System.out.println("IMDB Details");
		List<WebElement> k = driver.findElements(By.xpath(
				"//div[@data-testid='title-details-section']"
				+ "//ul[@class='ipc-metadata-list ipc-metadata-list--dividers-all ipc-metadata-list--base']//li"));
		for (int i = 0; i < k.size(); i++) {
			String p = k.get(i).getText();
			if (p.contains("Rel")) {
				System.out.println(p);
			}
			if (p.contains("Cou")) {
				System.out.println(p);
			}
		}
		System.out.println("\n" + "Wikipedia Details");
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		List<WebElement> l = driver.findElements(By.xpath("//table[@class='infobox vevent']//tr"));
		for (int i = 0; i < l.size(); i++) {
			String y = l.get(i).getText();
			if (y.contains("Rel")) {
				System.out.println(y);
			}
			if (y.contains("Cou")) {
				System.out.println(y);
			}
		}
	}

	@AfterClass
	private void browserClose() {
		driver.close();
	}
}
