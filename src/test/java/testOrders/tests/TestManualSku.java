package testOrders.tests;

import org.testng.annotations.Test;

import testOrders.helper.TestHelper;
import testOrders.pageObjects.MattminLogIn;
import testOrders.pageObjects.TestOrdersPage;

public class TestManualSku extends TestHelper{
	
	@Test
	public void ManualEnterSkuTest(){
		new MattminLogIn()
		.logIn()
		.clickHereToContinue()
		.openItemsPage()
		.enterSKU()
		.takeSKUAndCreateFolder()
		.openOfferOutlookPage()
		.saveOfferOutlookPage()
		.openTestOrdersPage()
		.fillTestValues();
		if (noSuchElementException) {
			new TestOrdersPage()
			.invoiceNumberErrorProcessing();
		}
		else {
			new TestOrdersPage()
			.takeInvoiceNumber()
			.openCustomerCardPage()
			.takeCustomerCardScreenShoots()
			.takeOrderNumber()
			.shipOrder()
			.returnToCustomerCardPage()
			.isOrderShipped()
			.saveViewPackingPage();
			
			;
		}
	}

}
