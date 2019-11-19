package com.actitime.ObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

	@FindBy(xpath="//div[text()='Tasks']/..")
	private WebElement taskImg;

	@FindBy(xpath="//div[text()='Users']")
	private WebElement userImg;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLnk;

	public WebElement getTaskImg() {
		return taskImg;
	}

	public WebElement getUserImg() {
		return userImg;
	}

	public void logout(){
		logoutLnk.click();
	}
	
	
	
	
}
