


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import org.jboss.netty.util.Timeout;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class StartAppTest {




	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	private static EnhancedAndroidDriver<WebElement> driver;
	private static  EnhancedAndroidDriver<WebElement> startApp() throws MalformedURLException  {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");																																														
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "03157df33ccbbd36");
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/Mobile/Desktop/Newjersy.apk");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
		//	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		//	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);

		URL url = new URL("http://localhost:4723/wd/hub");
		//	driver = (EnhancedAndroidDriver) new AndroidDriver(url, capabilities);


		return Factory.createAndroidDriver(url, capabilities);
	}


	@Test
	public void canStartAppInTest() throws Exception {
		driver = startApp();

		Thread.sleep(2000);

		//		WebDriverWait wait=new WebDriverWait(driver, 70);
		//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("slideNavButton")));
		MobileElement el1 = (MobileElement) driver.findElementById("slideNavButton");
		el1.click();
		driver.label("Menu button is tapping");
	     Thread.sleep(2000);
	     MobileElement el2 = (MobileElement) driver.findElementById("winningNumberSlide");
	     el2.click();
	     Thread.sleep(2000);
	     MobileElement el3 = (MobileElement) driver.findElementById("headerBackButton");
	     el3.click();
	     driver.label("Menu button is tapping again");
		Thread.sleep(5000);
		


	}

	@After
	public void after() throws Exception {
		if (driver != null) {
			driver.label("Stopping App");
			driver.quit();
		}
	}
}