package com.experitest.auto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Report {

	
	public void report(JsonArray jsonarr) throws IOException{
		
		  //Blank Document
	      XWPFDocument document = new XWPFDocument();
	        
	      //Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File("create_table.docx"));
	        
	      //create table
	      XWPFTable table = document.createTable();
			
	      //create first row
	      XWPFTableRow tableRowOne = table.getRow(0);
	      tableRowOne.getCell(0).setText("title ");
	      tableRowOne.addNewTableCell().setText("Video Link");

			
	    for (int i=0;i<jsonarr.size();i++){
	     JsonObject obj = jsonarr.get(i).getAsJsonObject();
	     String title = obj.get("title").getAsString();
	     String result = obj.get("result").getAsString();
	      
	      XWPFTableRow tableRowThree = table.createRow();
	      tableRowThree.getCell(0).setText(title);
	      tableRowThree.getCell(1).setText(result);
	     
		
	      
	     
	    
	}
	    document.write(out);
	   System.out.println("create_table.docx written successully");
	    out.close();
	}
	
	
	
}
