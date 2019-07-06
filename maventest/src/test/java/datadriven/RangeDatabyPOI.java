package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;	//xls
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;	//xlsx

public class RangeDatabyPOI {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	@SuppressWarnings("resource")
	public static Object[][] poiRangeData(String filePath,String sheetName) throws IOException {
		
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String extensionName = filePath.substring(filePath.indexOf("."));	//substring(start,stop)，取下标start到stop-1的字符。
		if (extensionName.equals(".xls")){
			workbook= new HSSFWorkbook(inputStream);
		}
		else if (extensionName.equals(".xlsx")){
			workbook= new XSSFWorkbook(inputStream);
		}
		else{
			System.out.println("文件格式不正确");
		}
		//或者用filePath.endWith(".xls")
		
		Sheet sheet = workbook.getSheet(sheetName);	//workbook.getSheetAt(0); workbook.getSheet("Sheet1");
		
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		List<Object[]> records =new ArrayList <Object[]>();
		
    	for(int i=1;i<rowCount+1;i++){	//总行数
    		Row row = sheet.getRow(i);
    		String fields[] = new String[row.getLastCellNum()];
    		for(int j=0;j<row.getLastCellNum();j++){	//每行总列数
    			fields[j]=row.getCell(j).getStringCellValue();
    		}
    		records.add(fields);	//list集合（records）放每一行（一维）
    		
    	}
    	
    	Object[][] results=new Object[records.size()][];	
    	
    	for(int i=0;i<records.size();i++){	//results二维数组放records
    		results[i]=records.get(i);
    	}
    	
    	return results;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
