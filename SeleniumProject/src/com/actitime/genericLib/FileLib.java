package com.actitime.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Subhashini
 *
 */

public class FileLib {
	/**
	 * 
	 * @param Key
	 * @return
	 * @throws Throwable
	 */

	public String getPropertyFileData(String Key) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/commonData.properties"); 
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(Key);
		return value;
		
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	
	public String getExcelData(String sheetName, int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");	
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * It is use to write data back to testScriptData.xlsx files based on user arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testScriptData.xlsx");	
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream ("./data/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
		}
