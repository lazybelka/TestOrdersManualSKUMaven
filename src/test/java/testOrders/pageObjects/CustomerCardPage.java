package testOrders.pageObjects;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class CustomerCardPage extends TestHelper{
	
	public static String orderNumber = new String();
	
	public CustomerCardPage(){
		
	}

	public CustomerCardPage takeOrderNumber() {
		waitFor(By.id("headerToChange"));
		orderNumber = getText(By.id("headerToChange")).substring(20);
		System.out.println("Order number is " + orderNumber);
		
		return this;
	}

	public shipScriptPage shipOrder() {
		open(shipScriptPage + orderNumber);
		
		return new shipScriptPage();
	}

	public CustomerCardPage isOrderShipped() {
		wait(3);
		waitFor(By.id("commentID"));
		String orderStatus = new String();
		orderStatus = getText(By.cssSelector("label[id*='infoSaleStatus']"));
		
		if (orderStatus.contains("SHIPPED")){
			System.out.println("Order is shipped");
		}
		else {
			System.out.println("Error! Order status is " + orderStatus);
		}
		
		return this;
	}
	
	public CustomerCardPage takeCustomerCardScreenShoots(){
		wait(3);
		waitFor(By.id("commentID"));
		takeScreenShotInFolder("Order_Info-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.className("orderinfo_marketing"));
		click(By.className("orderinfo_marketing"));
		wait(4);
		takeScreenShotInFolder("Marketing_Info-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.className("orderinfo_history"));
		click(By.className("orderinfo_history"));
		wait(4);
		takeScreenShotInFolder("Order_History-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.className("orderinfo_general"));
		click(By.className("orderinfo_general"));
		wait(4);
		waitFor(By.className("paymentButton"));
		click(By.className("paymentButton"));
		wait(4);
		takeScreenShotInFolder("Advanced_Payments-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.className("generalinfo_generalpanel"));
		click(By.className("generalinfo_generalpanel"));
		wait(4);
		takeScreenShotInFolder("General_Panel-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.className("orderinfo_autoship"));
		click(By.className("orderinfo_autoship"));
		wait(4);
		takeScreenShotInFolder("Auto_Ship-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		return this;
	}

	public ViewPackingPage saveViewPackingPage(){
		wait(2);
		if(isElementPresent(By.className("shipped"))){
			click(By.className("shipped"));
		}
		else {
			takeScreenShotInFolder("Order_Status-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		}
		wait(5);
		try {
			fileMigration("PackingSlip.pdf", ItemDetailsPage.folderName + "/PackingSlip.pdf");
		}
		catch(FileNotFoundException e){
			System.out.println("File not found!");
		}
		return new ViewPackingPage();
	}

}
