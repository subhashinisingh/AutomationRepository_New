package com.actitime.customerTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.ObjectRepoLib.ActiveProAndCust;
import com.actitime.ObjectRepoLib.CreateCustomer;
import com.actitime.ObjectRepoLib.Home;
import com.actitime.ObjectRepoLib.OpenTask;
import com.actitime.genericLib.BaseClass;

public class createCustomer extends BaseClass { /*Extend BaseClass */
	@Test
	public void createCustomerTest() throws Throwable {
		/*read data from excel */
		String customerName = flib.getExcelData("Sheet1", 1, 2);
		/*Navigate to Tasks page */
		Home hp = PageFactory.initElements(driver, Home.class);
		hp.getTaskImg().click();
		/*Step 3: Click on Project & Customer link */
		OpenTask op=PageFactory.initElements(driver, OpenTask.class);
		op.getProjectAndCustomerLnk().click();
		
		/*Step 4: Click create new customer button */
		ActiveProAndCust act = PageFactory.initElements(driver, ActiveProAndCust.class);
		act.getCreateNewCustomerBtn().click();
		
		/*Step5: create Customer */
		CreateCustomer ccp = PageFactory.initElements(driver, CreateCustomer.class);
		ccp.createCustomer(customerName);
		
		/*Step6: Verify */
		String actMsg = act.getCustomerSuccessmsg().getText();
		boolean stat = actMsg.contains("successfully created");
		Assert.assertTrue(stat);
		
	}
	

}
