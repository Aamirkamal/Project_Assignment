package StepDefinations;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class MethodsAvailable {
	static WebDriver driver;
	 static String exp_str="object";
	 static List<WebElement> links;
	public void LaunchBrowser() {
		System.setProperty("webdriver.gecko.driver", "utils\\geckodriver.exe");
		driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 }
	 public void NavigateToURL() {	
	    driver.get("https://developer.here.com/documentation");
		 
	 }
	 public void NavigateToURLDeveloperAndVal() {
		
		 driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("https://developer.here.com");
		    String str= (String) ((JavascriptExecutor)driver).executeScript("return typeof angular");
	    if(str.equals(exp_str)){
	    	System.out.println("Angular was initialised on the Page");
	    }
	    else{
	    System.out.println("Angular was not initialised on the Page");	
	    }
	    }
      public void countLink_And_VerifyDeveloperPage() {
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 links = driver.findElements(By.tagName("a"));
		 System.out.println("Total links are "+links.size()); 
		 for(int i=0; i<links.size(); i++) {
		 WebElement element = links.get(i);
		 
		 String url=element.getAttribute("href");
		 verifyLinkDeveloperPage(url); 
		 }
		 } 
		 public static void verifyLinkDeveloperPage(String urlLink) {
		        try {
		 URL link = new URL(urlLink);
		 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
		 httpConn.setConnectTimeout(2000);
		 httpConn.connect();
		 if(httpConn.getResponseCode()== 200) { 
		 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
		 driver.get(urlLink);
		    String str= (String) ((JavascriptExecutor)driver).executeScript("return typeof angular");		    
	    if(str.equals(exp_str)){
	    	System.out.println("Angular was initialised on the Page");
	    }
	    else{
	    System.out.println("Angular was not initialised on the Page");	
	    }
	    
		 }
		 if(httpConn.getResponseCode()== 404) {
		 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
		 }
		 }
		 catch (Exception e) {
		 }
		    
		        driver.get("https://developer.here.com");
		        links = driver.findElements(By.tagName("a"));
		 }
		 public void countLink_And_Verify() {
			 try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		 links = driver.findElements(By.tagName("a"));
		 System.out.println("Total links are "+links.size()); 
		 for(int i=0; i<links.size(); i++) {
		 WebElement element = links.get(i);
		 String url=element.getAttribute("href");
		 verifyLinkPage(url); 
		 }
		 } 
		 public static void verifyLinkPage(String urlLink) {
		        try {
		 URL link = new URL(urlLink);
		 HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
		 httpConn.setConnectTimeout(2000);
		 httpConn.connect();
		 //
		 if(httpConn.getResponseCode()== 200) { 
		 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
		 driver.get(urlLink);
		 }
		 if(httpConn.getResponseCode()== 404) {
		 System.out.println(urlLink+" - "+httpConn.getResponseMessage());
		 }
		 }
		 catch (Exception e) {
		 }
		        driver.get("https://developer.here.com/documentation");
		        links = driver.findElements(By.tagName("a")); 
		 }
}
