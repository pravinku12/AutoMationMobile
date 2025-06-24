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

public class General_store_loginscreen {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		File app=new File("C:\\Users\\DELL\\Downloads\\General-Store.apk");
		
		 File js = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		 
		 AppiumDriverLocalService service= new AppiumServiceBuilder()
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
		 cap.setCapability("appium:app", app.getAbsolutePath());
		 
		 AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		 
		// service.stop();
		 
		 
		 Thread.sleep(4000);
		 
		 driver.findElement(By.id("android:id/text1")).click();
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();
		 driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Zenny");
		 driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		 driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
}
