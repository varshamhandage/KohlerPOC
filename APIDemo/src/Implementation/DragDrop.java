package Implementation;

import org.testng.annotations.Test;
import static io.appium.java_client.touch.offset.ElementOption.element;

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

public class DragDrop extends BaseCapability{

	@Test
	public void dragTest() throws IOException 
	{
		AndroidDriver <AndroidElement>driver=capabilities("device");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		WebElement source=driver.findElementsByClassName("android.view.View").get(0);
		WebElement Dest=driver.findElementsByClassName("android.view.View").get(1);		
		TouchAction t=new TouchAction(driver);
		//t.longPress(longPressOptions().withElement(element(source))).moveTo(element(Dest)).release().perform();
		t.longPress(element(source)).moveTo(element(Dest)).release().perform();
		//driver.closeApp();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}

}
