package com.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.AddCustomerPage;
import com.pageobjects.DeletePage;
import com.pageobjects.EditCustomer;
import com.pageobjects.LoginPage;
public class TC_AddEditTest_005 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Rajaram");
		addcust.custgender("male");
		addcust.custdob("09","07","1996");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("JSG");
		addcust.custstate("OD");
		addcust.custpinno("768204");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
addcust.custid();
	
	EditCustomer editcust=new EditCustomer(driver);
	
	editcust.clickEditCustomer();
	
	logger.info("providing customer Id....");
	
	editcust.custId(AddCustomerPage.valueIneed);
	//editcust.custId("39111");
	editcust.custsubmit();
	logger.info("start editing....");
	
	Thread.sleep(3000);
	
	editcust.custpinId("560011");
	
	logger.info("pincode edited");
	Thread.sleep(3000);

	editcust.custeditsubmit();
	logger.info("edited....");
	
	DeletePage dt=new DeletePage(driver);
			dt.clickDelCustomer();
	logger.info("delete button clicked");
	dt.custId(AddCustomerPage.valueIneed);
	logger.info("providing customer Id....");
	dt.custDelsubmit();
	logger.info("alert box apperas....");
	
	driver.switchTo().alert().accept();
	logger.info("one more alert box apperas....");
	driver.switchTo().alert().accept();
	logger.info("deleted....");
	
	
	driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		

	
}
}
