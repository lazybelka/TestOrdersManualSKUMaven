package testOrders.pageObjects;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class TestOrdersPage extends TestHelper{
	
	public static String invoiceNumber = new String();

	public TestOrdersPage fillTestValues() {
		waitFor(By.id("ship_firstname"));
		fill(By.id("ship_firstname"), "test-" + ItemDetailsPage.dateStr);
		fill(By.id("firstname"), "test-" + ItemDetailsPage.dateStr);
		fill(By.id("patternName"), "test");
		fill(By.id("cardNumber"),card);
		fill(By.id("cardCCV"),"111");
		System.out.println("Please enter SKU, wait for XML forming and than press Submit");
		
	return this;
		
	}

	public TestOrdersPage takeInvoiceNumber() {
		waitFor(By.cssSelector("a[href*='https://devtest.acmgaces.com/mattmin_zf/customercard/order/']"));
		wait(2);
		invoiceNumber = getText(By.cssSelector("a[href*='https://devtest.acmgaces.com/mattmin_zf/customercard/order/']"));
		System.out.println("Invoice number is " + invoiceNumber);
		
		return this;
		
	}
	
	public CustomerCardPage openCustomerCardPage(){
		open(customerCardPage + invoiceNumber);
		
		return new CustomerCardPage();
	}
	

}
