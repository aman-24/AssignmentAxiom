package app.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class SelectCatagoryPage {
	
	AppiumDriver driver = null;
	WebDriverWait wait;

	By eleHomeAndLiving = By.xpath("(//android.widget.ImageView[@content-desc=\"iScaledImage2, \"])[1]/..");
	
	public SelectCatagoryPage(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 55);
	}
	
	@Step
	public void selectHomeAndLivingCat() {
		WebElement homeandLiving = driver.findElement(eleHomeAndLiving);
		wait.until(ExpectedConditions.presenceOfElementLocated(eleHomeAndLiving));
		homeandLiving.click(); 
	}
	
}
