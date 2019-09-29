package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AgentsPage extends TestBase {

	@FindBy(xpath = "(//div[@class = 'ui-agent__logo'])[1]")
	WebElement agentsLogo;

	@FindBy(xpath = "//a[@data-track-label='Agent phone number 1']")
	WebElement phoneNum;

	public AgentsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getAgentsPageTitle() {
		return driver.getTitle();
	}

	public String getAgentsPhoneNum() {
	return 	phoneNum.getText();
	}
}
