package com.webappsecurity.zero.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.FundTransfer;
import com.webappsecurity.zero.Pages.FundTransferConfirmation;
import com.webappsecurity.zero.Pages.FundTransferVerify;
import com.webappsecurity.zero.Pages.Login;

import utils.GenericMethods;

public class VerifyFundTransferTest {


	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://zero.webappsecurity.com/login.html");
	}

	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		FundTransfer ft = new FundTransfer(driver);
		FundTransferVerify ftv = new FundTransferVerify(driver);
		FundTransferConfirmation ftc = new FundTransferConfirmation(driver);

		String[][] data = GenericMethods.getData("D:\\SelSep20\\TestData.xlsx", "Sheet1");

		for(int i= 0; i<data.length;i++ ) {
			lp.applicationLogin(data[i][0],data[i][1]);
			acc.clickFundTransfer();
			ft.fundTransfer(data[i][2], data[i][3]);
			ftv.clickSubmit();
			String actualMsg = ftc.getConfMsg();
			String expectedMsg = data[i][4];
			Assert.assertEquals(actualMsg, expectedMsg);
			ftc.logoutFromApp();
			driver.navigate().to("http://zero.webappsecurity.com/login.html");
		}
	}

	@AfterTest
	public void closeApplication() {
		driver.close();
	}

}
