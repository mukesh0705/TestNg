package april5;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class PrintAllCellValue {

	public static void main(String[] args) throws Throwable {
		//rad path of excel file
		FileInputStream fi=new FileInputStream("D:/Example.xlsx");
		//get workbook from file
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws=wb.getSheet("Emp");
		//count rows form sheet
		int rc=ws.getLastRowNum();
		System.out.println("No. of rows:: "+rc);
		for(int i=1;i<=rc;i++) {
		//read each cell data
		String fname=ws.getRow(i).getCell(0).getStringCellValue();
		String mname=ws.getRow(i).getCell(1).getStringCellValue();
		String lname=ws.getRow(i).getCell(2).getStringCellValue();
		int eid=(int) ws.getRow(i).getCell(3).getNumericCellValue();
		System.out.println(fname+"  "+mname+"  "+lname+"  "+eid);
		}
		fi.close();
		wb.close();


	}

}
