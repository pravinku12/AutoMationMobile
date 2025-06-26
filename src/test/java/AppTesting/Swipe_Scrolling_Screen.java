package AppTesting;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Swipe_Scrolling_Screen {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		File js = new File("C:\\Users\\DELL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		AppiumDriverLocalService service=new AppiumServiceBuilder()
				.withAppiumJS(js)
				.withIPAddress("127.0.0.1")
				.withArgument(GeneralServerFlag.BASEPATH,"/")
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

		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
		Thread.sleep(2000);

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		/*driver.findElement(AppiumBy.accessibilityId("Controls")).click();
		 driver.findElement(AppiumBy.accessibilityId("1. Light Theme")).click();
		 driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();

		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Uranus']")).click();

		 */



		// scroll gesture code

		//Get Screen size



		//Get Screen size
				Dimension size = driver.manage().window().getSize();
				
				//find the position where you need to touch
				int startX = size.getWidth() / 2;
				int startY = size.getHeight() / 2;
				
				//position till you want to move your finger to swipe
				int endX = startX;
				int endY = (int) (size.getHeight() * 0.25);
				
				//PointerInput class to create a sequence of actions 
				PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
				
				//Sequence object, which is a list of actions that will be performed on the device
				Sequence sequence = new Sequence(finger1, 1)
						.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
						.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
						.addAction(new Pause(finger1, Duration.ofMillis(200))) //wait for some time
						.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
						.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

				//perform the Sequence of action
				driver.perform(Collections.singletonList(sequence));


		/*
		 * boolean canScrollMore = (Boolean) ((JavascriptExecutor)
		 * driver).executeScript( "mobile: scrollGesture", ImmutableMap.of( "left", 100,
		 * "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 1.0,
		 * // 30% of scroll area height "duration", 2000 // in milliseconds (optional) )
		 * );
		 */
		Thread.sleep(2000);
		service.stop();











	}
}
