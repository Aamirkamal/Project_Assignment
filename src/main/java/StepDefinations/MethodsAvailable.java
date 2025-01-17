package StepDefinations;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MethodsAvailable {
	static WebDriver driver;
	static String exp_str = "object";
	static List<WebElement> links;
	static String exp_Result = "https://developer.here.com/";

	public void LaunchBrowser() {
		System.setProperty("webdriver.gecko.driver", "utils\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void NavigateToURL() {
		driver.get("https://developer.here.com/documentation");
		
	}

	public void countLink_And_VerifyDeveloperPage() {
				links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);

			String url = element.getAttribute("href");
			verifyLinkDeveloperPage(url);
		}
	}

	public static void verifyLinkDeveloperPage(String urlLink) {
		try {
			URL link = new URL(urlLink);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			if (httpConn.getResponseCode() == 200) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
				driver.get(urlLink);
				if (urlLink.contains(exp_Result)) {
					System.out.println("String is internal");
					
				} else {
					System.out.println("String is external");
					System.out.println(urlLink);
					
				}

			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(urlLink + " - " + httpConn.getResponseMessage());
			}
		} catch (Exception e) {
			
		}

		driver.get("https://developer.here.com/documentation");
		links = driver.findElements(By.tagName("a"));
	}

	public void Verify_PageLoad() {
		String title = driver.getTitle();
		System.out.println("Page loaded sucessfully and Tiltle of Page is " + title);
	}
	
}
