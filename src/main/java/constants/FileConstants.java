package constants;

import utils.CommonUtils;

public class FileConstants {
	public static final String REPORT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/"+CommonUtils.getStringDateAndTimeStamp()+"_randomdate.html";
	public static final String SCREENSHOT_PATH =  System.getProperty("user.dir") + "/src/main/resources/reports/"+CommonUtils.getStringDateAndTimeStamp()+"_randomdate.PNG";
}