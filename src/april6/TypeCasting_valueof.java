package april6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TypeCasting_valueof {

	public static void main(String[] args) throws Throwable {
		//converting integer to string Excel file column data
		FileInputStream fi=new FileInputStream("D:/Example.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Emp");
		int rc=ws.getLastRowNum();
		for (int i=1;i<=rc;i++) {
			if(wb.getSheet("Emp").getRow(i).getCell(3).getCellType()==Cell.CELL_TYPE_NUMERIC);
			{	
				int celldata=(int) wb.getSheet("Emp").getRow(i).getCell(3).getNumericCellValue();
				String eid=String.valueOf(celldata);
				System.out.println(eid);
			}
		}
		fi.close();
		FileOutputStream fo= new FileOutputStream("D:/Besult.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
