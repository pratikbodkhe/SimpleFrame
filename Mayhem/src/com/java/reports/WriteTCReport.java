package com.java.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.java.commons.Constants;

public class WriteTCReport {
	
	public WriteTCReport(){
		String reportFolderName = new SimpleDateFormat(" d MMM yyyy")
		.format(new Date());
		File folder = new File(Constants.REPORT_PATH+reportFolderName);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		
	}

	public void testCaseExecutionStatus(String tc_ID) {
		
		String filename = new SimpleDateFormat(" d MMM yyyy HH_mm_ss")
		.format(new Date());
		File file = new File(Constants.REPORT_PATH+filename+".html");
		try {
			file.createNewFile();
			//FileInputStream fin = new FileInputStream(file);
			String content = "<!DOCTYPE html><html><body><table><tr><th>Firstname</th><th>Lastname</th>		<th>"+tc_ID+"</th></tr></body></html>";
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
			
			
			
			
			
		} catch (IOException e) {
			System.out.println("Write Failed");
			e.printStackTrace();
		}
		
		
		/* <!DOCTYPE html>
<html>

<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    text-align: center
}
th, td {
    padding: 5px;
}
th {
    text-align: center;
}
</style>
</head>

<body>

<table style="width:100%">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th>		
    <th>Points</th>
  </tr>
  <tr>
    <td>Jill</td>
    <td>Smith</td>		
    <td>50</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>Jackson</td>		
    <td>94</td>
  </tr>
  <tr>
    <td>John</td>
    <td>Doe</td>		
    <td>80</td>
  </tr>
</table>

</body>
</html>
*/
		
	}

	
	

}
