package april5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteCellData {

	public static void main(String[] args)throws Throwable {
		FileInputStream fi=new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws =wb.getSheet("emp");
		int rc=ws.getLastRowNum();
		System.out.println("No. of rows:: "+rc);
		for(int i=1;i<=rc;i++)
		{
			//write status as pass
			ws.getRow(i).createCell(4).setCellValue("Pass");
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("D:/Result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
