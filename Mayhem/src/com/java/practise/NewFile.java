package com.java.practise;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import com.java.commons.Constants;
import com.java.commons.Variables;

public class NewFile {
	static Logger log = Logger.getLogger(NewFile.class);

	public static void main(String[] args) throws InterruptedException {

		PropertyConfigurator.configure("log4j.properties");
		log.info("################        Start of Suite run       ############");
		// String orig = "My Name IS Khan";
		// String str = new StringBuilder(orig).reverse().toString();
		// // char[] chrArr = str.toCharArray();
		// HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		// for (int i = 0; i < str.length(); i++) {
		// if (!(map.containsKey(str.charAt(i)))) {
		// map.put(str.charAt(i), 1);
		//
		// } else {
		// map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
		// }
		// }
		//
		// System.out.println(map);
		// java.util.Iterator<Entry<Character, Integer>> itr = map.entrySet()
		// .iterator();
		// while (itr.hasNext()) {
		// Map.Entry<Character, Integer> mEntry = (Map.Entry<Character,
		// Integer>) itr
		// .next();
		// for (int i = 0; i < mEntry.getValue(); i++) {
		// System.out.print(mEntry.getKey());
		// }
		// }

		readExcel();

	}

	/**
	 * readExcel method read the driver excel from the excel path and checks the
	 * test cases for Yes flag
	 * 
	 */
	public static void readExcel() {
		// String cellValue = null;
		FileInputStream fIN;
		// Boolean exeFlag = false;

		// List<String> dataElements = new ArrayList<String>();
		try {
			fIN = new FileInputStream(System.getProperty("user.dir")
					+ "/resources/excel/workbook.xls");
			log.info("Reading Driver Sheet");
			Workbook wb;

			wb = new HSSFWorkbook(fIN);
			org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
			System.out.println("Last Row: " + sheet.getLastRowNum());

			// java.util.Iterator<Row> row = sheet.rowIterator();
			Row row = null;
			Cell cell = null;

			Row topRow = sheet.getRow(0);
			// System.out.println("Last Column: " + topRow.getLastCellNum());
			Variables variable = new Variables();
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				// System.out.println("\nCurrent Row : " + i);
				for (int j = 0; j < topRow.getLastCellNum(); j++) {
					if (sheet.getRow(i).getCell(j) == null) {
						cell = row.createCell(j);
						cell.setCellValue("BLANK");
					} else {
						cell = row.getCell(j);
					}
					if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						sheet.getRow(i).getCell(j)
								.setCellType(Cell.CELL_TYPE_STRING);

					}

					if (cell.getStringCellValue().equalsIgnoreCase("yes")) {
						variable.setExeStatus(true);
						variable.setTC_ID(row.getCell(0).getStringCellValue());
						variable.setTC_Name(row.getCell(1).getStringCellValue());
						variable.setStartedOn(new Date().toString());
						// log.info("Execution Starting for test cases "+variable.getTC_ID());
						Modules modules = new Modules();
						modules.getModules(variable.getTC_ID());

					} else {
						// System.out.println((row.getCell(j).getStringCellValue()));
					}

				}

			}
			fIN.close();

			// System.out.println(cell.getStringCellValue());
		} catch (FileNotFoundException e1) {
			log.error("Driver Excel Not found, Please check");
			try {

				Desktop.getDesktop().open(new File(Constants.EXCEL_PATH));
				System.exit(1);
			} catch (IOException e) {

			}
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void writeToExcel(String tc_ID, String moduleName) {
		try {

			FileInputStream fin = new FileInputStream(new File(
					Constants.EXCEL_PATH + tc_ID + ".xls"));

			Workbook wb = new HSSFWorkbook(fin);
			org.apache.poi.ss.usermodel.Sheet sheet1 = wb.getSheet("TcFlow");

			Iterator<Row> row = sheet1.rowIterator();
			while (row.hasNext()) {
				Row currentRow = (Row) row.next();
				if (currentRow.getCell(0).getStringCellValue()
						.contains(moduleName)) {
					currentRow.createCell(1).setCellType(Cell.CELL_TYPE_STRING);
					currentRow.getCell(1).setCellValue("Pass");
				}
			}
			fin.close();
			String filename = new SimpleDateFormat(" d MMM yyyy HH_mm_ss")
					.format(new Date());

			// System.out.println(filename);
			FileOutputStream fout = new FileOutputStream(new File(
					Constants.EXCEL_PATH + tc_ID + ".xls"));
			wb.write(fout);
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
