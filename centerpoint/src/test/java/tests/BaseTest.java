package tests;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import app.framework.driver_builders.AndroidDriverBuilder;
import app.framework.driver_builders.IOSDriverBuilder;
import app.framework.enums.PlatformName;
import io.appium.java_client.AppiumDriver;
import app.framework.utils.AppiumServerUtil;

public class BaseTest {

	public AppiumDriver driver;

	public static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void logMessage(String message) {
		logger.info(message);
	}

	@BeforeTest
	public void startAppiumServerUtil() throws IOException {
		killExistingAppiumProcess();
		if (AppiumServerUtil.appium == null || !AppiumServerUtil.appium.isRunning()) {
			AppiumServerUtil.start();
			logMessage("Appium server has been started");
		}
	}

	@Parameters({ "platformName" })
	@AfterTest
	public void stopAppiumServerUtil(String platformName) throws IOException {
		if (AppiumServerUtil.appium != null || AppiumServerUtil.appium.isRunning()) {
			AppiumServerUtil.stop();
			logMessage("Appium server has been stopped");
		}
	}

	@Parameters({ "platformName", "model" })
	@BeforeMethod
	public void setupDriver(String platformName, String model) throws IOException {
		setupMobileDriver(platformName, model);
	}

	public void setupMobileDriver(String platformName, String model) throws IOException {
		if (platformName.equalsIgnoreCase(PlatformName.ANDROID.toString())) {
			driver = new AndroidDriverBuilder().setupDriver(model);
		} else if (platformName.equalsIgnoreCase(PlatformName.IOS.toString())) {
			driver = new IOSDriverBuilder().setupDriver(model);
		}
		logMessage(model + " driver has been created for execution");
	}

	@AfterMethod
	public void teardownDriver() {
		driver.quit();
		logMessage("Driver has been quit from execution");
	}

	private void killExistingAppiumProcess() throws IOException {
		Runtime.getRuntime().exec("killall node");
		logMessage("Killing existing appium process");
	}
}
