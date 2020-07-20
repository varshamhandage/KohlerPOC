package Implementation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import BaseCapability.BaseCapability;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ScrollTest extends BaseCapability
{
	@Test
	public void ScrollDemo() throws IOException
	{
	AndroidDriver <AndroidElement>driver=capabilities("device");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Rating Bar\"));");
	//driver.closeApp();
	driver.pressKey(new KeyEvent(AndroidKey.HOME));
}
}
