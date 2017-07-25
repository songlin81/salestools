package MyPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Driver {
	
	Map<String, String> mpContainter = new HashMap<>();
	String link;
	String output;
	
	public Driver(String path)
	{
		link = path;
	}
	
	public Map<String, String> getMap(){
	   try {
	        FileInputStream excelFile = new FileInputStream(new File(link));
	       // Workbook workbook = new XSSFWorkbook(excelFile);
	        
	        try (Workbook workbook = new XSSFWorkbook(excelFile)) {       	
		        Sheet datatypeSheet = workbook.getSheetAt(0);
		        Iterator<Row> iterator = datatypeSheet.iterator();
		
		        while (iterator.hasNext()) {
		        	output="";
		            Row currentRow = iterator.next();
		            Iterator<Cell> cellIterator = currentRow.iterator();
		
		            while (cellIterator.hasNext()) {
		                Cell currentCell = cellIterator.next();
		                if (currentCell.getCellTypeEnum() == CellType.STRING) {
		                    output=output+currentCell.getStringCellValue()+";";
		                } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
		                    ;
		                }
		            }
		            System.out.println();
		            System.out.print(output);
		            
		            if(output.length()>0) {
			            String[] parts = output.split(";");
		                mpContainter.put(parts[0], parts[1]);
		            }
		        }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	   
		return mpContainter;
	}

	public String[][] getExcelsheet(String spreadsheetName) {
		String[][] strContents = null;
		
		   try {
		        FileInputStream excelFile = new FileInputStream(new File(link));
		       // Workbook workbook = new XSSFWorkbook(excelFile);
		        try (Workbook workbook = new XSSFWorkbook(excelFile)) {
		        
			        Sheet datatypeSheet = workbook.getSheet(spreadsheetName);
			        int rowNum = datatypeSheet.getPhysicalNumberOfRows();
			        int columnNum =  datatypeSheet.getRow(0).getPhysicalNumberOfCells();
			        strContents = new String[rowNum-1][columnNum];
			        System.out.println(rowNum);
			        System.out.println(columnNum);
			        
			        Iterator<Row> iterator = datatypeSheet.iterator();
			        Row row = iterator.next();  //skip heading row
			        
			        while (iterator.hasNext()) {
	//		        	output="";
	//		            Row currentRow = iterator.next();
	//		            Iterator<Cell> cellIterator = currentRow.iterator();
	//		
	//		            while (cellIterator.hasNext()) {
	//		                Cell currentCell = cellIterator.next();
	//		                if (currentCell.getCellTypeEnum() == CellType.STRING) {
	//		                    output=output+currentCell.getStringCellValue()+";";
	//		                } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	//		                    ;
	//		                }
	//		            }
	//		            System.out.println();
	//		            System.out.print(output);
	//		            
	//		            if(output.length()>0) {
	//			            String[] parts = output.split(";");
	//		                mpContainter.put(parts[0], parts[1]);
	//		            }
			        }
			        
			        System.out.println(strContents[0][0]);
			        System.out.println(strContents[0][1]);
			        System.out.println(strContents[0][2]);
			        System.out.println(strContents[0][3]);
			        System.out.println(strContents[1][0]);
		        }
		        } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
		return strContents;
	}
}
