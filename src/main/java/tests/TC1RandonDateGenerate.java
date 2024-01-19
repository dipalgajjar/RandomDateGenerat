package tests;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import pages.RandomDateGeneratePage;
import utils.CommonUtils;



public class TC1RandonDateGenerate extends BaseTest{
	@Test(enabled = true , priority = 1)
	public void RDGTC1() throws InvalidFormatException, IOException{
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver Configured");
		driver.get("https://codebeautify.org/generate-random-date");
		BaseTest.test.info("Random Date Generater Page displayed");
		RandomDateGeneratePage rp = new RandomDateGeneratePage(driver);
		try {
			rp.GenerateRanDate();
			BaseTest.test.info("Generate Random Date button is clicked");
			rp.BtnCopy(driver);
			BaseTest.test.info("Copy Button is clicked");
			rp.BtnDownload(driver);
			BaseTest.test.info("Download Button is clicked");
			BaseTest.test.pass("RDGTC1 PASSED");
			
		}catch (AssertionError e) {
			BaseTest.test.info("RDGTC1 Failed");
			BaseTest.test.log(Status.FAIL, "Test Failed: " + e.getMessage());
	        BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));
	        throw e; 
	    }
		
	
		
	}
	@Test(enabled = true , priority = 2)
	public void RDGTC2() throws InvalidFormatException, IOException{
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver Configured");
		driver.get("https://codebeautify.org/generate-random-date");
		BaseTest.test.info("Random Date Generater Page displayed");
		RandomDateGeneratePage rp = new RandomDateGeneratePage(driver);
		try {
			rp.countTxt(driver);
			BaseTest.test.info("Number 5 is added");
			rp.VerifyDate();
			BaseTest.test.info("Generated Dates verified with added number");
			BaseTest.test.pass("RDGTC2 PASSED");
		}catch (AssertionError e) {
			BaseTest.test.info("Dates are not matching with entered number");
			BaseTest.test.log(Status.FAIL, "Test Failed: " + e.getMessage());
	        BaseTest.test.info("Random Date Generater Page displayed");
	        throw e; 
	    }
	}
	
	@Test(enabled = true , priority = 3)
	public void RDGTC3SelectFormate() throws InvalidFormatException, IOException, ParseException{
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver Configured");
		driver.get("https://codebeautify.org/generate-random-date");
		BaseTest.test.info("Random Date Generater Page displayed");
		RandomDateGeneratePage rp = new RandomDateGeneratePage(driver);
		try {
			rp.SelectFormate();
			BaseTest.test.info("MM-dd-yyyy hh:mm:ss is selected from dropdown");
			rp.VerifyGeneratedDateFormat();
			BaseTest.test.info("Verified Generated Dates are as per selected formate");
			BaseTest.test.pass("RDGTC3SelectFormate PASSED");
			
		}catch (AssertionError e) {
			BaseTest.test.info("Verified Generated Dates are  not as per selected formate");
			BaseTest.test.log(Status.FAIL, "Test Failed: " + e.getMessage());
	        BaseTest.test.info("Random Date Generater Page displayed");
	        throw e; 
	    }
	}
	
	@Test(enabled = true , priority = 4)
	public void RDGTC4Customormate() throws InvalidFormatException, IOException, ParseException{
		
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver Configured");
		driver.get("https://codebeautify.org/generate-random-date");
		BaseTest.test.info("Random Date Generater Page displayed");
		try {
			RandomDateGeneratePage rp = new RandomDateGeneratePage(driver);
			rp.customFormate(driver);
			BaseTest.test.info("Custom date Format 'MM-dd-yyyy' is added");
			rp.VerifyGeneratedCustomDateFormat();
			BaseTest.test.info("Verified Generated Dates are as per entered custom format");
			BaseTest.test.pass("RDGTC4Customormate PASSED");
	    } catch (AssertionError e) {
	    	BaseTest.test.warning("Generated Dates are not as per entered custom format 'MM-dd-yyyy'");
	    	BaseTest.test.log(Status.FAIL, "Test Failed: " + e.getMessage());
	        BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));
	        throw e; 
	    }
		
	}
	
	@Test(enabled = true , priority = 5)
	public void RDGTC5CustomormateDrp() throws InvalidFormatException, IOException, ParseException{
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver Configured");
		driver.get("https://codebeautify.org/generate-random-date");
		BaseTest.test.info("Random Date Generater Page displayed");
		RandomDateGeneratePage rp = new RandomDateGeneratePage(driver);
		try {
			rp.SelectFormateCusomDate();
			BaseTest.test.info("Select Cutom Date Format from Dropdown");
			rp.customFormate(driver);
			BaseTest.test.info("Enter custom date formate");
			rp.VerifyGeneratedCustomDateFormatDrp();
			BaseTest.test.info("Verified Generated Dates are as per entered custom format");
			BaseTest.test.pass("RDGTC5CustomormateDrp PASSED");
		} catch (AssertionError e) {
			BaseTest.test.log(Status.FAIL, "Test Failed: " + e.getMessage());
			BaseTest.test.info("Generated Dates are not as per entered custom format");
	        BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));
	        throw e; 
	    }
	}
	
	@Test(enabled = true , priority = 6)
	public void RDGTC6StartEndDate() throws InvalidFormatException, IOException, ParseException{
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver Configured");
		driver.get("https://codebeautify.org/generate-random-date");
		BaseTest.test.info("Random Date Generater Page displayed");
		RandomDateGeneratePage rp = new RandomDateGeneratePage(driver);
		try {
			rp.StartEndDate(driver);
			BaseTest.test.info("Entered Start as '02-02-2015' and End Date as '02-02-2025'");
			BaseTest.test.info("Verified Dates are generated between Start date'02-02-2015' and End Date as '02-02-2025'");
			BaseTest.test.pass("RDGTC6StartEndDate PASSED");
		}catch (AssertionError e) {
			BaseTest.test.log(Status.FAIL, "Test Failed: " + e.getMessage());
			BaseTest.test.info("Dates are  not generated between Start date'02-02-2015' and End Date as '02-02-2025'");
	        BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));
	        throw e; 
	    }
	}
	

}
