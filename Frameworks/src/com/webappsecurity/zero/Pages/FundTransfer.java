package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FundTransfer {


	@FindBy(id="tf_fromAccountId")
	private WebElement fromAcc;
	
	@FindBy(id="tf_toAccountId")
	private WebElement toAcc;
	
	@FindBy(id="tf_amount")
	private WebElement amt;
	
	@FindBy(id="tf_description")
	private WebElement desc;
	
	@FindBy(id="btn_submit")
	private WebElement continueBtn;
	
	
	public FundTransfer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fundTransfer(String amount, String description) {
		Select fromAccDD = new Select(fromAcc);
		fromAccDD.selectByIndex(2);
		
		Select toAccDD = new Select(toAcc);
		toAccDD.selectByIndex(3);
		
		amt.sendKeys(amount);
		desc.sendKeys(description);
		
		continueBtn.click();
	}
	
}
