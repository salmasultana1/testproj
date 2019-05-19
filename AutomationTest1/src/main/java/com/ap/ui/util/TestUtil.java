package com.ap.ui.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;// create a screenshot create folder inside project

public class TestUtil extends TestBase {

	public static long Page_laod = 10;
	public static long Implicit_Wait = 10;
				
		// TODO Auto-generated method stub
public static String XL_SHEET_PATH = "";

static Workbook book;
static Sheet sheet;
static JavascriptExecutor js;
public static Object[] getTestData (String sheetName){
	FileInputStream file = null;
	try{
		file = new FileInputStream(XL_SHEET_PATH);
		
		}catch (FileNotFoundException e){
			e.printStackTrace();
			}
	try {
		book = WorkbookFactory.create(file);
		}catch (InvalidFormatException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	sheet = book.getSheet(sheetName);
	Object [] [] data = new Object [ sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for   (int i = 0; i < sheet.getLastRowNum();i++){
		for ( int j = 0; j < sheet.getRow(0).getLastCellNum(); j++){
			data[i][j]= sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
}
 public static void takeScreenshot() throws IOException{ // to run work with error
	 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 String currentDirect = System.getProperty("user.dir");
	 FileUtils.copyFile(srcFile, new File( currentDirect + "/screenshot/" +
	 System.currentTimeMillis() + ".png"));
	 
	}
 public static void runTimeInfo (String messageType, String message)throws InterruptedException{
	 js = (JavascriptExecutor) driver;
	 
	 js.executeScript ("if ( ! window.JQuery){"
	 		+ " var jquery = document.createElement('script'); jquary.type = 'text/javascript';"
	 		+ "Jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
	 		+ "document.getElementsByTagName('head').appenChild(jquery);"+"}");
	 Thread.sleep(6000); // wait
	 
	 js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

	
	js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
	Thread.sleep(6000);
	
	js.executeScript("$growl({title:'GET',message:'/'});");
	
	if(messageType.equals("error")){;
	 js.executeScript("$growl.error({title:'Error' message: '" + message+" '});");                                         
 } else if( messageType.equals("info")){
	 
	js.executeScript("$growl.error({title:'notice',message:'notice message will apear here'});");
 }
			
	else if(messageType.equals("warning")){
		js.executeScript("$growl.error({tittle:'Warning!!', message:'your warning message will apear here'});");
	}else
		System.out.println("SHOW NO ERROR Message");
	Thread.sleep(6000);
	
	
}
}
	 