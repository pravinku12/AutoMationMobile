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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput.Origin;
import java.time.Duration;
import java.util.Arrays;

public class LongPress_Gesture {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {


		File js = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		AppiumDriverLocalService service=new AppiumServiceBuilder()
				.withAppiumJS(js)
				.withIPAddress("127.0.0.1")
				.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub")
				.usingPort(4723)
				.build();
		service.start();

		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:automationName", "UiAutomator2");
		cap.setCapability("appium:deviceName", "Xiaomi 24066PC951");
		cap.setCapability("appium:platformVersion", "15");
		cap.setCapability("appium:appPackage", "com.android.contacts");
		cap.setCapability("appium:appActivity", "com.android.contacts.activities.TwelveKeyDialer");

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		Thread.sleep(2000);

		driver.findElement(By.id("com.android.contacts:id/nine")).click();
		driver.findElement(By.id("com.android.contacts:id/four")).click();
		driver.findElement(By.id("com.android.contacts:id/one")).click();
		driver.findElement(By.id("com.android.contacts:id/zero")).click();
		driver.findElement(By.id("com.android.contacts:id/eight")).click();
		driver.findElement(By.id("com.android.contacts:id/zero")).click();
		driver.findElement(By.id("com.android.contacts:id/three")).click();
		driver.findElement(By.id("com.android.contacts:id/six")).click();
		driver.findElement(By.id("com.android.contacts:id/one")).click();
		driver.findElement(By.id("com.android.contacts:id/seven")).click();
		//driver.findElement(By.id("com.android.contacts:id/two")).click();
		// driver.findElement(By.id("com.android.contacts:id/one")).click();

		//Long press gesture code 
		

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Delete phone number"));

		// Long press using W3C Actions
		Sequence longPress = new Sequence(finger, 1);
		longPress.addAction(finger.createPointerMove(Duration.ZERO, Origin.fromElement(element), 0, 0));
		longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		longPress.addAction(new Pause(finger, Duration.ofSeconds(1))); // hold duration
		longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Arrays.asList(longPress));


		
		
		//driver.findElement(AppiumBy.accessibilityId("Delete phone number")).click();
		//driver.findElement(By.id("com.android.contacts:id/clear_button"));
		//driver.findElement(By.id("com.android.contacts:id/single_call_button")).click();

		service.stop();
	}
}
