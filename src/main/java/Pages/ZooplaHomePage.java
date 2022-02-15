package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZooplaHomePage {
	public WebDriver driver;
	private By searchArea=By.xpath("//input[@id='header-location']");
	private By searchBtn=By.xpath("//button[normalize-space()='Search']");
	
	
	public ZooplaHomePage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getSearchArea() {
		return driver.findElement(searchArea);
	}
	
	public WebElement getSearchBtn() {
		return driver.findElement(searchBtn);
	}
	
	
	
}
