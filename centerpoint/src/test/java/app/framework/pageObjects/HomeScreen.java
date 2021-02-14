package app.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app.framework.enums.Countries;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class HomeScreen {

	AppiumDriver driver = null;
	WebDriverWait wait;
	
	By eleUAELang = By.xpath("//android.view.ViewGroup[@content-desc=\"twfButton_en_0, \"]");
	By btnContinue = By.xpath("//android.view.ViewGroup[@content-desc=\"btnContinue, \"]");


	public HomeScreen(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 55);
	}

	@Step
	public void slectCountry(Countries country) throws InterruptedException {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(eleUAELang));
		driver.findElement(eleUAELang).click();
		driver.findElement(btnContinue).click();
	}
}
