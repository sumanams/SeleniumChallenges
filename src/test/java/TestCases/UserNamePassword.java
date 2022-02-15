package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserNamePassword {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.findElement(By.xpath("//input[@placeholder='First Enter name']")).sendKeys("sumana");
		driver.findElement(By.xpath("//input[@placeholder='Enter Last name']")).sendKeys("jois");
	}

}
