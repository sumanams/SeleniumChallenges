package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZooplaAgentDetails {
	public WebDriver driver;
	private By agentName=By.xpath("//div[contains(@class,'AgentNameBlock')]/p");
	private By agentAddress=By.xpath("//div[@class='agent_address']/p");
	private By agentPhone=By.xpath("//span[contains(text(),'Call')]/a");
	
	public ZooplaAgentDetails(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement getAgentName() {
		return driver.findElement(agentName);
	}
	
	public WebElement getAgentAddress() {
		return driver.findElement(agentAddress);
	}
	
	public WebElement getAgentPhone() {
		return driver.findElement(agentPhone);
	}
	
}
