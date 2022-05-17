package com.taf.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static final Logger log = Logger.getLogger(ExcelReader.class.getName());

	public FileOutputStream fos = null;
	public FileInputStream fis;
	public Workbook wb;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	public String path;

	public ExcelReader(String path) {
		this.path = path;
		try {
			fis = new FileInputStream(path);
			wb = WorkbookFactory.create(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method will return 2 Dimensional object Data for each record in excel
	 * sheet.
	 * 
	 * @param SheetName
	 * @return
	 */
	public String[][] getEntireDataFromSheet(String sheetName) {
		String dataSet[][] = null;

		try {

			sheet = wb.getSheet(sheetName);
			// count number of active rows
			int totalRow = sheet.getLastRowNum();
			// count number of active columns in the row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSet = new String[totalRow][totalColumn];
			// Run "for loop" and store data in 2D array
			// This "for loop" will run on "rows"
			for (int i = 1; i <= totalRow; i++) {
				row = sheet.getRow(i);
				// This "for loop" will run on "columns" of that row
				for (int j = 0; j < totalColumn; j++) {
					cell = row.getCell(j);

					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						dataSet[i - 1][j] = cell.getStringCellValue();
					} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						dataSet[i - 1][j] = String.valueOf(cell.getNumericCellValue());
					} else {
						dataSet[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
					}
				}
			}
			return dataSet;

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception in reading excel file: " + e.getMessage());
		}

		return dataSet;
	}

	/**
	 * This Method will return 2 Dimensional object Data for each record in excel
	 * sheet.
	 * 
	 * @param SheetName
	 * @return
	 */
	public HashMap<String, String> getDataRowFromSheet(String testCaseNum) {
		HashMap<String, String> map = new HashMap<String, String>();

		String sheetName = testCaseNum.split("_")[0];
		String rowIdent = testCaseNum.split("_")[1];
		String cellValue = "";

		try {
			sheet = wb.getSheet(sheetName);
			// count number of active columns in the row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			int rowNum = -1;
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(rowIdent)) {
					rowNum = i;
					break;
				}
			}
			if (rowNum == -1) {
				throw new Exception("The DataSet Record is missing in the Sheet");
			}

			for (int j = 0; j < totalColumn; j++) {
				cell = sheet.getRow(rowNum).getCell(j);

				if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
					cellValue = "";
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					cellValue = String.valueOf(cell.getNumericCellValue());
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					cellValue = cell.getStringCellValue();
				}

				map.put(sheet.getRow(0).getCell(j).getStringCellValue(), cellValue);
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception in reading excel file: " + e.getMessage());
		}
		System.out.println(map);
		return map;
	}

	/**
	 * This will return the data in particular cell of the excel sheet
	 * 
	 * @param sheetName
	 * @param columnName
	 * @param rowNum
	 * @return
	 */
	public String getCellValueFromSheet(String sheetName, String columnName, int rowNum) {

		try {
			int colNum = 0;
			sheet = wb.getSheet(sheetName);
			row = sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
					colNum = i;
					break;
				}
				// * This will return the data in particular cell of the excel sheet

			}

			row = sheet.getRow(rowNum - 1);
			cell = row.getCell(colNum);

			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}

			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}
		} catch (Exception e) {

			e.printStackTrace();
			log.info("Exception in reading excel column: " + e.getMessage());
		}

		return null;
	}

	/**
	 * This will give the columnValue for a corresponding knowValue from excel
	 * 
	 * @param sheetName
	 * @param coulumValue
	 * @param knownValue
	 * @return
	 */
	public String getDataForKnownVal(String sheetName, String coulumValue, String knownValue) {

		try {
			int colNum = -1;
			int rowNum = -1;
			sheet = wb.getSheet(sheetName);

			for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
				if (sheet.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(coulumValue)) {
					colNum = i;
					break;
				}
			}

			// for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(knownValue)) {
					rowNum = i;
					break;
				}
				// }This will give the columnValue for a corresponding knowValue from excel

			}

			if (rowNum == -1) {
				throw new Exception("The DataSet Record is missing in the Sheet");
			}
			if (colNum == -1) {
				throw new Exception("The column is missing in the sheet");
			}

			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);

			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}

			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}
		} catch (Exception e) {

			e.printStackTrace();
			log.info("Exception in reading excel column: " + e.getMessage());
		}

		return null;
	}

	public String getExcelData(String dataSet, String column) {
		String refData[] = dataSet.split("_");
		String sheetName = refData[0];
		String knownValue = refData[1];
		String coulumValue = column;
		String value = getDataForKnownVal(sheetName, coulumValue, knownValue);
		return value;
	}	
}
