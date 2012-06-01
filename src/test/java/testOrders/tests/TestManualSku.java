package testOrders.tests;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
		.openTestOrdersPage()
		.fillTestValues()
		.takeInvoiceNumber()
		.openCustomerCardPage()
		.takeCustomerCardScreenShoots()
		.takeOrderNumber()
		.shipOrder()
		.returnToCustomerCardPage()
		.isOrderShipped()
		.openViewPackingPage()
		
		;
	}
	
	@BeforeTest
	public void getDriver(){
		
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("ACMG");
		
		driver = new FirefoxDriver(profile);
		driver.get(TestHelper.logInPage);
	}
	
	@AfterTest
	public void closeDriver() {
		
	        driver.close();
		
	}

}
