package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import Pages.Base;
import Pages.ZooplaAgentDetails;
import Pages.ZooplaHomePage;
import Pages.ZooplaPropertyDetailsPage;
import Pages.ZooplaSearchPage;


public class ZooplaHomePageTest extends Base {
	@BeforeTest
	public void testSetup() throws IOException {
		driver = initializeDriver();
		driver.get("https://www.zoopla.co.uk/");
	}
	
	@Test
	public void enterSearchCriteria() {

		//Create a new object of Landing page to access the methods there
		ZooplaHomePage zHome=new ZooplaHomePage(driver);
		zHome.getSearchArea().sendKeys("London");
		zHome.getSearchBtn().click();
		
		ZooplaSearchPage zSearch=new ZooplaSearchPage(driver);
		
		//Get the list of properties
		List<WebElement> propList=zSearch.getPropertyList();
		for (WebElement property:propList) {
			System.out.println(property.getText());
		}
		
		//Get the list of prices
		List<WebElement> propPriceList=zSearch.getpropPriceList();
		for (WebElement price:propPriceList) {
			System.out.println(price.getText());
		}
		
		//Click on the 5th item
		propPriceList.get(5).click();
		
		//Get the agent Details
		ZooplaPropertyDetailsPage propDetails=new ZooplaPropertyDetailsPage(driver);
		propDetails.getAgentName();
		propDetails.getAgentDetailsLink().click();
		
		ZooplaAgentDetails agentDetails=new ZooplaAgentDetails(driver);
		//System.out.println("Agent Name :" + agentDetails.getAgentName().getText());
		System.out.println("Agent Address : " + agentDetails.getAgentAddress().getText());
		System.out.println("Agent Phone : " + agentDetails.getAgentPhone().getText());
	}

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
