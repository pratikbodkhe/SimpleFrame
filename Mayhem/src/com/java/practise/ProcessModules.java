package com.java.practise;

import org.openqa.selenium.WebDriver;

import TestCases.Login;
import TestCases.Verify;

public class ProcessModules {

	public static void execute(String moduleName,String tc_ID, WebDriver driver) {
		// TODO Auto-generated method stub
		Modules modules = new Modules();
		
		if (moduleName.equalsIgnoreCase("login")) {
		Login.run(driver, tc_ID, moduleName);
		}
		if (moduleName.equalsIgnoreCase("verify")) {
			Verify.run(driver, tc_ID, moduleName);
		}
		
	}

}
