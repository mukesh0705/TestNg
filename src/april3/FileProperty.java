package april3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileProperty {
	WebDriver driver;
	Properties p;
	@Test
	public void login() throws Throwable {  
		p=new Properties();
		p.load(new FileInputStream("OrangeHRM.properties"));
		driver = new ChromeDriver();
		driver.get(p.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(p.getProperty("Objuser"))).sendKeys(p.getProperty("Enteruser"));
		driver.findElement(By.xpath(p.getProperty("Objpass"))).sendKeys(p.getProperty("Enterpass"));
		driver.findElement(By.xpath(p.getProperty("Objlogin"))).click();
		driver.close();
	}

}
