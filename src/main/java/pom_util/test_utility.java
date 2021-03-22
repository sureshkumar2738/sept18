package pom_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pom_testbase.test_Base;

public class test_utility extends test_Base {
	
	 
	public test_utility() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Workbook book;
	public static Sheet sheet;

	public static long IMPLICITWAITTIMEOUT = 30;
	public static long PAGELOADTIMEOUT = 30;

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\java\\pom_testdata\\testdata.xlsx";

	public static Object[][] getTestData(String sheetName)
			throws EncryptedDocumentException,  IOException, InvalidFormatException {
		FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
		book = WorkbookFactory.create(file);

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}

	public static void takeScreenShotsAtEndoftest() throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// String curDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrfile,
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"
						+ System.currentTimeMillis() + ".png"));
	}
	
	
}

