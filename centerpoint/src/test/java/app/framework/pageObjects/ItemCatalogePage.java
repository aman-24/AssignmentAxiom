package app.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;


public class ItemCatalogePage {

	
	AppiumDriver driver = null;
	WebDriverWait wait;

	public ItemCatalogePage(AppiumDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 55);
	}

	/**
	 * 
	 * @param index(Starts from 0)
	 * @return array with name and price of item
	 */
	@Step
	public String[] getDetailsAndSelectItemByIndex(int index) {
		String[] details = new String[2];

		WebElement item = driver.findElement(
				By.xpath("(//android.view.ViewGroup[@content-desc=\"viwProductImage, \"])[" + index + "]/.."));

		WebElement itemName = driver.findElement(
				By.xpath("(//android.widget.TextView[@content-desc=\"txtProductTitle, \"])[" + index + "]"));
		details[0] = itemName.getText();

		WebElement itemPrice = driver
				.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"txtPrice, \"])[" + index + "]"));
		details[1] = itemPrice.getText();

		item.click();

		return details;

	}

}
