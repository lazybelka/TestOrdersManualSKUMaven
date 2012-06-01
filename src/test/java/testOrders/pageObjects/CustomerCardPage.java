package testOrders.pageObjects;

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
		
//		waitForVisible(By.className("autoshipGridTitle"));
//		click(By.className("autoshipGridTitle"));
//		wait(2);
//		takeScreenShotInFolder("Auto_Ship-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
//		
//		waitForVisible(By.className("marketingInfoTitle"));
//		click(By.className("marketingInfoTitle"));
//		wait(2);
//		takeScreenShotInFolder("Marketing_Info-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
//		
//		waitForVisible(By.className("orderHistoryTitle"));
//		click(By.className("orderHistoryTitle"));
//		wait(2);
//		takeScreenShotInFolder("Order_History-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
//		
//		waitForVisible(By.className("customerInfoPanel"));
//		click(By.className("customerInfoPanel"));
//		wait(2);
//		takeScreenShotInFolder("General_Panel-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
//		
//		waitForVisible(By.className("orderTabTitle"));
//		click(By.className("orderTabTitle"));
//		wait(2);
//		waitForVisible(By.className("paymentButton"));
//		click(By.className("paymentButton"));
//		wait(2);
//		takeScreenShotInFolder("Advanced_Payments-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		


		
		waitFor(By.id("ext-comp-1249__ext-comp-1272"));
		click(By.id("ext-comp-1249__ext-comp-1272"));
		wait(4);
		takeScreenShotInFolder("Auto_Ship-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.id("ext-comp-1249__ext-comp-1243"));
		click(By.id("ext-comp-1249__ext-comp-1243"));
		wait(4);
		takeScreenShotInFolder("Marketing_Info-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.id("ext-comp-1249__order-history"));
		click(By.id("ext-comp-1249__order-history"));
		wait(4);
		takeScreenShotInFolder("Order_History-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.id("ext-comp-1249__ext-comp-1227"));
		click(By.id("ext-comp-1249__ext-comp-1227"));
		wait(4);
		waitFor(By.className("paymentButton"));
		click(By.className("paymentButton"));
		wait(4);
		takeScreenShotInFolder("Advanced_Payments-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		waitFor(By.id("mainTabs__ext-comp-1172"));
		click(By.id("mainTabs__ext-comp-1172"));
		wait(4);
		takeScreenShotInFolder("General_Panel-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		
		return this;
	}

	public ViewPackingPage openViewPackingPage() {
		wait(2);
		if(isElementPresent(By.className("shipped"))){
			click(By.className("shipped"));
		}
		else {
			takeScreenShotInFolder("Order_Status-" + ItemDetailsPage.dateStr, ItemDetailsPage.folderName);
		}
		wait(5);
		return new ViewPackingPage();
	}

}
