package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchInput;
	
	@FindBy(xpath = "//ul[contains(@class, 'ui-autocomplete')]")
	List<WebElement> list;
	
	@FindBy(xpath = "//button[@class = 'button button--primary']")
	WebElement searchButton;
	
	@FindBy(xpath = "//img[contains(@class,'icon--logo')]")
	WebElement zooplaLogo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String validateTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	
	public boolean verifyLogo()
	{
		return zooplaLogo.isDisplayed();
	}
	
	public SalesPage searchLocation(String input) {
		searchInput.sendKeys(input);
		/*for(int i =0;i<list.size();i++) {
			if(list.get(i).getTagName().contains("London")) {
				list.get(i).click();
				break;
			}
		}*/
		searchButton.click();
		return new SalesPage();
	}

	
}
