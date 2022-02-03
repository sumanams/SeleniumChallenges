package SeleniumChallenges.SeleniumChallenges;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceChallenge {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		List<WebElement> priceList=driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));

		Float max=(float) 0, rate=(float) 0;

		for(WebElement ele: priceList) {
			String price=ele.getText();
			price=price.substring(1);
			rate = Float.parseFloat(price);

			if(rate>max) {
				max=rate;
			}
		}
		String xpath="//div[text()=\""+rate+"\"]//following-sibling::button";
		
		driver.findElement(By.xpath(xpath)).click();
		assertEquals(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText(), "1");
		
		driver.quit();

	}

}
