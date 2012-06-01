package testOrders.pageObjects;

import testOrders.helper.TestHelper;

import testOrders.pageObjects.TestOrdersPage;

public class shipScriptPage extends TestHelper{
	
	public shipScriptPage(){
		
	}

	public CustomerCardPage returnToCustomerCardPage() {
		wait(10);
		open(customerCardPage + TestOrdersPage.invoiceNumber);
		
		return new CustomerCardPage();
	}

}
