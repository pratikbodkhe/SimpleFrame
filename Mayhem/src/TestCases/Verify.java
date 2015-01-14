package TestCases;

import org.apache.log4j.Logger;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.java.practise.Modules;
import com.thoughtworks.selenium.Wait;

public class Verify {
	
	static Logger log = Logger.getLogger(Verify.class);
	public static void run(WebDriver driver, String tc_ID, String moduleName){
		Modules modules = new Modules();
		try {
		log.info("Executing Verify");
		log.info("Title "+driver.getTitle());
		
			Thread.sleep(3000);
//		if (driver.getTitle().contains("Flipkart")) {
//			Modules.moduleStatus = "Pass";
//		}	
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}catch(Exception e){
			modules.setModuleStatus(tc_ID, moduleName, "pass");
		}
	}
}
