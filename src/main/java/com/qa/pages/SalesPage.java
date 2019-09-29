package com.qa.pages;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class SalesPage extends TestBase{
	
	@FindBy(xpath = "//img[contains(@class,'icon--logo')]")
	WebElement salesPageLogo;
	
	@FindBy(xpath = "//li[contains(@id, 'listing')]//a[@class = 'listing-results-price text-price']")
	List<WebElement> priceListProp;
	
	
	public SalesPage() {
		PageFactory.initElements(driver, this);
	}

	
	public String checkHomePageTitle() {
	String title =	driver.getTitle();
	return title;
	}
	
	public Boolean verifySalesPageLogo() {
		return salesPageLogo.isDisplayed();
	
		}
	
	//To Get all Values and Print them in Descending Order
		List<Integer> priceList = new ArrayList<Integer>();
		
		public void priceListPropReverse() {
			for(WebElement propertyPrice : priceListProp) {
				
				if(propertyPrice.getText().replaceAll("[^0-9]", "").isEmpty()) {
					System.out.println(propertyPrice.getText() + " This is string value");
				}
				
				else {
					System.out.println(priceList.add(Integer.parseInt(propertyPrice.getText().replaceAll("[^0-9]", ""))));
				}
			}
			
			System.out.println("List of prop will arrange in descending order");
			Collections.sort(priceList, Collections.reverseOrder());
			System.out.println(priceList);
			delay();
		}
		
		
		
		public AgentsPage getPropertyByPosition(int position) {
			priceListProp.get(position).click();
			return new AgentsPage();
		}
		
	
	
}
