package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AgentsPage;
import com.qa.pages.HomePage;
import com.qa.pages.SalesPage;

public class SalesPageTest extends TestBase {

	public HomePage homePage;
	public SalesPage salesPage;
	public AgentsPage agentsPage;

	public SalesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initailisation();
		homePage = new HomePage();
		salesPage = new SalesPage();
		agentsPage = new AgentsPage();
		homePage.searchLocation(prop.getProperty("cityName"));

	}

	/*
	 * @Test(priority = 1) public void checkSalesPageTitle() { String title =
	 * salesPage.checkHomePageTitle(); Assert.
	 * assertEquals("Property for Sale in London - Buy Properties in London - Zoopla"
	 * , title); }
	 * 
	 * @Test(priority = 2) public void checkSalesPageLogo() { Boolean flag =
	 * salesPage.verifySalesPageLogo(); Assert.assertTrue(flag); }
	 */

	@Test(priority = 1)
	public void printListOfValues() {
		salesPage.priceListPropReverse();
		salesPage.getPropertyByPosition(5);
		delay();
	}

	@Test(priority = 2)
	public void checkAgentsPageTitle() {
		agentsPage.getAgentsPageTitle();
	}

	@Test(priority = 3)
	public void printAgentsPhoneNum() {
		String phoneNum = agentsPage.getAgentsPhoneNum();
		System.out.println("Agents Phone Number is " + phoneNum);
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
