package testOrders.pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class TestOrdersPage extends TestHelper{
	
	public static String invoiceNumber = new String();

	public TestOrdersPage fillTestValues() {
		waitFor(By.id("ship_firstname"));
		fill(By.id("patternName"), "test");
		fill(By.id("cardNumber"),card);
		fill(By.id("cardCCV"),"111");
		System.out.println("Please check is XML is formed and press Submit");
		
	return this;
		
	}

	public TestOrdersPage takeInvoiceNumber() {
		waitFor(By.cssSelector("a[href*='https://devtest.acmgaces.com/mattmin_zf/customercard/order/']"));
		wait(2);
		System.out.println("SKU was entered");
		invoiceNumber = getText(By.cssSelector("a[href*='https://devtest.acmgaces.com/mattmin_zf/customercard/order/']"));
		System.out.println("Invoice number is " + invoiceNumber);
		
		return this;
		
	}
	
	public TestOrdersPage waitForInvoiceNumber(){
		waitFor(By.cssSelector("a[href*='https://devtest.acmgaces.com/mattmin_zf/customercard/order/']"));
		
		return this;
	}
	
	public TestOrdersPage invoiceNumberErrorProcessing() {
		Date date = new Date();
		SimpleDateFormat exactDateFormat = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");
		takeScreenShotInFolder("Error_invoice_number-" + exactDateFormat.format(date), ItemDetailsPage.folderName);
		System.out.println("Getting invoice number error! Look at screenshot in SKU folder");
		
		return this;
	}
	
	public CustomerCardPage openCustomerCardPage(){
		open(customerCardPage + invoiceNumber);
		
		return new CustomerCardPage();
	}
	

}
