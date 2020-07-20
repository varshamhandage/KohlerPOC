package BaseCapability;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseCapability 
{

	public static AndroidDriver<AndroidElement> driver;
	Properties prop=new Properties();
	public static AndroidDriver<AndroidElement> capabilities(String device) throws IOException 
	{
		
		//reading prperties file
		Properties prop=new Properties();
		FileInputStream PropFile = new FileInputStream(System.getProperty("user.dir")+"\\Config\\Config.properties");									
	    prop.load(PropFile);
	    
	    File f=new File("src");
		File fs=new File(f,"Original.apk");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
	
	     	if(prop.getProperty("deviceName").equals("real"))
	     		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
	     	else
	         cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Shree");
		
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("AutomationName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		cap.setCapability("fullReset", "false");
		cap.setCapability("noReset", "true");
		cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;

	}
}
