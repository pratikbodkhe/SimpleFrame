package com.java.commons;

public class Variables {
	
	public static  String TC_ID = null;
	public static  String TC_Name = null;
	public static  boolean ExeStatus = false;
	public static  String startedOn = null;
	public static  String completedOn = null;
	
	
	public  String getTC_ID() {
		return TC_ID;
	}
	public void setTC_ID(String tC_ID) {
		TC_ID = tC_ID;
	}
	public  String getTC_Name() {
		return TC_Name;
	}
	public  void setTC_Name(String tC_Name) {
		TC_Name = tC_Name;
	}
	public  boolean getExeStatus() {
		return ExeStatus;
	}
	public  void setExeStatus(boolean b) {
		ExeStatus = b;
	}
	public  String getStartedOn() {
		return startedOn;
	}
	public  void setStartedOn(String startedOn) {
		Variables.startedOn = startedOn;
	}
	public  String getCompletedOn() {
		return completedOn;
	}
	public  void setCompletedOn(String completedOn) {
		Variables.completedOn = completedOn;
	}
	

}
