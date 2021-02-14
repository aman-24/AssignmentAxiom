package app.framework.driver_builders;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import app.framework.config.DriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import tests.BaseTest;
import app.framework.utils.AndroidDeviceModel;
import app.framework.utils.FileUtility;

public class AndroidDriverBuilder extends DriverConfig {
	public AndroidDriver driver;

	public AndroidDriver setupDriver(String model) throws IOException {
		DesiredCapabilities androidCapabilities = new DesiredCapabilities();
		AndroidDeviceModel device = readAndroidDeviceConfig().getAndroidDeviceByName(model);
		BaseTest.logMessage("Received the " + model + " device configuration for execution");
		setExecutionPlatform(model);

		androidCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.getDeviceName());
		androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, device.getPlatformName());
		androidCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, device.getPlatformVersion());
		androidCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, device.getAutomationName());
		androidCapabilities.setCapability(MobileCapabilityType.NO_RESET, device.isReset());
		androidCapabilities.setCapability(MobileCapabilityType.APP,
				FileUtility.getFile(device.getApp()).getAbsolutePath());
		androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, device.getPackageName());
		androidCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, device.getActivity());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities);
		//putting implicit wait as app to be tested is slow
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		BaseTest.logMessage("Android driver has been created for the " + model + " device");
		return driver;
	}
}
