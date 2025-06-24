package AppTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AndroidNative_ContactDailer {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// command to know apppackage and appactivity
		//adb shell dumpsys window | findstr "mCurrentFocus" - execute on cmd
		// app package and app activity - (com.android.contacts/com.android.contacts.activities.TwelveKeyDialer)
		
		 File js = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		 
		 AppiumDriverLocalService service=new AppiumServiceBuilder()
				 .withAppiumJS(js)
				 .withIPAddress("127.0.0.1")
				 .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
				 .usingPort(4723)
				 .build();
		 service.start();
		 
		 DesiredCapabilities cap=new DesiredCapabilities();
		 cap.setCapability("platformName", "Android");
		 cap.setCapability("appium:automationName", "UiAutomator2");
		 cap.setCapability("appium:deviceName", "Xiaomi 24066PC951");
		 cap.setCapability("appium:platformVersion", "15");
		 cap.setCapability("appium:appPackage", "com.android.contacts");
		 cap.setCapability("appium:appActivity", "com.android.contacts.activities.TwelveKeyDialer");
		 
		 AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		  Thread.sleep(2000);
		 
		  driver.findElement(By.id("com.android.contacts:id/nine")).click();
		  driver.findElement(By.id("com.android.contacts:id/eight")).click();
		  driver.findElement(By.id("com.android.contacts:id/two")).click();
		  driver.findElement(By.id("com.android.contacts:id/one")).click();
		  driver.findElement(By.id("com.android.contacts:id/zero")).click();
		  driver.findElement(By.id("com.android.contacts:id/two")).click();
		  driver.findElement(By.id("com.android.contacts:id/six")).click();
		  driver.findElement(By.id("com.android.contacts:id/seven")).click();
		  driver.findElement(By.id("com.android.contacts:id/two")).click();
		  driver.findElement(By.id("com.android.contacts:id/one")).click();
		  
		  driver.findElement(By.id("com.android.contacts:id/single_call_button")).click();
		  
		  driver.findElement(By.id("com.android.incallui:id/endButton")).click();
		  
		  service.stop();
		  

	}
}
