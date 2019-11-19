package com.actitime.ObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenTask {
	
	@FindBy(xpath="//a[text()='Projects & Customers']")
	/*(linkText="Projects & Customers")*/
	private WebElement projectAndCustomerLnk;

	public WebElement getProjectAndCustomerLnk() {
		return projectAndCustomerLnk;
	}
	
}
