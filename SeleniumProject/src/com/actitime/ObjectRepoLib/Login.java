package com.actitime.ObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Subhashini
 *
 */

public class Login {
	/*Identification or Initialization of elements */        /*Rule-2*/
	@FindBy(name = "username")
	private WebElement usernameEdt;
	
	@FindBy(name = "pwd")
	private WebElement passwordEdt;
	
	@FindBy(id = "LoginButton")
	private WebElement loginBtn;
		
	/*Usage */      /*Rule-3*/
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}	
		/*Business method */           /*Rule-4*/
		public void loginToApp(String username, String password)
		{
			usernameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginBtn.click();
		}

	}




