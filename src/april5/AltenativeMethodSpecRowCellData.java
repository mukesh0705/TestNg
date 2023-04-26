package april5;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AltenativeMethodSpecRowCellData {

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
		//read each cell data
		String fname=ws.getRow(2).getCell(0).getStringCellValue();
		String mname=ws.getRow(5).getCell(1).getStringCellValue();
		String lname=ws.getRow(4).getCell(2).getStringCellValue();
		int eid=(int) ws.getRow(7).getCell(3).getNumericCellValue();
		System.out.println(fname+"  "+mname+"  "+lname+"  "+eid);
	    fi.close();
	    wb.close();

	}

}
