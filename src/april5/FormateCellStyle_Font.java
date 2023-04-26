package april5;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormateCellStyle_Font {

	public static void main(String[] args) throws Throwable {
		//Style and color change of Status Font(Pass,Fail and Blocked)
		FileInputStream fi=new FileInputStream("D:/Sample.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("emp");
		int rc=ws.getLastRowNum();
		System.out.println("No. of rows:: "+rc);
		for (int i = 1; i <=rc; i++) {
			//ws.getRow(i).createCell(4).setCellValue("Pass");
			//ws.getRow(i).createCell(4).setCellValue("Fail");
			ws.getRow(i).createCell(4).setCellValue("Blocked");
			XSSFCellStyle style=wb.createCellStyle();
			XSSFFont font=wb.createFont();
			//color text
			//font.setColor(IndexedColors.GREEN.getIndex());
			//font.setColor(IndexedColors.RED.getIndex());
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
		    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
			style.setFont(font);
			ws.getRow(i).getCell(4).setCellStyle(style);
		}
		fi.close();
		FileOutputStream fo=new FileOutputStream("D:/Result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
