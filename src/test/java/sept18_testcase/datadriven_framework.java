package sept18_testcase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test_base.bank_test_base;

public class datadriven_framework extends bank_test_base {
	
public static String xlpath,xlResultpath;
public static int xlRowCount,xlRows,xlCols;
public static String xlTD[][];

	public datadriven_framework() throws IOException {
		super();
		
	}
		
		@BeforeMethod
		public void startbrowser() throws Exception {
			
			xlpath =System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xls";
			xlResultpath =System.getProperty("user.dir")+"\\src\\test\\resources\\test_reports\\testreport.xls";
			inilization();
			xlTD = readXL(xlpath,"testdata");
			xlRowCount = xlTD.length;
		}
		
		@Test
		public void calculate() throws InterruptedException {
			
			for(int i=1;i<xlRowCount;i++) {
			
				if(xlTD[i][1].equalsIgnoreCase("Y")) {
			
					LoanAmt = xlTD[i][2];
					loanYeays = xlTD[i][3];
					Loanrate = xlTD[i][4];
					ExpectedmonthlyPayment =xlTD[i][5];
					
					driver.findElement(By.xpath(prop.getProperty("loan_amount"))).clear();
					driver.findElement(By.xpath(prop.getProperty("loan_amount"))).sendKeys("7000");
					
					Thread.sleep(3000);
					
					driver.findElement(By.xpath(prop.getProperty("term_in_years"))).clear();
					driver.findElement(By.xpath(prop.getProperty("term_in_years"))).sendKeys("7");
					
					Thread.sleep(3000);
					
					driver.findElement(By.xpath(prop.getProperty("term_in_months"))).clear();
					driver.findElement(By.xpath(prop.getProperty("term_in_months"))).sendKeys("80");
					
					Thread.sleep(4000);
					
					driver.findElement(By.xpath(prop.getProperty("interest"))).clear();
					driver.findElement(By.xpath(prop.getProperty("interest"))).sendKeys("6.6");
					
					Thread.sleep(5000);
					
					driver.findElement(By.xpath(prop.getProperty("calculate"))).click();
					
					Thread.sleep(5000);
					
					iwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("txt_actual_amount"))));
					
					Object ActualMonthlyPayment = driver.findElement(By.xpath(prop.getProperty("txt_actual_amount"))).getText();
					
					System.out.println("Actual  monthly payment is --->"+ActualMonthlyPayment);
					
					xlTD[i][6] = "ActualMonthlyPayment";
					
					ExpectedmonthlyPayment="$ 108.39";
					
					if (((String) ActualMonthlyPayment).equalsIgnoreCase(ExpectedmonthlyPayment))
					{
						System.out.println("pass");
						xlTD[i][7] = "pass";
					}else
					{
						System.out.println("fail");
						xlTD[i][7] = "fail";
					}
					driver.quit();
					
					Assert.assertEquals(ActualMonthlyPayment, ExpectedmonthlyPayment);
		}
		}
		}

		@AfterMethod
		public void closebrowser() throws Exception {
			
			writeXL(xlResultpath,"report",xlTD);
		}

		// Teach Java to R/W from MS Excel
				// Method to read XL
				public String[][] readXL(String fPath, String fSheet) throws Exception{
					// Inputs : XL Path and XL Sheet name
					// Output : cellValue
					
						String[][] xData;   
			//Step   1 create Constructor of FIle Class
						File myxl = new File(fPath);
			//Step 2 create Constructor of FileInputStream instruct read data from xls 					
						FileInputStream myStream = new FileInputStream(myxl);
						//  Step 3 create Constructor of HSSFworkbook 
						HSSFWorkbook myWB = new HSSFWorkbook(myStream);  
						//  Step 4 get sheet name in run time
						HSSFSheet mySheet = myWB.getSheet(fSheet);                                 
						xlRows = mySheet.getLastRowNum()+1;                                
						xlCols = mySheet.getRow(0).getLastCellNum();   
						System.out.println("Total Rows in Excel are " + xlRows);
						System.out.println("Total Cols in Excel are " + xlCols);
						xData = new String[xlRows][xlCols];        
						for (int i = 0; i < xlRows; i++) { ///outer for loop for rows                          
								HSSFRow row = mySheet.getRow(i);
								for (int j = 0; j < xlCols; j++) {                   // inner for loop for columns            
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
					CellType type = cell.getCellType();                        
					Object result;                        
					switch (type) {                            
						case  HSSFCell.CELL_TYPE_NUMERIC: //0                                
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
					//  input parameter --  result path, sheet name, array Name
					//output value -- nil
					//  Step 1 create constructor of File  class to store result sheet path
				    	File outFile = new File(fPath);
				    //  step 2 create  constructor of  HSSFWorkbook class to add workbook into meemory
				        HSSFWorkbook wb = new HSSFWorkbook();
				     // step 3 create new sheet in existing workbook 
				        HSSFSheet osheet = wb.createSheet(fSheet);
				        int xR_TS = xData.length;// row count
				        int xC_TS = xData[0].length;// column count
				    	for (int myrow = 0; myrow < xR_TS; myrow++) {
					        HSSFRow row = osheet.createRow(myrow);// create new rows in  workbook
					        for (int mycol = 0; mycol < xC_TS; mycol++) {
					        	HSSFCell cell = row.createCell(mycol);// create cell  in workbook
					        	cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					        	cell.setCellValue(xData[myrow][mycol]);//  set value 
					        }
					        FileOutputStream fOut = new FileOutputStream(outFile);//  Write data
					        wb.write(fOut);//write  into excel file
					        fOut.flush();
					        fOut.close();
				    	}
					}
					
			}

	