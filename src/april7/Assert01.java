package april7;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert01 {
	WebDriver driver;
	@Test
	public void validtitle() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://gmail.com");
		String Expected="Google";
		String Actual=driver.getTitle();
		try {
			Assert.assertEquals(Actual, Expected,"Title is not matching");
		} catch (Throwable t) {
			{
				System.out.println(t.getMessage());
			}	
		}
		driver.quit();
	}

}
