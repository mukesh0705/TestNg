package april7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AdvanceReport {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void generateReport() {
		//define html path
		report=new ExtentReports("./Reports/AReport.html");
	}
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}
	@Test
	public void testPass() {
		test=report.startTest("Test pass");
		test.assignAuthor("Mukesh");
		String Expected="Google";
		String Actual=driver.getTitle();
		if (Actual.equalsIgnoreCase(Expected)) {
			test.log(LogStatus.PASS,"Title is matching::"+Expected+"   "+Actual);
		} 
		else {
			test.log(LogStatus.FAIL,"Title is Not matching::"+Expected+"   "+Actual);
		}
	}
	@Test
	public void testFail() {
		test=report.startTest("Test pass");
		test.assignAuthor("Mukesh");
		String Expected="gmail";
		String Actual=driver.getTitle();
		if (Actual.equalsIgnoreCase(Expected)) {
			test.log(LogStatus.PASS,"Title is matching::"+Expected+"   "+Actual);
		} else {
			test.log(LogStatus.FAIL,"Title is Not matching::"+Expected+"   "+Actual);
		}
	}
	@Test
	public void testPass2() {
		driver.get("http://orangehrm.qedgetech.com/");
		test=report.startTest("Test pass");
		test.assignAuthor("Mukesh");
		String Expected="OrangeHRM";
		String Actual=driver.getTitle();
		if (Expected.equalsIgnoreCase(Actual)) {
			test.log(LogStatus.PASS,"Title is matching::"+Expected+"   "+Actual);
		} else {
			test.log(LogStatus.FAIL,"Title is Not matching::"+Expected+"   "+Actual);
		}
	}
	
	@Test
	public void testFail2() {
		driver.get("http://primusbank.qedgetech.com/");
		test=report.startTest("Test pass");
		test.assignAuthor("Mukesh");
		String Expected="TikTok";
		String Actual=driver.getTitle();
		if (Expected.equalsIgnoreCase(Actual)) {
			test.log(LogStatus.PASS,"Title is matching::"+Expected+"   "+Actual);
		} else {
			test.log(LogStatus.FAIL,"Title is Not matching::"+Expected+"   "+Actual);
		}
	}
	@AfterMethod
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
