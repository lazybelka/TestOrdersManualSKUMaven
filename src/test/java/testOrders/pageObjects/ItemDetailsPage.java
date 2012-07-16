package testOrders.pageObjects;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

import testOrders.helper.TestHelper;

public class ItemDetailsPage extends TestHelper{
	
	public static  String SKU = new String();
	
	public static String folderName = new String();
	
	static Date date = new Date();
	static SimpleDateFormat exactDateFormat = new SimpleDateFormat("HH-mm-ss-dd-MM-yyyy");
	static String dateStr = exactDateFormat.format(date);
	
	public ItemDetailsPage(){
		
	}
	
	public ItemDetailsPage takeSKUAndCreateFolder() {
		waitFor(By.cssSelector("div[class='title rendered']"));
		wait(2);
		SKU = getText(By.id("edititem"));
		System.out.println("SKU was entered");
		wait(2);
		folderName = exactDateFormat.format(date) + "_" + SKU;
		File createdFolder = new File(folderName);
		createdFolder.mkdir();
		
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
		folderName = exactDateFormat.format(date) + SKU + "_";
		takeScreenShotInFolder("Item_Details-" + ItemDetailsPage.dateStr, folderName);
		
		return this;
	}
	
	public OfferOutlookPage openOfferOutlookPage() {
		open(offerOutlookPage + SKU);
		
		return new OfferOutlookPage();
	}

}
