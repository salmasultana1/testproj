package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPageOR extends TestBase{

	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement  password;
	
	@FindBy(xpath= ".//[@id='SubmitLogin")
	WebElement submitbutton ;
	
	@FindBy (xpath="")
	WebElement aplogo;
	
	public LoginPageOR(){
		PageFactory.initElements(driver, this); //Initialize
	
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
		
		public boolean validateAPImage (){
			return aplogo.isDisplayed();
		}
			
			public HomePage login(String uname, String passw){
			username.sendKeys (uname);
			password.sendKeys(passw);
			submitbutton.click();
			
			return new HomePage();
				
			
			
		}
		
	}


