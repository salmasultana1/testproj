package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPage extends TestBase{
	@FindBy (id = "quantity_wanted")
	WebElement quantityInput;
	
	@FindBy (id= "group_1")
	WebElement sizeDropDown;
	
	@FindBy (id = "color_13")
	WebElement color;
	
	@FindBy (xpath = "//*[@id='add_to_cart']/button/span") // put single qutation on add_to_cart'
	WebElement addCartButton;
	
	@FindBy(css= "[title =' Proceed to checkout']")
	WebElement proceedToCheckout;
	
	@FindBy (css = "[title = 'Add to my wishlist']")
	WebElement addTowishlistButton;
	
	@FindBy (css= "[class='fancybox-error']")
	WebElement addWishListMsg;
	
	@FindBy (css = "[class = fancybox-item fancybox-close']")
	WebElement addwishlistMsgclosebutton;
	
	public ProductDetailsPage(){ 
		PageFactory.initElements(driver, this); // constructor
	}
	
	public void verifyAddwishListMsg (){
		Assert.assertEquals(addWishListMsg.getText(), "added to you wishlist"); 
		addwishlistMsgclosebutton.click();
	}
		
		public ProductDetailsPage selectProductColor(String color){
			String locator = "[name ='"+color+"']";
			driver.findElement(By.cssSelector(locator)).click();
			return this;
					}
		public ProductDetailsPage inputQuantity (String quantity){
			quantityInput.clear();
			quantityInput.sendKeys(quantity);
			return this;
		}
		public ProductDetailsPage selectSize( String size){
			Select select = new Select (sizeDropDown);
			select.selectByVisibleText(size); 
			return this;
		}
		public ProductDetailsPage clickAddCart(){ // tajkia voice
			addCartButton.click();
			return this;
		}
		
		public ProductDetailsPage clickAddWishListButton(){
			addTowishlistButton.click();
			return this;
		}
		
		public OrderSummaryPage proceedToCheckout (){
			proceedToCheckout.click();
			return new OrderSummaryPage();
		}
		
		
		
}
		
	


