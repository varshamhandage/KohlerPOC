package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage
{
	public SearchPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.flipkart.android:id/search_widget_textbox")
	public WebElement searchbox;
	
	@AndroidFindBy(xpath="//*[@text='Apple iPhone 7 (Rose Gold, 256 GB)']")
	public WebElement selectItem;
	
	public WebElement getSelectedItem()
	{
		return selectItem;
	}
	
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	public WebElement addItem;
	

	//android.widget.TextView
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Place Order']")
	public WebElement placeOrder;
			
	@AndroidFindBy(xpath="//*[@text='CONTINUE']")
	public WebElement OrderSCont;//OrderSummary Page
	
	@AndroidFindBy(xpath="//*[@text='radio-deselected-afef00dd']")
	public WebElement paymentOptions;//Payment Page
	
	@AndroidFindBy(xpath="//*[@text='CONTINUE']")
	public WebElement confirm;
	
	@AndroidFindBy(xpath="//*[@text='PLACE ORDER']")
	public WebElement placeOrderfinal;
	

}









