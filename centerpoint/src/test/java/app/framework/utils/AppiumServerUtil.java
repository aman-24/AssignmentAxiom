package app.framework.utils;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import tests.BaseTest;

public class AppiumServerUtil {
	
	 public static AppiumDriverLocalService appium;

	    public static void start() throws IOException {
	        AppiumServiceBuilder builder = new AppiumServiceBuilder()
	                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
	                .withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	        appium = builder.build();
	        appium.start();
	        BaseTest.logMessage("Appium server has been started");
	    }

	    public static void stop() throws IOException {
	        appium.stop();
	        BaseTest.logMessage("Appium server has been stopped");
	    }

}
