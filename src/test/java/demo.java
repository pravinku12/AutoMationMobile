import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class demo {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		
		//File app=new File("C:\\Users\\DELL\\Downloads\\ApiDemo.apk");
		File app=new File("C:\\Users\\DELL\\Downloads\\General-Store.apk");
		
		 File js = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		 
		 
		 AppiumDriverLocalService service = new AppiumServiceBuilder()
                 .withAppiumJS(js)
                 .withIPAddress("127.0.0.1") // Use correct local IP
                 .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                 .usingPort(4723)
                 .build();

         service.start();
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:deviceName", "Xiaomi 24066PC951");
		caps.setCapability("appium:platformVersion", "15");
		caps.setCapability("appium:app", app.getAbsolutePath());

		// (Optional but recommended)
		//caps.setCapability("appium:ignoreHiddenApiPolicyError", true);

		//URL appiumServerUrl = new URL("http://127.0.0.1:4723/");
		//AndroidDriver driver = new AndroidDriver(appiumServerUrl, caps);
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		
		 service.stop(); // Stop Appium service


		//driver.quit();
		Thread.sleep(2000);
		
		
	}
}
