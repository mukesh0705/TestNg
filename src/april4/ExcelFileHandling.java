package april4;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelFileHandling {

	public static void main(String[] args) throws Throwable {
		//count No of row in a sheet and cell in first row 
		//read path of a file
		FileInputStream fi=new FileInputStream("D:/Example.xlsx");
		//get workbook from file
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws=wb.getSheet("Emp");
		//count No. of rows in sheet
		int rc=ws.getLastRowNum();
		//get first rows from sheet
		XSSFRow firstRow=ws.getRow(0);
		//get No. of cells in first rows
		int cc=firstRow.getLastCellNum();
		System.out.println("No. of rows:: "+rc+"  "+"No. of cells in firstrow:: "+cc);
		fi.close();
		wb.close();
	}

}
