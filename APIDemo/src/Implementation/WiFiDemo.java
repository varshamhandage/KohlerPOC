package Implementation;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseCapability.BaseCapability;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class WiFiDemo extends BaseCapability
{
	@Test
	public void wifiSettings() throws IOException
	{
		AndroidDriver <AndroidElement>driver=capabilities("device");
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Varsha");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
}
