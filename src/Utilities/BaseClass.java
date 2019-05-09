package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
 


public class BaseClass {
     ReadConfig read=new ReadConfig();
     public String baseUrl=read.getApplicationUrl();
     public String cPath=read.getChromePath();
     //Login page
	public String username=read.getUserName();
	public String password=read.getUserPassword();
	
	//Vacancy page
	public String dropNo=read.getDropNo();
	public String vName=read.getVName();
	public String mgName=read.getManagerName();
	public String noOfPosition=read.getNoOfPosition();
	public String desc=read.getDesc();
	
	//kpi page
	public String jobVal=read.getJobVal();
	public String indic=read.getIndic();
	public String min=read.getMin();
	public String max=read.getMax();
	
	//tracker page
	public String tName=read.getTrackerName();
	public String empVal=read.getEmpVal();
	
	
	public WebDriver driver;
	
	public static  ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

	@BeforeSuite
	public void startTest() {
		htmlReporter = new ExtentHtmlReporter("D:\\SeleniumTraining\\Report1236.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS", "Window 10");
        extent.setSystemInfo("Host Name", "Ankush");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Ankush Tanwar");
         
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
        htmlReporter.config().setReportName("My Own Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
		
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setUp(String br) {
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Ankush\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
//		ChromeOptions option= new ChromeOptions();
//		option.setHeadless(true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ankush\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			FirefoxOptions option =new FirefoxOptions();
			option.setHeadless(true);
			driver=new FirefoxDriver(option);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(baseUrl);
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Ankush\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.navigate().to(baseUrl);
		}
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterMethod
	public void testResult(ITestResult result)throws Exception {  
		
		if( result.getStatus()== ITestResult.SUCCESS) {
			
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		
		else if(result.getStatus() == ITestResult.FAILURE) {
			
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable());
			
			 //To add it in the extent report 
			String screenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+"ScreenS_001"+".png";
			
			File f = new File(screenshotPath); 
			
			if(f.exists())
			{
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
				} 
			catch (IOException e) 
					{
					e.printStackTrace();
					}
			}
			}
		else if (result.getStatus() == ITestResult.SKIP) {
			
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
		}
		
		//extent.endTest(logger);
	}
	

 
	
	@AfterSuite
	public void closeReport() {
		
		extent.flush();
		//extent.close();
	}
	



}
