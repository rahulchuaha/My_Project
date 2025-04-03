package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	
	
	public String getDataFromPropFile(String key) throws IOException{
		FileInputStream fis = new FileInputStream("E:\\selenium_project\\my_framework\\src\\test\\resources\\properties.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}
	
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("C:\\\\\\\\Users\\\\\\\\dell\\\\\\\\OneDrive\\\\\\\\Desktop\\\\\\\\org_test.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String orgName = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNo).getStringCellValue()+ (int)(Math.random()*100);
 		return orgName;
	}

}
