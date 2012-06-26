package testOrders.tests;

import org.testng.annotations.Test;

import testOrders.helper.TestHelper;
import testOrders.pageObjects.MattminLogIn;

public class TestManualSku extends TestHelper{
	
	@Test
	public void ManualEnterSkuTest(){
		new MattminLogIn()
		.logIn()
		.clickHereToContinue()
		.openItemsPage()
		.enterSKU()
		.takeItemDetailsScreenShoot()
		.openOfferOutlookPage()
		.saveOfferOutlookPage()
		.openTestOrdersPage()
		.fillTestValues()
		.takeInvoiceNumber()
		.openCustomerCardPage()
		.takeCustomerCardScreenShoots()
		.takeOrderNumber()
		.shipOrder()
		.returnToCustomerCardPage()
		.isOrderShipped()
		.saveViewPackingPage()
		
		;
	}

}
