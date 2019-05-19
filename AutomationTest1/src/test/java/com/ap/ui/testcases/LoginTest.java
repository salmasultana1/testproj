package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPageOR;

public class LoginTest extends TestBase {

	
		// TODO Auto-generated method stub
		LoginPageOR loginPage;
		HomePage homepage;
		
		public LoginTest(){ // Constructor
			super(); // object for parent class
		}
		
	 @BeforeMethod
     public void setUpdriver(){
	 initialization();
	 loginPage = new LoginPageOR();
	 }
	 
	 
	 @Test(priority=1)
		public void loginpageTitleTest(){
			String title = loginPage.verifyPageTitle();
			Assert.assertEquals(title, "Later will check on the site"); // assert verify certain information its true or flase
		}
		
		@Test(priority=2)
		public void apLogoTest(){
			boolean value = loginPage.validateAPImage(); // verify either true or false
			Assert.assertTrue(value);
		}
		
		@Test(priority=3)
		public void loginTest(){
			homepage = loginPage.login(propt.getProperty("username"), propt.getProperty("password")); // Prompt getting all information
		}
		
		@AfterMethod
		public void closeBrowser(){  // closing the browser
			driver.quit();
		}

		
		// read about super in java and constructor
		// obtain all the locator value which we didnt provide i our script
	

	 
	 
 }
	


