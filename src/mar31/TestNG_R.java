package mar31;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TestNG_R {
	WebDriver driver;
	@BeforeTest
	public void beforeClass() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Running post-condition",true);
	}
	@Test
	public void ausername() {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		Reporter.log("executing entering username ",true);
	}
	@Test
	public void bpassword() {
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		Reporter.log("executing entering password ",true);
	}
	@Test
	public void clogin() {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Reporter.log("executing clicking login button ",true);
	}
	
	@AfterTest
	public void afterClass() throws Throwable {
		Thread.sleep(5000);
		driver.close();
		Reporter.log("Running post-condition",true);
	}

}
/*How they are participating
 * setUp
 * addition
 * division
 * multiplication
 * tearDown
 */
