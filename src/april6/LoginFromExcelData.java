package april6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFromExcelData {
	WebDriver driver;
	XSSFWorkbook wb;
	String inputpath="D:/LoginData.xlsx";
	String outputpath="D:/Results.xlsx";
	@BeforeTest
	public void setUp() {
		driver =new ChromeDriver();
	}
	@Test
	public void login() throws Throwable {

		FileInputStream fi=new FileInputStream(inputpath);
		wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Login");
		int rc=ws.getLastRowNum();
		Reporter.log("No. of rows are:: "+rc,true);

		for (int i = 1; i <=rc; i++) {
			driver.get("http://orangehrm.qedgetech.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//read username and password cells
			String user=ws.getRow(i).getCell(0).getStringCellValue();
			String pass=ws.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name("txtUsername")).sendKeys(user);
			driver.findElement(By.name("txtPassword")).sendKeys(pass);
			driver.findElement(By.id("btnLogin")).click();
			String Expected="dashboard";
			String Actual=driver.getCurrentUrl();
			
			if (Actual.contains(Expected)) {
				
				//write as login success into results cell
				ws.getRow(i).createCell(2).setCellValue("Login success");	
				//write as pass into status cell
				ws.getRow(i).createCell(3).setCellValue("pass");
				Reporter.log("Login sucess",true);
				XSSFCellStyle style=wb.createCellStyle();
				XSSFFont font=wb.createFont();
				font.setColor(IndexedColors.GREEN.getIndex());
				font.setBold(true);
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				style.setFont(font);
				ws.getRow(i).getCell(3).setCellStyle(style);
			}
			
			else {
				  File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				  FileUtils.copyFile(screen, new File("D:/srshot/iteration/"+i+"Loginpage.png"));
				 //write Error_message into result cell
				 String Error_message=driver.findElement(By.id("spanMessage")).getText();
				 
				 ws.getRow(i).getCell(2).setCellValue(Error_message);
				 ws.getRow(i).getCell(3).setCellValue("fail");
				 Reporter.log(Error_message+"  "+Expected+"  "+Actual);
				 
				 XSSFCellStyle style=wb.createCellStyle();
				 XSSFFont font=wb.createFont();
				
				font.setColor(IndexedColors.RED.getIndex());
				font.setBold(true);
				font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				style.setFont(font);
				ws.getRow(i).getCell(3).setCellStyle(style);
			}
		}
		
		fi.close();
		
		FileOutputStream fo=new FileOutputStream(outputpath);
		
		wb.write(fo);
		fo.close();
		wb.close();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
