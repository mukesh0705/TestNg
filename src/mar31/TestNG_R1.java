package mar31;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_R1 {
	WebDriver driver;
	@BeforeTest
	public void beforeClass() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Running post-condition",true);
	}
	@Test(priority = 0)
	public void username() {
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		Reporter.log("executing entering username ",true);
	}
	@Test(priority = 1)
	public void password() {
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		Reporter.log("executing entering password ",true);
	}
	@Test(priority = 2)
	public void login() {
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Reporter.log("executing clicking login button ",true);
	}
	
	@AfterTest
	public void afterClass() throws Throwable {
		Thread.sleep(5000);
		driver.close();
		Reporter.log("Running post-condition",true);
	}

}
