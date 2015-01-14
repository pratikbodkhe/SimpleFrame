package com.java.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Homepage {
static Logger log = Logger.getLogger(Homepage.class);
	
	class Categories{
		public WebElement Electronics(WebDriver driver){
			WebElement element =  driver.findElement(By.linkText("ELECTRONICS"));
			return element;	
		}
		
		public WebElement men(WebDriver driver){
			WebElement element =  driver.findElement(By.linkText("MEN"));
			return element;	
		}
		
		public WebElement women(WebDriver driver){
			WebElement element =  driver.findElement(By.linkText("WOMEN"));
			return element;	
		}
		
	}

	public WebElement loginButton(WebDriver driver){
		WebElement element =  driver.findElement(By.linkText("Login"));
		return element;	
	}
	
	public WebElement  loginSignUpDialog(WebDriver driver){
		WebElement element = driver.findElement(By.id("login-signup-dialog"));
		log.info("Login Box - "+element.getText());
		return element;
	
	}
	
	public WebElement username(WebDriver driver){
		WebElement element =  driver.findElement(By.id("login_email_id"));
		return element;	
	}
	public WebElement password(WebDriver driver){
		WebElement element =  driver.findElement(By.id("login_password"));
		return element;	
	}
	public WebElement popUpLoginClose(WebDriver driver){
		WebElement element =  driver.findElement(By.cssSelector("body > div.fk-ui-dialog.dialog-login-signup > div.window.alpha30 > span"));
		return element;	
	}
	public WebElement loginErrorMsg(WebDriver driver){
		WebElement element =  driver.findElement(By.id("login_tiny_help_message"));
		return element;	
	}
	
}
