package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {
	
	WebDriver driver;
	
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public void addImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navigateToAUT(String url) {
		driver.get(url);
	}
	public void enterInATextBox(String locValue, String testData) {
		driver.findElement(By.id(locValue)).sendKeys(testData);
	}
	public void clickButton(String loc, String locValue) {
		if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		}
		else if(loc.equals("xPath")) {
			driver.findElement(By.xpath(locValue)).click();
		}
	}
	
	public String getErrorMessage(String loc, String locValue) {
		String errMsg = null;
		if(loc.equals("cssSelector")) {
			 errMsg = driver.findElement(By.cssSelector(locValue)).getText();
		}
		else if(loc.equals("id")) {
			 errMsg = driver.findElement(By.id(locValue)).getText();
		}
		return errMsg;
	}

	public void closeApplication() {
		driver.close();
	}
}
