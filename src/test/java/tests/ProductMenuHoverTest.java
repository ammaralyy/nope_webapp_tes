package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductMenuHoverTest extends TestBase {
	
	HomePage homepageObject;

	@Test
	public void userOpenNotebookpage() throws InterruptedException {
		
		homepageObject = new HomePage(driver);
		homepageObject.opennotebookMenu();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		
		System.out.println(driver.getCurrentUrl());
		
	}
	
}
