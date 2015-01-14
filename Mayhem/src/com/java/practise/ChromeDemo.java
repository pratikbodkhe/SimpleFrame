package com.java.practise;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.java.commons.Constants;

public class ChromeDemo {

	public void startChrome(WebDriver driver, Properties property) {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("chrome successfully started");
		driver.get(Constants.URLPath);
	}

	public void test(WebDriver driver) throws InterruptedException {
		int count = 0;
		driver.findElement(By.name("q")).sendKeys("Barney Stinson", Keys.ENTER);
		Thread.sleep(3000);
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("there are " + links.size()
				+ " Links on the webpage");
		for (WebElement webElement : links) {
			if (webElement.getText().contains("Stinson")) {
				count++;
				System.out.println(webElement.getText());
			}

		}
		System.out.println(count + " Links Contains the word 'Sherlock'");
		driver.quit();
	}
}
