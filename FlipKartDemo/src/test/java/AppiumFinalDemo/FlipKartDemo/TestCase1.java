package AppiumFinalDemo.FlipKartDemo;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import PageObjects.SearchPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCase1 extends BasicSetup
{
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void addtocart(String searchkey) throws IOException, InterruptedException
	{
		//startServer();//starts the appium server
		
		AndroidDriver<AndroidElement> driver=setup();
		
		System.out.println(searchkey);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SearchPage searchPage=new SearchPage(driver);
		searchPage.searchbox.click();
			
			
			
		
		 Utilities u=new Utilities(driver);
	     u.scrollToText("cash on delivery");
	    
	     searchPage.paymentOptions.click();
	     
	     searchPage.confirm.click();
	     
	     searchPage.placeOrderfinal.click();
	     
		
		//service.stop();//stops the appium server
		
	}

}
