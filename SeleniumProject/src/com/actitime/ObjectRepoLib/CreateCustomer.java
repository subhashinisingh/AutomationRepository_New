package com.actitime.ObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCustomer {
	@FindBy(name = "name")
	private WebElement customerNameEdt;
	@FindBy(name = "createCustomerSubmit")
	private WebElement createCustomerBtn;
	
	@FindBy(name = "description")
	private WebElement createDescpEdt;

	public WebElement getCustomerNameEdt() {
		return customerNameEdt;
	}

	public WebElement getCreateCustomerBtn() {
		return createCustomerBtn;
	}

	public void createCustomer(String customerName) {
		customerNameEdt.sendKeys(customerName);
		createCustomerBtn.click();
	}
	public void createCustomer(String customerName, String Desp) {
		customerNameEdt.sendKeys(customerName);
		createDescpEdt.sendKeys(Desp);
		createCustomerBtn.click();
	}



}
