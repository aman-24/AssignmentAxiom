package tests;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import app.framework.enums.Countries;
import app.framework.pageObjects.HomeAndLivingMainPage;
import app.framework.pageObjects.HomeScreen;
import app.framework.pageObjects.ItemCatalogePage;
import app.framework.pageObjects.ItemDetailsPage;
import app.framework.pageObjects.SelectCatagoryPage;

public class AddToCartTest extends BaseTest{
	
	@Test(description = "Testing add to cart functionality with multiple units of same item in Home and Living")
	public void test_AddProductToCart_2() throws InterruptedException {
		
		HomeScreen homeScreen = new HomeScreen(driver);
		homeScreen.slectCountry(Countries.UAE);
		
		SelectCatagoryPage seleCatpage = new SelectCatagoryPage(driver);
		seleCatpage.selectHomeAndLivingCat(); 
		
		HomeAndLivingMainPage homeMain = new HomeAndLivingMainPage(driver);
		homeMain.selectForniture();
		
		ItemCatalogePage itemCatPage = new ItemCatalogePage(driver);
		String[] itemAtCatPage = itemCatPage.getDetailsAndSelectItemByIndex(1);
		
		ItemDetailsPage detailsPage = new ItemDetailsPage(driver);
		String[] itemAtDetailsPage = detailsPage.getDetailsAndClickToBasket();
		detailsPage.clickContinueShopping();
		detailsPage.getDetailsAndClickToBasket();
		
		Assert.assertTrue(Arrays.equals(itemAtCatPage, itemAtDetailsPage) );
		
	}
	

}
