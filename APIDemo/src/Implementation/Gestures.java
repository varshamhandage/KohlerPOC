package Implementation;

import org.testng.annotations.Test;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseCapability.BaseCapability;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Gestures extends BaseCapability
{
	@Test
	public void Guesture() throws IOException
	{
		//covered topics tap and longPress
		
				AndroidDriver <AndroidElement>driver=capabilities("device");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//tap
				driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
				WebElement wb=driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
				TouchAction t=new TouchAction(driver);
				t.tap(tapOptions().withElement(element(wb))).perform();
				
				//longPress
				driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
				
				//WebElement wb1=driver.findElementsByClassName("android.widget.TextView").get(0);
				WebElement wb1=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
				t.longPress(longPressOptions().withElement(element(wb1)).withDuration(ofSeconds(5))).release().perform();
				driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed();
				//driver.closeApp();
				driver.pressKey(new KeyEvent(AndroidKey.HOME));
				
	}
	
}
