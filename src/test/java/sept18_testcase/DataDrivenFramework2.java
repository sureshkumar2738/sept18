package sept18_testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataDrivenFramework2 {
	
	public static WebDriver driver;
	public static String xlpath,xlResultPath;
	public static String xlTD[][];//2 D arrays
	public static int xlRowCount,xRows,xCols;
	@BeforeMethod
	public void SetUp() throws Exception
	{
	xlpath=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\data.xls";
	xlResultPath=System.getProperty("user.dir")+"\\src\\test\\resources\\testreports\\DDFResult.xls";
	xlTD=readXL(xlpath, "Testdata") ;
	xlRowCount=xlTD.length;
	System.out.println("Total rows in testdata sheet are--->"+xlRowCount);
	}

	@Test
	public void logintest()
	{//for loop testdata sheet
	for(int i=1;i<xlRowCount;i++){
	//Step2 check if Execute column value is Y then run testdata
	if(xlTD[i][1].equalsIgnoreCase("Y")){
	username=xlTD[i][2];
	password=xlTD[i][3];
	excptedText=xlTD[i][4];
	try {
	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\browseres\\geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get(prop.getProperty("uaturl"));
	Thread.sleep(4000);//explicitWait
	//Global implicit wait timeout
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//mti
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	//Enter Emailid
	driver.findElement(By.xpath(prop.getProperty("username_sigin"))).sendKeys(username);

	driver.findElement(By.xpath(prop.getProperty("next_button1"))).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath(prop.getProperty("password_signin"))).sendKeys(password);

	driver.findElement(By.xpath(prop.getProperty("next_button2"))).click();
	Thread.sleep(4000);
	Actualtext=driver.findElement(By.xpath(prop.getProperty("errortext"))).getText();
	System.out.println(Actualtext);
	xlTD[i][5]=Actualtext;
	if(Actualtext.equalsIgnoreCase(excptedText))
	{
	xlTD[i][6]="Pass";
	System.out.println("Pass");
	}else
	{
	xlTD[i][6]="Fail";
	System.out.println("Fail");
	}
	driver.quit();

	Assert.assertEquals(Actualtext, excptedText);

	} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	}
	}
	@AfterTest
	public void Quit() throws Exception
	{
	writeXL(xlResultPath, "Result", xlTD);
	}




	// Teach Java to R/W from MS Excel
	// Method to read XL
	public String[][] readXL(String fPath, String fSheet) throws Exception{
	// Inputs : XL Path and XL Sheet name
	// Output :

	String[][] xData;  
	//Step   1 create Constrcutor of FIle Class
	File myxl = new File(fPath);
	//Step 2 create Constructor of FileInputStream instrcut read data from xls
	FileInputStream myStream = new FileInputStream(myxl);
	//  Step 3 create Constrcutor of HSSFworkbook
	HSSFWorkbook myWB = new HSSFWorkbook(myStream);  
	//  Step 4 get sheet name in run time
	HSSFSheet mySheet = myWB.getSheet(fSheet);                                
	xRows = mySheet.getLastRowNum()+1;                                
	xCols = mySheet.getRow(0).getLastCellNum();  
	System.out.println("Total Rows in Excel are " + xRows);
	System.out.println("Total Cols in Excel are " + xCols);
	xData = new String[xRows][xCols];        
	for (int i = 0; i < xRows; i++) {                          
	HSSFRow row = mySheet.getRow(i);
	for (int j = 0; j < xCols; j++) {                              
	HSSFCell cell = row.getCell(j);
	String value = "-";
	if (cell!=null){
	value = cellToString(cell);
	}
	xData[i][j] = value;      
	System.out.print(value);
	System.out.print("----");
	}        
	System.out.println("");
	}    
	myxl = null; // Memory gets released
	return xData;
	}

	//Change cell type
	public static String cellToString(HSSFCell cell) {
	// This function will convert an object of type excel cell to a string value
	int type = cell.getCellType();                        
	Object result;                        
	switch (type) {                            
	case HSSFCell.CELL_TYPE_NUMERIC: //0                                
	result = cell.getNumericCellValue();                                
	break;                            
	case HSSFCell.CELL_TYPE_STRING: //1                                
	result = cell.getStringCellValue();                                
	break;                            
	case HSSFCell.CELL_TYPE_FORMULA: //2                                
	throw new RuntimeException("We can't evaluate formulas in Java");  
	case HSSFCell.CELL_TYPE_BLANK: //3                                
	result = "%";                                
	break;                            
	case HSSFCell.CELL_TYPE_BOOLEAN: //4    
	result = cell.getBooleanCellValue();      
	break;                            
	case HSSFCell.CELL_TYPE_ERROR: //5      
	throw new RuntimeException ("This cell has an error");    
	default:                  
	throw new RuntimeException("We don't support this cell type: " + type);
	}                        
	return result.toString();      
	}

	// Method to write into an XL
	public void writeXL(String fPath, String fSheet, String[][] xData) throws Exception{

	    File outFile = new File(fPath);
	       HSSFWorkbook wb = new HSSFWorkbook();
	       HSSFSheet osheet = wb.createSheet(fSheet);
	       int xR_TS = xData.length;
	       int xC_TS = xData[0].length;
	    for (int myrow = 0; myrow < xR_TS; myrow++) {
	       HSSFRow row = osheet.createRow(myrow);
	       for (int mycol = 0; mycol < xC_TS; mycol++) {
	        HSSFCell cell = row.createCell(mycol);
	        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	        cell.setCellValue(xData[myrow][mycol]);
	       }
	       FileOutputStream fOut = new FileOutputStream(outFile);
	       wb.write(fOut);//write
	       fOut.flush();
	       fOut.close();
	    }
	}

}
