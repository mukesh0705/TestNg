package april1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG4 {
	WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
    	driver =new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("http://calc.qedgetech.com/");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	Reporter.log("Running pre-condition",true);
    }
    @Test(invocationCount = 5)
    public void addition() throws Throwable
    {
    	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("45889");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//input[@id='btn'])[6]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("64675");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
    	Thread.sleep(2000);
    	Reporter.log("Executing addition test",true);
    }
    @Test(priority = 0)
    public void multiplication()
    {
    	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("45889");
    	driver.findElement(By.xpath("(//input[@id='btn'])[16]")).click();
    	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("6");
    	driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
    	Reporter.log("Executing multiplication test",true);
    }
    @Test(priority =1 )
    public void division()
    {
    	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("45969");
    	driver.findElement(By.xpath("(//input[@id='btn'])[21]")).click();
    	driver.findElement(By.xpath("(//input[@id='btn'])[1]")).sendKeys("180");
    	driver.findElement(By.xpath("(//input[@id='btn'])[20]")).click();
    	Reporter.log("Executing division test",true);
    }
    @AfterMethod
    public void tearDown()
    {
    	driver.quit();
    	Reporter.log("Running post-condition",true);
    	
    }
}
/*How they are participating
 * O/P before setting priority
 * setUp
 * addition
 * tearDown
 * setUp
 * division
 * tearDown
 * setUp
 * multiplication
 * tearDown
 * O/P After setting priority
 * setUp
 * multiplication
 * tearDown
 * setUp
 * division
 * tearDown
 * setUp
 * addition
 * tearDown
 *  O/P After multiplication and division set as priority and addition remain left as non-priority 
 * setUp
 * addition
 * tearDown
 * setUp
 * multiplication
 * tearDown
 * setUp
 * division
 * tearDown
 */


