package testOrders.helper;

import testOrders.helper.TestHelper;

import framework.Framework;

public class TestHelper extends Framework{
	
	protected static final String logInPage_default = "https://devtest.acmgaces.com/access/login.php/";
	protected static final String testOrdersPage_default = "https://devtest.acmgaces.com/mattmin_zf/testorders/";
	protected static final String itemsPage_default = "https://devtest.acmgaces.com/mattmin/maintain/items/index.php";
	protected static final String customerCardPage_default = "https://devtest.acmgaces.com/mattmin_zf/customercard/order/";
	protected static final String shipScriptPage_default = "https://devtest.acmgaces.com/busTestScripts/labelOrder.php?orderId=";
	protected static final String user_default = "qauser";
	protected static final String password_default = "mnb234jn";
	protected static final String usermail_default = "lena@greenice.net";
	protected static final String passwordmail_default = "29011402dr";
	protected static final String sendmail_default = "lena@greenice.net";
	protected static final String card_default = "4111111111111111";
	protected static final String sku_default = "MST-BALM-25ML-30-C";
	
	public static String logInPage = logInPage_default;
	public static String testOrdersPage = testOrdersPage_default;
	public static String itemsPage = itemsPage_default;
	public static String customerCardPage = customerCardPage_default;
	public static String shipScriptPage = shipScriptPage_default;
	public static String user = user_default;
	public static String password = password_default;
	public static String usermail = usermail_default;
	public static String passwordmail = passwordmail_default;
	public static String sendmail = sendmail_default;
	public static String card = card_default;

}
