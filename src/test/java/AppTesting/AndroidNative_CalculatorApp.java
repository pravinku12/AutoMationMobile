package AppTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AndroidNative_CalculatorApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		 File js = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		 
		 AppiumDriverLocalService service= new AppiumServiceBuilder()
				 .withAppiumJS(js)
				 .withIPAddress("127.0.0.1")
				 .withArgument(GeneralServerFlag.BASEPATH, "/")
				 .usingPort(4723)
				 .build();
		 service.start();
		 
		 DesiredCapabilities caps=new DesiredCapabilities();
		 caps.setCapability("platformName", "Android");
		 caps.setCapability("appium:automationName", "UiAutomator2");
		 caps.setCapability("appium:deviceName", "Xiaomi 24066PC951");
		 caps.setCapability("appium:platformVersion", "15");
		 caps.setCapability("appium:appPackage", "com.miui.calculator");
		 caps.setCapability("appium:appActivity", "com.miui.calculator.cal.CalculatorActivity");
		 
		 AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"),caps);
		  
		 Thread.sleep(2000);
		 driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();
		 driver.findElement(By.id("com.miui.calculator:id/op_add")).click();
		 driver.findElement(By.id("com.miui.calculator:id/digit_9")).click();
		 driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
		 
		WebElement resulttxt= driver.findElement(By.id("com.miui.calculator:id/result"));
		String value=resulttxt.getText();
		String act_value=value.replace("=", "").trim();
		System.out.println(act_value);
		if(act_value.equals("14"))
		{
			System.out.println("Test Passed and value is equal");
		}
		else
		{
			System.out.println("Value not equal");
		}
		
		service.stop();
	
		 
				 
	}
}
