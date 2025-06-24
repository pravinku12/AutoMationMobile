package AppTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class APIDemosApp_Controls {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// app package and app activity- (io.appium.android.apis/io.appium.android.apis.ApiDemos)
		
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
		 cap.setCapability("appium:appPackage", "io.appium.android.apis");
		 cap.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		 
		 AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub") , cap);
		 
		 Thread.sleep(2000);
		 // Test start -Controls Action
		 
		 driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 driver.findElement(AppiumBy.accessibilityId("Controls")).click();
		 driver.findElement(AppiumBy.accessibilityId("1. Light Theme")).click();
		 driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("WelCome To Appium");
		 driver.findElement(AppiumBy.accessibilityId("Checkbox 1")).click();
		 driver.findElement(AppiumBy.accessibilityId("Checkbox 2")).click();
		 driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();
		 driver.findElement(By.id("io.appium.android.apis:id/toggle1")).click();
		 driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
		 driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Jupiter']")).click();
		 
		 driver.findElement(By.id("io.appium.android.apis:id/button")).click();
		 
		 System.out.println("Test Complete");
		 service.stop();
		
	}
}
