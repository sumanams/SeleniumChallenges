package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZooplaSearchPage {
	public WebDriver driver;
	private By propertyList=By.xpath("//p[@data-testid=\"listing-description\"]");
	private By propPrice=By.xpath("//div[@data-testid=\"listing-price\"]/p[@class='css-1o565rw-Text eczcs4p0']");
	public ZooplaSearchPage(WebDriver driver) {
		
		this.driver = driver;
	}
	public List<WebElement> getPropertyList() {
		return driver.findElements(propertyList);
	}
	
	public List<WebElement> getpropPriceList() {
		return driver.findElements(propPrice);
	}
	
	
}
