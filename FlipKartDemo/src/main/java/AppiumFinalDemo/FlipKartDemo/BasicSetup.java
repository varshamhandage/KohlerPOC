package AppiumFinalDemo.FlipKartDemo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BasicSetup
{
	public static AndroidDriver<AndroidElement> driver;
	/*public AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer()
	{
	 service = AppiumDriverLocalService.buildDefaultService();
	 service.start();
	 return service;
	}*/
	public static AndroidDriver<AndroidElement> setup() throws IOException
	{
		
		//reading global.properties file
		Properties prop=new Properties();
		FileInputStream PropFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\AppiumFinalDemo\\FlipKartDemo\\global.properties");									
	    prop.load(PropFile);
	    
	     
	    System.out.println();
		File f=new File("src");
		File fs=new File(f,prop.getProperty("appName"));
	    
	    
		DesiredCapabilities cap=new DesiredCapabilities();
		
	
	     	if(prop.getProperty("deviceName").equals("real"))
	     		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	     	else
	     		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Shree");
		
		
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator1");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability("fullReset", "false");
		cap.setCapability("noReset", "true");
		
		cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
		driver=new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void getScreenShot(String test) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Infogain\\Appium\\ScreenShot\\"+test+".png"));
		
	}
	
}
