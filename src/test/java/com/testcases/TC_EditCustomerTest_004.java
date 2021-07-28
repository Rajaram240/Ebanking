package com.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pageobjects.AddCustomerPage;
import com.pageobjects.EditCustomer;
import com.pageobjects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass{

	@Test
	public void editCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
EditCustomer editcust=new EditCustomer(driver);
		
		editcust.clickEditCustomer();
		
		logger.info("providing customer Id....");
		
		editcust.custId(AddCustomerPage.valueIneed);
		//editcust.custId("39111");
		editcust.custsubmit();
		logger.info("start editing....");
		
}

}