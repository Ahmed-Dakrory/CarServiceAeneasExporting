package main.com.carService.docreciept;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;

import main.com.carService.customCommodity.commoditiy;

public class ReportFileGeneration {

	HSSFWorkbook workbook;
	HSSFSheet sheet;
	docreciept docReceiptCollection;
	HSSFRow row;
	HSSFCell cell;
	main.com.carService.loginNeeds.loginBean loginBean;
	main.com.carService.Beans.customBean customBean;
	List<commoditiy> listOfCommodities;
	
	public ReportFileGeneration(main.com.carService.Beans.customBean customBean,List<commoditiy> listOfCommodities, main.com.carService.loginNeeds.loginBean loginBean,docreciept docReceiptCollection,HSSFWorkbook wb,HSSFSheet sheet) {
		// TODO Auto-generated constructor stub
		this.workbook=wb;
		this.sheet=sheet;
		this.docReceiptCollection=docReceiptCollection;
		this.loginBean=loginBean;
		this.customBean=customBean;
		this.listOfCommodities=listOfCommodities;
	}
	
	public void generateReport(){
		sheet.setColumnWidth(0, 1356);
		sheet.setColumnWidth(1, 4908);
		sheet.setColumnWidth(2, 2601);
		sheet.setColumnWidth(3, 6000);
		sheet.setColumnWidth(4, 1356);
		sheet.setColumnWidth(5, 4955);
		sheet.setColumnWidth(6, 3500);
		sheet.setColumnWidth(7, 3501);
		sheet.setColumnWidth(8, 3500);
		
		titleOfSheet();
	}
	public void titleOfSheet(){
		//Title							
		HSSFCellStyle style = workbook.createCellStyle();
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    HSSFFont font = workbook.createFont();
	    font.setFontHeightInPoints((short) 18);
	    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	    style.setFont(font); 
	    
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
	    row = sheet.createRow(0);
	    cell = row.createCell(0);
	    row.getCell(0).setCellStyle(style);
	    cell.setCellValue("Doc Receipt");
	    
	 
	    
	    
	  //USPPI Title (COMPLETE NAME AND ADDRESS)
	    style = workbook.createCellStyle();
	    style.setAlignment(CellStyle.VERTICAL_TOP);
	    font = workbook.createFont();
	    font.setFontHeightInPoints((short) 9);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    
	    style.setFont(font); 
	    
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));
	    row = sheet.createRow(1);
	    cell = row.createCell(0);
	    row.getCell(0).setCellStyle(style);
	    cell.setCellValue("SHIPPER/EXPORTER (COMPLETE NAME AND ADDRESS)");
	    
	  //USPPI Company 
	    style = workbook.createCellStyle();
	    style.setAlignment(CellStyle.VERTICAL_TOP);
	    font = workbook.createFont();
	    font.setFontHeightInPoints((short) 10);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	    style.setFont(font); 
	    
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 3));
	    row = sheet.createRow(2);
	    cell = row.createCell(0);
	    row.getCell(0).setCellStyle(style);
	    cell.setCellValue(docReceiptCollection.getUsppiId().getUserId().getCompany());
	    
	    
	    //USPPI Address 
	    style = workbook.createCellStyle();
	    style.setAlignment(CellStyle.VERTICAL_TOP);
	    font = workbook.createFont();
	    font.setFontHeightInPoints((short) 10);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	    style.setFont(font); 
	    
		sheet.addMergedRegion(new CellRangeAddress(3, 4, 0, 3));
	    row = sheet.createRow(3);
	    cell = row.createCell(0);
	    row.getCell(0).setCellStyle(style);
	    cell.setCellValue(docReceiptCollection.getUsppiId().getUserId().getAddress1());
	    
	    
	  //USPPI Telephone 
	    style = workbook.createCellStyle();
	    style.setAlignment(CellStyle.VERTICAL_TOP);
	    font = workbook.createFont();
	    font.setFontHeightInPoints((short) 10);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	    style.setFont(font); 
	    
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 3));
	    row = sheet.createRow(5);
	    cell = row.createCell(0);
	    row.getCell(0).setCellStyle(style);
	    cell.setCellValue(docReceiptCollection.getUsppiId().getUserId().getPhone());
	    
	    
	  //BOOKING NO.	Title
	    style = workbook.createCellStyle();
	    style.setAlignment(CellStyle.VERTICAL_TOP);
	    font = workbook.createFont();
	    font.setFontHeightInPoints((short) 9);
	    style.setFont(font); 
	    
		sheet.addMergedRegion(new CellRangeAddress(1,1, 4, 6));
	    row = sheet.getRow(1);
	    cell = row.createCell(4);
	    row.getCell(4).setCellStyle(style);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    
	    cell.setCellValue("BOOKING NO.");
	    
	  //BOOKING NO.	Data
	    style = workbook.createCellStyle();
	    style.setAlignment(CellStyle.VERTICAL_TOP);
	    font = workbook.createFont();
	    font.setFontHeightInPoints((short) 9);
	    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
	    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	    
	    style.setFont(font); 
	    
		sheet.addMergedRegion(new CellRangeAddress(2,2, 4, 6));
	    row = sheet.getRow(2);
	    cell = row.createCell(4);
	    row.getCell(4).setCellStyle(style);
	    cell.setCellValue(docReceiptCollection.getBn());
	    
	    
		  //BILL OF LADING NO.	Title
		    style = workbook.createCellStyle();
		    style.setAlignment(CellStyle.VERTICAL_TOP);
		    font = workbook.createFont();
		    font.setFontHeightInPoints((short) 9);
		    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    
		    style.setFont(font); 
		    
			sheet.addMergedRegion(new CellRangeAddress(1,1, 7, 8));
		    row = sheet.getRow(1);
		    cell = row.createCell(7);
		    row.getCell(7).setCellStyle(style);
		    cell.setCellValue("BILL OF LADING NO.");
		    
		  //BILL OF LADING NO.	Data
		    style = workbook.createCellStyle();
		    style.setAlignment(CellStyle.ALIGN_LEFT);
		    font = workbook.createFont();
		    font.setFontHeightInPoints((short) 9);
		    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		    
		    style.setFont(font); 
		    
			sheet.addMergedRegion(new CellRangeAddress(2,2, 7, 8));
		    row = sheet.getRow(2);
		    cell = row.createCell(7);
		    row.getCell(7).setCellStyle(style);
		    cell.setCellValue(docReceiptCollection.getBillOfLading());
		    
		    
		  //EXPORT REFERENCES Title
		    style = workbook.createCellStyle();
		    style.setAlignment(CellStyle.VERTICAL_TOP);
		    font = workbook.createFont();
		    font.setFontHeightInPoints((short) 9);
		    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    
		    style.setFont(font); 
		    
			sheet.addMergedRegion(new CellRangeAddress(3,3, 4, 8));
		    row = sheet.getRow(3);
		    cell = row.createCell(4);
		    row.getCell(4).setCellStyle(style);
		    cell.setCellValue("EXPORT REFERENCES");
		    
		  //EXPORT REFERENCES Data
		    style = workbook.createCellStyle();
		    style.setAlignment(CellStyle.VERTICAL_TOP);
		    font = workbook.createFont();
		    font.setFontHeightInPoints((short) 9);
		    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		    
		    style.setFont(font); 
		    
			sheet.addMergedRegion(new CellRangeAddress(4,5, 4, 8));
		    row = sheet.createRow(4);
		    cell = row.createCell(4);
		    row.getCell(4).setCellStyle(style);
		    cell.setCellValue(docReceiptCollection.getSrn());
		    
		    /**
			   * Ultimate Consignee
			   */
				    
				  //UltiConsignee Title (COMPLETE NAME AND ADDRESS)
				    style = workbook.createCellStyle();
				    style.setAlignment(CellStyle.VERTICAL_TOP);
				    font = workbook.createFont();
				    font.setFontHeightInPoints((short) 9);
				    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				    
				    style.setFont(font); 
				    
					sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 3));
				    row = sheet.createRow(7);
				    cell = row.createCell(0);
				    row.getCell(0).setCellStyle(style);
				    cell.setCellValue("CONSIGNEE (NOT NEGOTIABLE UNLESS CONSIGNED TO ORDER)");
				    
				  //UltiConsignee Company 
				    style = workbook.createCellStyle();
				    style.setAlignment(CellStyle.VERTICAL_TOP);
				    font = workbook.createFont();
				    font.setFontHeightInPoints((short) 10);
				    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				    
				    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				    style.setFont(font); 
				    
					sheet.addMergedRegion(new CellRangeAddress(8, 8, 0, 3));
				    row = sheet.createRow(8);
				    cell = row.createCell(0);
				    row.getCell(0).setCellStyle(style);
				    cell.setCellValue(docReceiptCollection.getUltiConsignee().getUserId().getCompany());
				    
				    
				    //UltiConsignee Address 
				    style = workbook.createCellStyle();
				    style.setAlignment(CellStyle.VERTICAL_TOP);
				    font = workbook.createFont();
				    font.setFontHeightInPoints((short) 10);
				    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				    style.setFont(font); 
				    
					sheet.addMergedRegion(new CellRangeAddress(9, 11, 0, 3));
				    row = sheet.createRow(9);
				    cell = row.createCell(0);
				    row.getCell(0).setCellStyle(style);
				    cell.setCellValue(docReceiptCollection.getUltiConsignee().getUserId().getAddress1());
				    
				    
				  //UltiConsignee Telephone 
				    style = workbook.createCellStyle();
				    style.setAlignment(CellStyle.VERTICAL_TOP);
				    font = workbook.createFont();
				    font.setFontHeightInPoints((short) 10);
				    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				    style.setFont(font); 
				    
					sheet.addMergedRegion(new CellRangeAddress(12,12, 0, 3));
				    row = sheet.createRow(12);
				    cell = row.createCell(0);
				    row.getCell(0).setCellStyle(style);
				    cell.setCellValue(docReceiptCollection.getUltiConsignee().getUserId().getPhone());
				    
				  //UltiConsignee Email 
				    style = workbook.createCellStyle();
				    style.setAlignment(CellStyle.VERTICAL_TOP);
				    font = workbook.createFont();
				    font.setFontHeightInPoints((short) 10);
				    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
				    style.setFont(font); 
				    
					sheet.addMergedRegion(new CellRangeAddress(13,13, 0, 3));
				    row = sheet.createRow(13);
				    cell = row.createCell(0);
				    row.getCell(0).setCellStyle(style);
				    cell.setCellValue(docReceiptCollection.getUltiConsignee().getUserId().getEmail());
				    
				    
				    
				    /**
					   * freight Forwarder Consignee
					   */
						    
						  //freight Forwarder Title (COMPLETE NAME AND ADDRESS)
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(7, 7, 4, 8));
						    row = sheet.getRow(7);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue("FORWARDING AGENT, F.M.C. NO.");
						    
						  //freight Forwarder Company 
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 10);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(8, 8, 4,8));
						    row = sheet.getRow(8);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getFreightForwarderId().getUserId().getCompany());
						    
						    
						    //freight Forwarder Address 
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 10);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(9, 10, 4,8));
						    row = sheet.getRow(9);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getFreightForwarderId().getUserId().getAddress1());
						    
						    
						  //freight Forwarder Telephone 
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 10);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(11,11, 4,8));
						    row = sheet.createRow(11);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getFreightForwarderId().getUserId().getPhone());
						    
						  //POINT AND COUNTRY OF ORIGIN OF GOODS
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(12,12, 4,8));
						    row = sheet.getRow(12);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue("POINT AND COUNTRY OF ORIGIN OF GOODS");
						    
						    
						  //POINT AND COUNTRY 
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 10);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(13,13, 4,8));
						    row = sheet.getRow(13);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue(loginBean.getCountrysValue(docReceiptCollection.getPortOfExportCountry()));
						    
						    
						  //NOTIFY PARTY (COMPLETE NAME AND ADDRESS) 
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(14,14, 0,3));
						    row = sheet.createRow(14);
						    cell = row.createCell(0);
						    row.getCell(0).setCellStyle(style);
						    cell.setCellValue("NOTIFY PARTY (COMPLETE NAME AND ADDRESS)");
						    
						  //NOTIFY PARTY Value
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(15,17, 0,3));
						    row = sheet.createRow(15);
						    cell = row.createCell(0);
						    row.getCell(0).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getNotifyParity());
						    
						  //DOMESTIC ROUTING/EXPORTING INSTRUCTIONS
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(14,14, 4,8));
						    row = sheet.getRow(14);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue("DOMESTIC ROUTING/EXPORTING INSTRUCTIONS");
						    
						    
						  //SAILING ON:
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 11);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(16,16, 4,8));
						    row = sheet.createRow(16);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue("SAILING ON:"+docReceiptCollection.getSailingOn());
						    
						    
						    //ITN:
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 11);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(18,18, 4,8));
						    row = sheet.createRow(18);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue("ITN: "+docReceiptCollection.getItn());
						    
						    
						  //PRE-CARRIAGE BY:
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(18,18, 0,2));
						    row = sheet.getRow(18);
						    cell = row.createCell(0);
						    row.getCell(0).setCellStyle(style);
						    cell.setCellValue("PRE-CARRIAGE BY*");
						    
						    
						  //PLACE OF RECEIPT BY PRE-CARRIER
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(18,18, 3,3));
						    row = sheet.getRow(18);
						    cell = row.createCell(3);
						    row.getCell(3).setCellStyle(style);
						    cell.setCellValue("PLACE OF RECEIPT BY PRE-CARRIER*");
						    
						    
						  //PRE-CARRIAGE BY:
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(19,19, 0,2));
						    row = sheet.createRow(19);
						    cell = row.createCell(0);
						    row.getCell(0).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getPreCarrageBy());
						    
						    
						  //PLACE OF RECEIPT BY PRE-CARRIER
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(19,19, 3,3));
						    row = sheet.getRow(19);
						    cell = row.createCell(3);
						    row.getCell(3).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getPlaceOfReceipt());
						    
						    
						    
						    
						    
						    
						    
						  //EXPORT CARRIER (VESSEL/VOY/FLAG)
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(21,21, 0,2));
						    row = sheet.createRow(21);
						    cell = row.createCell(0);
						    row.getCell(0).setCellStyle(style);
						    cell.setCellValue("EXPORT CARRIER (VESSEL/VOY/FLAG)");
						    
						    
						  //PORT OF LOADING	
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(21,21, 3,3));
						    row = sheet.getRow(21);
						    cell = row.createCell(3);
						    row.getCell(3).setCellStyle(style);
						    cell.setCellValue("PORT OF LOADING");
						    
						    
						    //EXPORT CARRIER (VESSEL/VOY/FLAG)
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(22,22, 0,2));
						    row = sheet.createRow(22);
						    cell = row.createCell(0);
						    row.getCell(0).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getExportCarrier());
						    
						    
						  //PORT OF LOADING
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(22,22, 3,3));
						    row = sheet.getRow(22);
						    cell = row.createCell(3);
						    row.getCell(3).setCellStyle(style);
						    cell.setCellValue(loginBean.getStatesValue(docReceiptCollection.getPortOfExportState()));
						    
						    
						    //LOADING PIER/TERMINAL
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(21,21, 4,8));
						    row = sheet.getRow(21);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue("LOADING PIER/TERMINAL");
						    
						    
						  //LOADING PIER/TERMINAL
						    style = workbook.createCellStyle();
						    style.setAlignment(CellStyle.VERTICAL_TOP);
						    font = workbook.createFont();
						    font.setFontHeightInPoints((short) 9);
						    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
						    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
						    
						    style.setFont(font); 
						    
							sheet.addMergedRegion(new CellRangeAddress(22,22, 4,8));
						    row = sheet.getRow(22);
						    cell = row.createCell(4);
						    row.getCell(4).setCellStyle(style);
						    cell.setCellValue(docReceiptCollection.getLoadingTerminal());
						    
						    
						  
		    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    

							  //PORT OF DISCHARGE
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.VERTICAL_TOP);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(23,23, 0,2));
							    row = sheet.createRow(23);
							    cell = row.createCell(0);
							    row.getCell(0).setCellStyle(style);
							    cell.setCellValue("PORT OF DISCHARGE");
							    
							    
							  //PLACE OF DELIVERY BY ON CARRIER*
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.VERTICAL_TOP);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(23,23, 3,3));
							    row = sheet.getRow(23);
							    cell = row.createCell(3);
							    row.getCell(3).setCellStyle(style);
							    cell.setCellValue("PLACE OF DELIVERY BY ON CARRIER*");
							    
							    
							    //PORT OF DISCHARGE
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.VERTICAL_TOP);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(24,24, 0,2));
							    row = sheet.createRow(24);
							    cell = row.createCell(0);
							    row.getCell(0).setCellStyle(style);
							    cell.setCellValue(customBean.getPortValue(Integer.valueOf(docReceiptCollection.getPortOfDestination())));
							    
							    
							  //PLACE OF DELIVERY BY ON CARRIER*
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.VERTICAL_TOP);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(24,24, 3,3));
							    row = sheet.getRow(24);
							    cell = row.createCell(3);
							    row.getCell(3).setCellStyle(style);
							    cell.setCellValue(loginBean.getCountrysValue(docReceiptCollection.getCountryOfDestination()));
							    
							    
							    //TYPE OF MOVE*	
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.VERTICAL_TOP);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(23,23, 4,8));
							    row = sheet.getRow(23);
							    cell = row.createCell(4);
							    row.getCell(4).setCellStyle(style);
							    cell.setCellValue("TYPE OF MOVE*");
							    
							    
							  //TYPE OF MOVE*
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.VERTICAL_TOP);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(24,24, 4,8));
							    row = sheet.getRow(24);
							    cell = row.createCell(4);
							    row.getCell(4).setCellStyle(style);
							    cell.setCellValue(customBean.getModeTransValue(Integer.valueOf(docReceiptCollection.getMot())));
							    
							    
							    //PARTICULARS FURNISHED BY SHIPPER
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(26,26, 0,8));
							    row = sheet.createRow(26);
							    cell = row.createCell(0);
							    row.getCell(0).setCellStyle(style);
							    cell.setCellValue("PARTICULARS FURNISHED BY SHIPPER");
							    
							    
							  //MARKS & NOS/CONTAINER NOS
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(27,27, 0,2));
							    row = sheet.createRow(27);
							    cell = row.createCell(0);
							    row.getCell(0).setCellStyle(style);
							    cell.setCellValue("MARKS & NOS/CONTAINER NOS");
							    
							  //NO. OF PKGS
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(27,27, 3,3));
							    row = sheet.getRow(27);
							    cell = row.createCell(3);
							    row.getCell(3).setCellStyle(style);
							    cell.setCellValue("NO. OF PKGS");
							    
							  //DESCRIPTION OF PACKAGES AND GOODS
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(27,27, 4,6));
							    row = sheet.getRow(27);
							    cell = row.createCell(4);
							    row.getCell(4).setCellStyle(style);
							    cell.setCellValue("DESCRIPTION OF PACKAGES AND GOODS");
							    
							  //GROSS WEIGHT
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(27,27, 7,7));
							    row = sheet.getRow(27);
							    cell = row.createCell(7);
							    row.getCell(7).setCellStyle(style);
							    cell.setCellValue("GROSS WEIGHT");
							    
							    
							  //CONT#
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(28,28, 0,2));
							    row = sheet.createRow(28);
							    cell = row.createCell(0);
							    row.getCell(0).setCellStyle(style);
							    cell.setCellValue("CONT# "+docReceiptCollection.getMark_cont());
							    
							    
							  //SEAL#
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(30,30, 0,2));
							    row = sheet.createRow(30);
							    cell = row.createCell(0);
							    row.getCell(0).setCellStyle(style);
							    cell.setCellValue("SEAL# "+docReceiptCollection.getMark_seal());
							    
							    
							  //NO. OF PKGS VALUE
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(28,28, 3,3));
							    row = sheet.getRow(28);
							    cell = row.createCell(3);
							    row.getCell(3).setCellStyle(style);
							    cell.setCellValue(docReceiptCollection.getNo_of_pkg());
							    
							  //Car
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 9);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
							    
							    style.setFont(font); 
							    //Car Vin
								sheet.addMergedRegion(new CellRangeAddress(28,28, 4,6));
								row = sheet.getRow(28);
							    cell = row.createCell(4);
							    row.getCell(4).setCellStyle(style);
							    cell.setCellValue(listOfCommodities.get(0).getDescription());
							    
							    //Car Vin
								sheet.addMergedRegion(new CellRangeAddress(29,29, 4,6));
								row = sheet.createRow(29);
							    cell = row.createCell(4);
							    row.getCell(4).setCellStyle(style);
							    cell.setCellValue(listOfCommodities.get(0).getIt_17());
							    
							  //weight
							    row = sheet.getRow(28);
							    cell = row.createCell(7);
							    row.getCell(7).setCellStyle(style);
							    cell.setCellValue(listOfCommodities.get(0).getIt_7()+"Kg");
							    
							  //price
							    row = sheet.getRow(28);
							    cell = row.createCell(8);
							    row.getCell(8).setCellStyle(style);
							    cell.setCellValue("$"+listOfCommodities.get(0).getIt_2());
							    
							    int excelCellIncr=31;
							    for(int i=1;i<listOfCommodities.size();i++) {
							    	 //Car Description
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr, 4,6));
									row = sheet.createRow(excelCellIncr);
								    cell = row.createCell(4);
								    row.getCell(4).setCellStyle(style);
								    cell.setCellValue(listOfCommodities.get(i).getDescription());
								    
								    //Car Vin
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr+1,excelCellIncr+1, 4,6));
									row = sheet.createRow(excelCellIncr+1);
								    cell = row.createCell(4);
								    row.getCell(4).setCellStyle(style);
								    cell.setCellValue(listOfCommodities.get(i).getIt_17());
								    
								  //weight
								    row = sheet.getRow(excelCellIncr);
								    cell = row.createCell(7);
								    row.getCell(7).setCellStyle(style);
								    cell.setCellValue(listOfCommodities.get(i).getIt_7()+"Kg");
								    
								  //price
								    row = sheet.getRow(excelCellIncr);
								    cell = row.createCell(8);
								    row.getCell(8).setCellStyle(style);
								    cell.setCellValue("$"+listOfCommodities.get(i).getIt_2());
								    
								    excelCellIncr+=3;
							    }
							    
							    excelCellIncr-=3;
							    excelCellIncr+=1;
							    String cellAddr="$H$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    
							    excelCellIncr-=1;
							    excelCellIncr+=3;
							    
							    
							    excelCellIncr+=2;
							    

							  //PREPAID
							    style = workbook.createCellStyle();
							    style.setAlignment(CellStyle.ALIGN_CENTER);
							    font = workbook.createFont();
							    font.setFontHeightInPoints((short) 16);
							    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
							    
							    style.setFont(font); 
							    
								sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr+1, 4,5));
							    row = sheet.createRow(excelCellIncr);
							    cell = row.createCell(4);
							    row.getCell(4).setCellStyle(style);
							    cell.setCellValue("PREPAID");
							    
							    
							    
							    
							    
							    excelCellIncr+=5;
							    cellAddr="$G$28:$G$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=5;
							    
							    excelCellIncr+=2;
							    cellAddr="$D$28:$D$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    
							    cellAddr="$C$28:$C$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    
							    excelCellIncr-=2;
							    
							    
							    
							    excelCellIncr+=4;
							    cellAddr="$H$28:$H$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=4;
							    
							    excelCellIncr+=2;
							    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=2;
							    
							    excelCellIncr+=6;
							    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=6;
							    
							    
							    excelCellIncr+=8;
							    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=8;
							    
							    
							    excelCellIncr+=9;
							    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=9;
							    
							    
							    excelCellIncr+=12;
							    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=12;
							    
							    
							    excelCellIncr+=17;
							    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
							    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
							    excelCellIncr-=17;
							    
							    
							    
							    excelCellIncr+=2;
								  //TOTAL
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_RIGHT);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 8);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr+1, 4,6));
								    row = sheet.createRow(excelCellIncr);
								    cell = row.createCell(4);
								    row.getCell(4).setCellStyle(style);
								    cell.setCellValue("TOTAL");
								    
								    
								    
								    excelCellIncr+=3;
								    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$G$"+String.valueOf(excelCellIncr);
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    excelCellIncr-=3;
								    
								    
								    excelCellIncr+=2;
								    cellAddr="$H$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    excelCellIncr-=2;
								    
								    
								    
								    
								    excelCellIncr+=6;
								    
								   
								    //FREIGHT & CHARGES
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_CENTER);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr, 0,2));
								    row = sheet.createRow(excelCellIncr);
								    cell = row.createCell(0);
								    row.getCell(0).setCellStyle(style);
								    cell.setCellValue("FREIGHT & CHARGES");
								    
								    //BASIS
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_CENTER);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr, 3,3));
								    row = sheet.getRow(excelCellIncr);
								    cell = row.createCell(3);
								    row.getCell(3).setCellStyle(style);
								    cell.setCellValue("BASIS");
								    
								    //RATE
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_CENTER);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr, 4,4));
								    row = sheet.getRow(excelCellIncr);
								    cell = row.createCell(4);
								    row.getCell(4).setCellStyle(style);
								    cell.setCellValue("RATE");
								    
								    //PREPAID
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_CENTER);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr, 5,6));
								    row = sheet.getRow(excelCellIncr);
								    cell = row.createCell(5);
								    row.getCell(5).setCellStyle(style);
								    cell.setCellValue("PREPAID");
								    
								  //COLLECT
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_CENTER);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr, 7,8));
								    row = sheet.getRow(excelCellIncr);
								    cell = row.createCell(7);
								    row.getCell(7).setCellStyle(style);
								    cell.setCellValue("COLLECT");
								    
								    cellAddr="$C$"+String.valueOf(excelCellIncr+1)+":$C$"+String.valueOf(excelCellIncr+4);
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);

								    
								    cellAddr="$D$"+String.valueOf(excelCellIncr+1)+":$D$"+String.valueOf(excelCellIncr+4);
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);

								    
								    cellAddr="$E$"+String.valueOf(excelCellIncr+1)+":$E$"+String.valueOf(excelCellIncr+9);
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);

								    
								    cellAddr="$G$"+String.valueOf(excelCellIncr+1)+":$G$"+String.valueOf(excelCellIncr+9);
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);

								    
								    excelCellIncr+=1;
								    cellAddr="$A$"+String.valueOf(excelCellIncr)+":$I$"+String.valueOf(excelCellIncr);
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    excelCellIncr-=1;
								    
								    
								    excelCellIncr+=1;
								  //PREPAID
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_LEFT);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr, 0,2));
								    row = sheet.createRow(excelCellIncr);
								    cell = row.createCell(0);
								    row.getCell(0).setCellStyle(style);
								    cell.setCellValue("PREPAID");
								    
								    
								    excelCellIncr+=3;
								  //TOTAL
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_CENTER);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr+1, 5,6));
								    row = sheet.createRow(excelCellIncr);
								    cell = row.createCell(5);
								    row.getCell(5).setCellStyle(style);
								    cell.setCellValue("TOTAL");
								    
								    
								  //TOTAL
								    style = workbook.createCellStyle();
								    style.setAlignment(CellStyle.ALIGN_CENTER);
								    font = workbook.createFont();
								    font.setFontHeightInPoints((short) 10);
								    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
								    
								    style.setFont(font); 
								    
									sheet.addMergedRegion(new CellRangeAddress(excelCellIncr,excelCellIncr+1, 7,8));
								    row = sheet.getRow(excelCellIncr);
								    cell = row.createCell(7);
								    row.getCell(7).setCellStyle(style);
								    cell.setCellValue("TOTAL");
								    
								    
								    cellAddr="$A$1:$I$1";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    
								    cellAddr="$D$2:$D$25";
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    cellAddr="$G$2:$G$3";
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
	
								    cellAddr="$C$19:$C$25";
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    cellAddr="$I$2:$I$26";
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);

	
								    excelCellIncr+=5;
								    cellAddr="$I$26:$I$"+String.valueOf(excelCellIncr);
								    RegionUtil.setBorderRight(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);

								    ///////////////////////////////////////////////////////
								    
								    cellAddr="$E$3:$I$3";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    
								    cellAddr="$A$7:$I$7";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
	
	
								    cellAddr="$E$12:$I$12";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								    
								    
								    cellAddr="$A$14:$I$14";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
						
								    
								    cellAddr="$A$18:$D$18";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
								    
								    cellAddr="$A$20:$D$20";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
								    
								    cellAddr="$A$21:$I$21";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
								    
								    cellAddr="$A$23:$I$23";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
								    
								    cellAddr="$A$25:$I$25";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
								    
								    cellAddr="$A$26:$I$26";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
								    
								    cellAddr="$A$27:$I$27";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
								    
								    cellAddr="$A$28:$I$28";
								    RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, CellRangeAddress.valueOf(cellAddr), sheet, workbook);
								   
	}
	
	
	

	

	
	
	
}
