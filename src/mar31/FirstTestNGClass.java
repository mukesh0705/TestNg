package mar31;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGClass {
	WebDriver driver;
	@BeforeTest
	public void SetUp() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Running pre-condition",true);
	}
	@Test
	public void pbanking() {
		driver.findElement(By.xpath("(//img[position()=1])[4]")).click();
		Reporter.log("Executing pbanking test",true);
	}
	@Test
	public void cbanking() {
		driver.findElement(By.xpath("(//img[position()=1])[5]")).click();
		Reporter.log("Executing cbanking test",true);
	}
	@Test
	public void ibanking() {
		driver.findElement(By.xpath("(//img[position()=1])[6]")).click();
		Reporter.log("Executing ibanking test",true);
	}
	@AfterTest
	public void TearDown() {
		driver.close();
		Reporter.log("Running post-condition",true);
	}
}
/*How they are participating
 * setUp
 * cbanking
 * ibanking
 * pbanking
 * tearDown
 * ON CONSOLE
 * Running pre-condition
 *Executing cbanking test
 *Executing ibanking test
 *Executing pbanking test
 *Running post-condition
 */
