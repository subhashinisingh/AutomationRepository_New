package com.actitime.ObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActiveProAndCust {
	
	@FindBy(xpath = "//input[@value='Create New Customer']")
	private WebElement createNewCustomerBtn;
	
	@FindBy(xpath = "//input[@value='Create New Project']")
	private WebElement createNewProjectBtn;
	
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement customerSuccessmsg;

	public WebElement getCreateNewCustomerBtn() {
		return createNewCustomerBtn;
	}

	public WebElement getCreateNewProjectBtn() {
		return createNewProjectBtn;
	}

	public WebElement getCustomerSuccessmsg() {
		return customerSuccessmsg;
	}
	
	

}
