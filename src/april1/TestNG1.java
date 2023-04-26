package april1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG1 {
	WebDriver driver;
	@BeforeSuite
	public void setUp()
	{
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://calc.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Running pre-condition",true);
	}
	@Test
	public void addition() throws Throwable
	{
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("45889");

		driver.findElement(By.xpath("(//input[@id='btn'])[6]")).click();
		
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("64675");
		
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
	
		driver.findElement(By.xpath("(//input[@id='btn'])[26]")).click();
		
		Reporter.log("Executing addition test",true);
	}
	@Test
	public void multiplication() throws Throwable
	{
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("45889");
		
		driver.findElement(By.xpath("(//input[@id='btn'])[16]")).click();
		
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("6");
		
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		
		driver.findElement(By.xpath("(//input[@id='btn'])[26]")).click();
		
		Reporter.log("Executing multiplication test",true);
	}
	@Test
	public void division() throws Throwable
	{
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("45969");
		
		driver.findElement(By.xpath("(//input[@id='btn'])[21]")).click();
		
		driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("180");
		
		driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
		
		driver.findElement(By.xpath("(//input[@id='btn'])[26]")).click();
	
		Reporter.log("Executing division test",true);
	}
	@AfterSuite
	public void tearDown() throws Throwable
	{
		Thread.sleep(2000);
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
 * ON CONSOLE
 * Running pre-condition
   Executing addition test
   Executing division test
   Executing multiplication test
 * 
 * 
 * 
 * 
 */
