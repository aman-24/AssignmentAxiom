package app.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;

public class ItemDetailsPage {

	AppiumDriver driver = null;
	WebDriverWait wait;

	By lblItemName = By.xpath("//android.widget.TextView[@content-desc=\"txtProductTitle, \"]");
	By lblItemPrice = By.xpath("(//android.widget.TextView[@content-desc=\"txtPrice, \"])[2]");
	By btnAddToBasketButton = By.xpath("//android.view.ViewGroup[@content-desc=\"btnAddToBasketButton, \"]");
	By btnStartShopping = By.xpath("//android.view.ViewGroup[@content-desc=\"btnStartShopping, \"]");

	public ItemDetailsPage(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 55);
	}

	@Step
	public String[] getDetailsAndClickToBasket() {
		String[] itemDetails = new String[2];
		wait.until(ExpectedConditions.presenceOfElementLocated(btnAddToBasketButton));

		itemDetails[0] = driver.findElement(lblItemName).getText();
		itemDetails[1] = driver.findElement(lblItemPrice).getText();

		driver.findElement(btnAddToBasketButton).click();
		return itemDetails;
	}

	@Step
	public void clickContinueShopping() {
		driver.findElement(btnStartShopping).click();
	}
}
