package TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.java.pageObject.Homepage;
import com.java.practise.Modules;


public class Login {
	
	static Logger log = Logger.getLogger(Login.class);
	public static void run(WebDriver driver, String tc_ID, String moduleName){
		log.info("Executing Login");
		Homepage homepage = new Homepage();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get("http://www.flipkart.com");
		
		Modules modules = new Modules();
		try {
			Thread.sleep(5000);
			homepage.loginButton(driver).click();
			//homepage.loginSignUpDialog(driver);
			homepage.username(driver).clear();
			homepage.username(driver).sendKeys("pratikbodkhe@gmail.com");
			homepage.password(driver).sendKeys("Motion@1234");
			homepage.password(driver).submit();
			
			if (homepage.loginErrorMsg(driver).isDisplayed()) {
				log.error(homepage.loginErrorMsg(driver).getText());
				homepage.popUpLoginClose(driver).click();
				//driver.quit();
				
				modules.setModuleStatus(tc_ID, moduleName, "pass");
				}
			else{
				modules.setModuleStatus(tc_ID, moduleName, "fail");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e){
			log.error("Some error occured");
			modules.setModuleStatus(tc_ID, moduleName, "fail");
			e.getMessage();
			e.printStackTrace();
		}
		
		
	}
}
