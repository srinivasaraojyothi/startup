package zycus.assignment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataTest {
	TestEnvironement variableExcelTab=new TestEnvironement();
	ArrayList<Cell> arrayforURLSheet = new ArrayList<Cell>();
	ArrayList<Cell> arrayforDataSheetS = new ArrayList<Cell>();

	// *******************************************************************************
	// *Functional Purpose: Getting the data from data sheet
	// *Created By: Srinivasa Rao
	// *Created Date: 6/06/2017
	// *Modified By:
	Properties properties = new Properties();

	// ******************************************************************************
	// @Test
	public ArrayList<Cell> urlsDataSheet() throws IOException {
		FileInputStream fileInput = new FileInputStream(new File("src/main/resources/DataFilesLocations.properties"));
		properties.load(fileInput);
		File file = new File(properties.getProperty("excelDatasheetLocation"));
		//XSSFSheet sheetName=null;;
		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheetName =null;
			String testsSheetName=variableExcelTab.testDataTab();
			//System.out.println(testsSheetName.equalsIgnoreCase("r_vnv")+" :-----------is the test sheet name----------");
			if(testsSheetName.equalsIgnoreCase("r_vnv")){
				 sheetName = workbook.getSheet("VNV_Regression");
			}
			else if(testsSheetName.equalsIgnoreCase("r_sqe")){
				sheetName = workbook.getSheet("SQE_Regression");
			}
			else {
				sheetName = workbook.getSheet("Zycus-Assignment");
			}
			System.out.println(sheetName+"--------------------------------------------");
			//XSSFSheet sheetName = workbook.getSheet("url");
			Iterator<Row> sheetRowiterator = sheetName.iterator();
			while (sheetRowiterator.hasNext()) {
				Row rowValue = sheetRowiterator.next();

				Iterator<Cell> sheetCelliterator = rowValue.iterator();

				while (sheetCelliterator.hasNext()) {
					Cell cellValue = sheetCelliterator.next();
					cellValue.toString();
					arrayforURLSheet.add(cellValue);
					// log.info(str);

				}

				fis.close();

			}

			// ls.put(1, al);
		}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int iteratingTheArray = 0; iteratingTheArray < arrayforURLSheet.size(); iteratingTheArray++) {
			// log.info(arrayforURLSheet.get(iteratingTheArray)+" is
			// the value at: "+iteratingTheArray);
		}
		return arrayforURLSheet;

		// return str;

	}

}
