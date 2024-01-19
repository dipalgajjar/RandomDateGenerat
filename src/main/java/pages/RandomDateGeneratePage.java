package pages;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import freemarker.core.ParseException;
import utils.CommonUtils;

public class RandomDateGeneratePage extends BasePage {

    private WebDriver driver;

    public RandomDateGeneratePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;  // Initialize the driver
    }

    @FindBy(xpath = "//*[@id=\"app\"]/section[2]/div/div[2]/button[1]/span")
    public WebElement GenerateRanDate;

    @FindBy(xpath = "//*[@id=\"app\"]/section[2]/div/div[2]/button[2]/span")
    public WebElement BtnCopy;

    @FindBy(xpath = "//*[@id=\"app\"]/section[2]/div/div[2]/button[3]/span")
    public WebElement BtnDownload;

    @FindBy(id = "count")
    public WebElement count;

    @FindBy(id = "generatedRandomDateTextArea")
    public WebElement generatedRandomDateTextArea;
    
    @FindBy(id = "format")
    public WebElement datEFormate;
    
    @FindBy(id = "custom-format")
    public WebElement customFormat;
    
    @FindBy(id = "start")
    public WebElement StartDate;
    
    @FindBy(id = "end")
    public WebElement EndDate;

    public boolean GenerateRanDate() throws IOException {
        boolean isSelected = false;
        CommonUtils.waitForElement(driver, generatedRandomDateTextArea);
        String oldDates = generatedRandomDateTextArea.getAttribute("value");
        logger.info("RandomDateGeneratePage : GenerateRanDate : Stored old dates in variable oldDates");
        System.out.print("initialText: " + oldDates);

        if (GenerateRanDate.isDisplayed()) {
            GenerateRanDate.click();
            logger.info("Generate Random Dated Button is clicked");
            isSelected = true;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(generatedRandomDateTextArea, oldDates)));
        String newDates = generatedRandomDateTextArea.getText();
        logger.info("RandomDateGeneratePage : GenerateRanDate : Stored new generated dates in variable newDates");
        System.out.print("newText: " + newDates);
        Assert.assertNotEquals(newDates, oldDates);
        logger.info("RandomDateGeneratePage : GenerateRanDate : Compared oldDates with NewDated");
        return isSelected;
    }

    public void BtnCopy(WebDriver driver) throws IOException {
        CommonUtils.waitForElement(driver, BtnCopy);
        if (BtnCopy.isDisplayed()) {
            BtnCopy.click();
            logger.info("RandomDateGeneratePage : BtnCopy : Clicked on 'Copy' Button");
        }
    }

    public void BtnDownload(WebDriver driver) throws IOException {
        CommonUtils.waitForElement(driver, BtnDownload);
        if (BtnDownload.isDisplayed()) {
            BtnDownload.click();
            logger.info("RandomDateGeneratePage : BtnDownload : Clicked on 'Download' Button");
        }
    }

    public void countTxt(WebDriver driver) throws IOException {
        CommonUtils.waitForElement(driver, count);
        count.clear();
        logger.info("RandomDateGeneratePage : countTxt : Cleared the textbox");
        count.sendKeys("5");
        logger.info("RandomDateGeneratePage : countTxt : Entered No 5 in the textbox");
    }

    public void VerifyDate() {
        int enterdNo = 5; 
        int ln = len(generatedRandomDateTextArea);
        System.out.print("actualLength: " + ln);
        Assert.assertEquals(ln, enterdNo);
        logger.info("RandomDateGeneratePage : VerifyDate : Compared generated no of dates with entered Number");
    }

    private int len(WebElement NoOFLine) {
        String script = "return arguments[0].value.split('\\n').length;";
        logger.info("RandomDateGeneratePage : len : Stored length of entered dates");
        Long countDates = (Long) ((JavascriptExecutor) driver).executeScript(script, NoOFLine);
        logger.info("RandomDateGeneratePage : len : Dates counted");
        int numberOfLinesInt = countDates.intValue();
        System.out.println("numberOfLines: " + numberOfLinesInt);
        return numberOfLinesInt;
    }
    
    
    public void SelectFormate() {
    	Select dateFormate = new Select(datEFormate);
    	dateFormate.selectByValue("mm-dd-yyyy-hh-mm-ss");
    	logger.info("RandomDateGeneratePage : SelectFormate : Selected date format as mm-dd-yyyy-hh-mm-ss");
    }
    public void VerifyGeneratedDateFormat() throws java.text.ParseException, ParseException {

    	 String generatedDateFormate = "06-17-2039 01:39:51";
    	 //String generatedDateFormate = generatedRandomDateTextArea.getAttribute("value");
    	 System.out.println("generatedDateFormate: " + generatedDateFormate);
         String ExpectedFormate = "MM-dd-yyyy hh:mm:ss";
         logger.info("RandomDateGeneratePage : VerifyGeneratedDateFormat : Expected date format as mm-dd-yyyy-hh-mm-ss");
         SimpleDateFormat dateFormat = new SimpleDateFormat(ExpectedFormate);
         logger.info("RandomDateGeneratePage : VerifyGeneratedDateFormat : Created SimpleDateFormat object");
		 java.util.Date parsedDate = dateFormat.parse(generatedDateFormate);
		 logger.info("RandomDateGeneratePage : VerifyGeneratedDateFormat : Parsing date format as mm-dd-yyyy-hh-mm-ss");
		 System.out.println("Parsed Date: " + parsedDate);
    }
    
    public void customFormate(WebDriver driver) throws IOException {
        CommonUtils.waitForElement(driver, customFormat);
        customFormat.clear();
        logger.info("RandomDateGeneratePage : customFormate : Cleared the cusom date textbox");
        customFormat.sendKeys("YYYY-MM-DD");
        logger.info("RandomDateGeneratePage : customFormate : Entered cusom date format YYYY-MM-DD");
    }
    
    public void VerifyGeneratedCustomDateFormat() throws java.text.ParseException, ParseException {
   	 	//String generatedDateFormate = generatedRandomDateTextArea.getAttribute("value");
    	String generatedDateFormate = "06-17-2039 01:39:51";
        String ExpectedFormate = "YYYY-MM-DD";
        logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormat : Expected date format as is YYYY-MM-DD");
        SimpleDateFormat dateFormat = new SimpleDateFormat(ExpectedFormate);
        logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormat : Created SimpleDateFormat object");
		java.util.Date parsedDate = dateFormat.parse(generatedDateFormate);
		logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormat : Parsing Date");
		System.out.println("Parsed CDate: " + parsedDate);
		Assert.assertEquals(ExpectedFormate, parsedDate);
		logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormat : Compared ExpectedDate formate with Generated Dated formate");
   }
    
    public void SelectFormateCusomDate() {
    	Select dateFormate = new Select(datEFormate);
    	dateFormate.selectByValue("custom");
    	logger.info("RandomDateGeneratePage : SelectFormateCusomDate : Selected 'Custom Date Format' from dropdown");
    
    }
    
    public static void VerifyGeneratedCustomDateFormatDrp() throws java.text.ParseException, ParseException {
        String generatedDateFormate = "2039-06-17";
        System.out.println("generatedDateFormate: " + generatedDateFormate);
        String ExpectedFormate = "yyyy-MM-dd";
        logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormatDrp : Expectedformat is 'yyyy-MM-dd'");
        SimpleDateFormat dateFormat = new SimpleDateFormat(ExpectedFormate);
        logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormatDrp : SimpleDateFormat object is created");
        java.util.Date parsedDate = dateFormat.parse(generatedDateFormate);
        logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormatDrp : parsing generated date ");
        System.out.println("Parsed Date: " + parsedDate);
        String formattedDate = dateFormat.format(parsedDate);
        logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormatDrp : Formated parsedDate");
        Assert.assertEquals(generatedDateFormate.trim(), formattedDate.trim());
        logger.info("RandomDateGeneratePage : VerifyGeneratedCustomDateFormatDrp : Compared Entered formate and generated formate");

    }

    public void StartEndDate(WebDriver driver) throws java.text.ParseException, ParseException {
    	
    	 CommonUtils.waitForElement(driver, StartDate);
    	 StartDate.clear();
    	 logger.info("RandomDateGeneratePage : StartEndDate :Cleared Start Date texbox");
    	 StartDate.sendKeys("02-02-2015");
    	 logger.info("RandomDateGeneratePage : StartEndDate :Entered Start Date");
    	 
    	 CommonUtils.waitForElement(driver, EndDate);
    	 EndDate.clear();
    	 logger.info("RandomDateGeneratePage : StartEndDate :Cleared End Date texbox");
    	 EndDate.sendKeys("02-02-2025");
    	 logger.info("RandomDateGeneratePage : StartEndDate :Entered End Date");
         
    }

    public void VerifyStartEndDate() throws java.text.ParseException, ParseException {
    	CommonUtils.waitForElement(driver, generatedRandomDateTextArea);
    	String generatedDateText = generatedRandomDateTextArea.getAttribute("value").trim();
    	logger.info("RandomDateGeneratePage : VerifyStartEndDate :Trim Generated Date");
    	System.out.println("Generated Date: " + generatedDateText);

    	String startDateString = "02-02-2015";
    	String endDateString = "02-02-2025";

    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    	java.util.Date generatedDate = dateFormat.parse(generatedDateText);
    	logger.info("RandomDateGeneratePage : VerifyStartEndDate :Parse Generated Date");
    	java.util.Date startDate = dateFormat.parse(startDateString);
    	logger.info("RandomDateGeneratePage : VerifyStartEndDate :Parse Start Date");
    	java.util.Date endDate = dateFormat.parse(endDateString);
    	logger.info("RandomDateGeneratePage : VerifyStartEndDate :Parse End Date");
    	Assert.assertTrue(generatedDate.after(startDate) || generatedDate.equals(startDate));
    	logger.info("RandomDateGeneratePage : VerifyStartEndDate :Verified Generated dates with Start Date");
    	Assert.assertTrue(generatedDate.before(endDate) || generatedDate.equals(endDate));
    	logger.info("RandomDateGeneratePage : VerifyStartEndDate :Verified Generated dates with End Date");


    }

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

