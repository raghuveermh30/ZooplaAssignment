/**
 * 
 */
package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.SalesPage;

/**
 * @author raghuveer.mh
 *
 */
public class HomePageTest extends TestBase {

	 HomePage homePage;
	 SalesPage salesPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initailisation();
		homePage = new HomePage();
		salesPage = new SalesPage();
	}

	/*@Test(priority = 1)
	public void checkHomePageTitle() {
		String title = homePage.validateTitle();
		System.out.println(title);
		Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", title);
	}

	@Test(priority = 2)
	public void checkHomePageLogo() {
		boolean flag = homePage.verifyLogo();
		Assert.assertTrue(flag);
	}*/

	@Test(priority = 1)
	public void enterSearchDetails() {
		homePage.searchLocation(prop.getProperty("cityName"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
