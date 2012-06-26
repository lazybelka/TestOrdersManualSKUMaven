package testOrders.pageObjects;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class ItemDetailsPage extends TestHelper{
	
	public static  String SKU = new String();
	static Date date = new Date();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	public static String folderName = new String();
	
	static SimpleDateFormat exactDateFormat = new SimpleDateFormat("HH-mm-dd-MM-yyyy");
	static String dateStr = exactDateFormat.format(date);
	
	public ItemDetailsPage(){
		
	}
	
	public ItemDetailsPage takeSKUAndCreateFolder() {
		waitFor(By.cssSelector("div[class='title rendered']"));
		wait(2);
		SKU = getText(By.id("edititem"));
		System.out.println("SKU was entered");
		wait(2);
		folderName = SKU + "_" + dateFormat.format(date);
		
		return this;
	}

	public ItemDetailsPage takeItemDetailsScreenShoot() {
		waitFor(By.cssSelector("div[class='title rendered']"));
		wait(2);
		SKU = getText(By.id("edititem"));
		System.out.println("SKU was entered");
		waitFor(By.id("expandbutton"));
		click(By.id("expandbutton"));
		wait(2);
		folderName = SKU + "_" + dateFormat.format(date);
		takeScreenShotInFolder("Item_Details-" + ItemDetailsPage.dateStr, folderName);
		
		return this;
	}
	
	public OfferOutlookPage openOfferOutlookPage() {
		open(offerOutlookPage + SKU);
		
		return new OfferOutlookPage();
	}

}
