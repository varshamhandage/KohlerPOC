package Implementation;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
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

public class SwipeDemo extends BaseCapability
{
	@Test
	public void swipeTest() throws IOException
	{
		AndroidDriver <AndroidElement>driver=capabilities("device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc=9]").click();
		WebElement first=driver.findElementByXPath("//*[@content-desc=15]");
		WebElement second=driver.findElementByXPath("//*[@content-desc=45]");
		TouchAction t=new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(4))).moveTo(element(second)).release().perform();
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
