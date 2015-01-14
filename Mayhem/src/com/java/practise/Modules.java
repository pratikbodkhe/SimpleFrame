package com.java.practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.java.commons.Constants;
import com.java.commons.Variables;
import com.java.reports.WriteTCReport;

public class Modules {
	Logger log = Logger.getLogger(Modules.class);
	public void getModules(String tc_ID) {
		
		// TODO Auto-generated method stub
		log.info("Starting Execution of the test case -  " + tc_ID);
		String moduleStatus = "Fail" ;

		// System.out.println(Constants.EXCEL_PATH);
		List<String> modules = new ArrayList<String>();
		try {

			Workbook wb = new HSSFWorkbook(new FileInputStream(new File(
					Constants.EXCEL_PATH + tc_ID + ".xls")));
			org.apache.poi.ss.usermodel.Sheet tcFlow = wb.getSheet("TcFlow");
			// int moduleCount = tcFlow.getLastRowNum();
			for (Row row : tcFlow) {
				modules.add(row.getCell(0).getStringCellValue());
			}

		} catch (FileNotFoundException e) {
			log.error("TC Flow excel for test case " + tc_ID + " not found");
			//e.printStackTrace();
			System.exit(1);

		} catch (IOException e) {

			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", Constants.chromeEXE);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		for (String moduleName : modules) {
			if (moduleName.isEmpty()) {
				log.info("Test Case " + tc_ID + " ends");
				System.exit(0);
			} else {
				System.out.println("Current Module " + moduleName);
				//to be added 
				
				ProcessModules.execute(moduleName, tc_ID, driver);
				
				
			}

		}
		driver.quit();
		log.info(" Execution Complete for Test Case  - "+tc_ID);
		Variables variables = new Variables();
		variables.setCompletedOn(new Date().toString());
		WriteTCReport writeTCReport = new WriteTCReport();
		writeTCReport.testCaseExecutionStatus(tc_ID);
	}

	public void setModuleStatus(String tc_ID,String moduleName,String moduleStatus) {
		// TODO Auto-generated method stub
		if (moduleStatus.equalsIgnoreCase("pass")) {
			log.info("Writing status against module");
			NewFile.writeToExcel(tc_ID, moduleName);
		} else {
			NewFile.writeToExcel(tc_ID, moduleName);
		}
	}
	
	
}