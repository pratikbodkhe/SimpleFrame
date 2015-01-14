package com.java.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.java.commons.*;

import org.apache.commons.io.FileUtils;

import com.java.commons.Constants;

public class WriteTCReport {

	public WriteTCReport() {
		String reportFolderName = new SimpleDateFormat(" d MMM yyyy")
				.format(new Date());
		File folder = new File(Constants.REPORT_PATH + reportFolderName);
		if (!folder.exists()) {
			folder.mkdirs();
		}

	}

	public void testCaseExecutionStatus(String tc_ID) {

		String filename = new SimpleDateFormat(" d MMM yyyy HH_mm_ss")
				.format(new Date());
		File file = new File(Constants.REPORT_PATH + filename + ".html");
		try {
			File htmlTemplateFile = new File(Constants.TEMPLATE_PATH
					+ "template.html");
			String htmlString = FileUtils.readFileToString(htmlTemplateFile);
			String title = "Execution Report "
					+ new SimpleDateFormat(" dd MMM yyyy").format(new Date());
			Variables variables = new Variables();
			String result = " <tr> <td>" + tc_ID + "</td> <td>"
					+ variables.getTC_Name() + "</td> <td>"
					+ variables.getStartedOn() + "</td> <td>"
					+ variables.getCompletedOn() + "</td> <td>1 min</td> <td>"
					+ System.getProperty("user.name") + "</td> </tr>";
			htmlString = htmlString.replace("$title", title);
			int index = htmlString.lastIndexOf("$result");
			System.out.println("index     - - - - "+index);
			htmlString = htmlString.substring(0,
					htmlString.lastIndexOf("$result"))
					+ result
					+ htmlString.substring(htmlString.lastIndexOf("$result"));
			file.createNewFile();
			FileUtils.writeStringToFile(file, htmlString);

			System.out.println(" Report Writing Done");

		} catch (IOException e) {
			System.out.println("Write Failed");
			e.printStackTrace();
		}

	}

}
