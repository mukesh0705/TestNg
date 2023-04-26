package april5;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SpecificRowCellData {

	public static void main(String[] args) throws Throwable {
		//Print fifth row cell data in all cells
		//rad path of excel file
		FileInputStream fi=new FileInputStream("D:/Example.xlsx");
		//get workbook from file
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws=wb.getSheet("Emp");
		//count rows form sheet
		int rc=ws.getLastRowNum();
		System.out.println("No. of rows:: "+rc);
		//get fifth row from sheet
	    XSSFRow row=ws.getRow(5);
	    //get cells one by one from fifth row
	    XSSFCell c1=row.getCell(0);
	    XSSFCell c2=row.getCell(1);
	    XSSFCell c3=row.getCell(2);
	    XSSFCell c4=row.getCell(3);
	    //get cells data one by one from fifth's row cells
	    String fname=c1.getStringCellValue();
	    String mname=c2.getStringCellValue();
	    String lname=c3.getStringCellValue();
	    int eid=(int) c4.getNumericCellValue();
	    System.out.println(fname+"  "+mname+"  "+lname+"  "+eid);
	    fi.close();
	    wb.close();
	    
	    		

	}

}
