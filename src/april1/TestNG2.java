package april1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG2 {
    WebDriver driver;
    @BeforeSuite
    public void setUp() {
    	driver =new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("http://primusbank.qedgetech.com/");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.name("txtuId")).sendKeys("Admin");
    	driver.findElement(By.name("txtPword")).sendKeys("Admin");
    	driver.findElement(By.name("login")).click();
    	Reporter.log("Running pre-condition",true);
    }
    @Test
    public void branches() {
    	driver.findElement(By.xpath("(//img)[5]")).click();
    	Reporter.log("Executing branches test",true);
    }
    @Test
    public void roles() {
    	driver.findElement(By.xpath("(//img)[6]")).click();
    	Reporter.log("Executing roles test",true);
    }
    @Test(enabled = false)
    public void users() {
    	driver.findElement(By.xpath("(//img)[7]")).click();
    	Reporter.log("Executing users test",true);
    }
    @AfterSuite
    public void tearDown() {
    	driver.close();
    	Reporter.log("Running post-condition",true);
    }
}
/*How they are participating
 * Before priority O/P
   Running pre-condition
   Executing branches test
   Executing roles test
   Executing users test
 */
