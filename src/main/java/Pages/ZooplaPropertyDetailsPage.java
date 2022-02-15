package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZooplaPropertyDetailsPage {
	public WebDriver driver;
	private By agentName=By.xpath("//div[contains(@class,'AgentNameBlock')]/p");
	private By agentDetailsLink=By.xpath("//a[normalize-space()='View agent properties']");
	
	public ZooplaPropertyDetailsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	public WebElement getAgentName() {
		return driver.findElement(agentName);
	}
	public WebElement getAgentDetailsLink() {
		return driver.findElement(agentDetailsLink);
	}
}
