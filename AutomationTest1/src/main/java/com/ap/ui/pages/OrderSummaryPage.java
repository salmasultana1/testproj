package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ap.ui.base.TestBase;

public class OrderSummaryPage extends TestBase {
	@FindBy(css="[class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedToCheckOutButton;
	
	@FindBy(xpath="//*[@id='order_step']/li[3]/span")
	WebElement proceedToAdressButton;
	
	@FindBy(xpath="//*[@id='order_step']/li[4]/span")
	WebElement processToCarrierButton;
	
	@FindBy(id="cgv")
	WebElement termsAndCondition;
	
	@FindBy(css="[class='bankwire']")
	WebElement payByBankWire;
	
	@FindBy(xpath="//*[@id='cart_navigation']/button/span")
	WebElement confirmOrder;
	
	@FindBy(css="[class='navigation_page']")
	WebElement OrderConfirm;
	
	public OrderSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	public OrderSummaryPage proceedCheckOut(){
		proceedToCheckOutButton.click();
		return this;
	}
	public OrderSummaryPage proceedAdessCheckOut(){
		proceedToAdressButton.click();
		return this;
	}
	public OrderSummaryPage proceedShipping(){
		termsAndCondition.click();
		processToCarrierButton.click();
		return this;
	}
	public OrderSummaryPage confirmOrder(){
		payByBankWire.click();
		confirmOrder.click();
		return this;
	}
	public String getConfirmationMessage(){
		return OrderConfirm.getText();
	}
	
	
	

}
	
	