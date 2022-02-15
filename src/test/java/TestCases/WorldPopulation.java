package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldPopulation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.worldometers.info/world-population/");
		String pop=driver.findElement(By.xpath("//div[@class=\"maincounter-number\"]")).getText();
		System.out.println("World population :"+pop);

		String xpath="//div[text()='Today' or 'This year']/parent::div/div/span[@class=\"rts-counter\"]";
		List<WebElement> headings=driver.findElements(By.xpath(xpath));
		
		for(WebElement ele:headings) {
			System.out.println("---->"+ele.getText());
		}
		driver.quit();
	}

}
