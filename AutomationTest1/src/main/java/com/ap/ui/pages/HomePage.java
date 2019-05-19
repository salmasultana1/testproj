package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(css = "[class = 'login']")
	WebElement signInButton;
	
	
	@FindBy (id = "contact-link")
	WebElement contactlink;
	
	@FindBy(id = "search _quary_top")
	WebElement searchInputbox;
	
	@FindBy (css = "[name = 'submit_search']")
	WebElement submitSearch;
	
	@FindBy (css= "[class='logout']")
	WebElement logOutButton;
	
	public HomePage(){     // constructor
		PageFactory.initElements (driver,this);
	}
		
	public SearchPage searchProduct(String productName){ /// creating method
		searchInputbox.sendKeys(productName);
		submitSearch.click();
		return new SearchPage();
	}
	public void clickOnSignIn(){
		signInButton.click();
	}
	public void clickOncontactLink(){
		contactlink.click();
	}
	public void logOut(){
		logOutButton.click();
	}
	
	
	
}




