package testOrders.pageObjects;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class ItemDetailsPage extends TestHelper{
	
	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	public static String folderName = "screenShotsFolder-" + dateFormat.format(date);
	
	static SimpleDateFormat exactDateFormat = new SimpleDateFormat("HH-mm-dd-MM-yyyy");
	static String dateStr = exactDateFormat.format(date);
	
	public ItemDetailsPage(){
		
	}

	public ItemDetailsPage takeItemDetailsScreenShoot() {
//		waitForElementVisible(By.id("edittitle"));
		waitFor(By.cssSelector("div[class='title rendered']"));
		wait(30);
		wait(2);
		waitFor(By.id("expandbutton"));
		click(By.id("expandbutton"));
		wait(2);
		takeScreenShotInFolder("Item_Details-" + ItemDetailsPage.dateStr, folderName);
		
		return this;
	}
	
	public TestOrdersPage openTestOrdersPage() {
		open(testOrdersPage);
		
		return new TestOrdersPage();
	}
	
	

}
