package app.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

public class HomeAndLivingMainPage {

	AppiumDriver driver = null;
	WebDriverWait wait;

	By tabHome = By.xpath("//android.widget.TextView[@content-desc=\"Home, \"]");
	By imgFurniture = By.xpath("(//android.widget.ImageView[@content-desc=\"iScaledImage0, \"])[1]/..");
	By banner = By.xpath("(//android.widget.HorizontalScrollView[@content-desc=\"RNCarousel, \"])[1]");

	public HomeAndLivingMainPage(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 55);
	}

	@Step
	public void scrollAndSelectForniture() {

		wait.until(ExpectedConditions.presenceOfElementLocated(banner));

		TouchAction action = new TouchAction(driver);
		action.press(new PointOption().withCoordinates(600, 2200)).moveTo(new PointOption().withCoordinates(600, 1200))
				.release().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(imgFurniture));

		WebElement eleFurniture = driver.findElement(imgFurniture);
		eleFurniture.click();

	}
}
