package com.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer {
WebDriver ldriver;
	
	public EditCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[3]/a")
	@CacheLookup
	WebElement lnkEditCustomer;
	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement  txtCustomerID;
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement  txtpincode;
	@CacheLookup
	@FindBy(how = How.NAME, using = "AccSubmit")
	WebElement btnSubmit;
	@FindBy(how = How.NAME, using = "sub")
	WebElement btneditSubmit;
	//input[@type='submit']
	public void clickEditCustomer() {
		lnkEditCustomer.click();
	}
		
		public void custId(String cname) {
			txtCustomerID.sendKeys(cname);
		}
			public void custsubmit() {
				btnSubmit.click();
			}
			public void custeditsubmit() {
				btneditSubmit.click();
			}
			public void custpinId(String cpin) {
				txtpincode.sendKeys(Keys.CONTROL + "a");
				txtpincode.sendKeys(Keys.DELETE);
				txtpincode.sendKeys(cpin);
			}
	}

