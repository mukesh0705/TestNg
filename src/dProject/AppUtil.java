package dProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppUtil {
	WebDriver driver;
	public void login() throws Throwable {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		for (int i = 0; i<=5; i++) {
			
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@");
		driver.findElement(By.name("Submit")).click();
		String Expected="dashboard";
		String Actual=driver.getCurrentUrl();
		if (Actual.contains(Expected)) {
			System.out.println("Login success::"+Expected+"   "+Actual);
			driver.findElement(By.xpath("//a[@id='welcome']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
			
			
			
		} else {
			System.out.println("Login Fail::"+Expected+"   "+Actual);
		}
		
		}
		driver.close();
	}

}
