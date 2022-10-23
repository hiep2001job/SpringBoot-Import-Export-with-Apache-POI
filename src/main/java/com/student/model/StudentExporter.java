package com.student.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.student.entity.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentExporter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private List<Student> students;

	public StudentExporter(List<Student> students) {
		this.students = students;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sheet 1");
	}

	private void writeHeader() {
//		Add merged region
		sheet.addMergedRegion(CellRangeAddress.valueOf("A1:C1"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("A2:C2"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("A3:I3"));
		sheet.addMergedRegion(CellRangeAddress.valueOf("A4:I4"));

//		Font bold, time new roman, size 14pt
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 12);
		style.setFont(font);

		Cell cell = sheet.createRow(0).createCell(0);
		cell.setCellValue("Phòng GD&ĐT huyện Mỹ Tú");
		cell.setCellStyle(style);

		cell = sheet.createRow(1).createCell(0);
		cell.setCellValue("Trường Tiểu học Hưng Phú A");
		cell.setCellStyle(style);

		cell = sheet.createRow(2).createCell(0);
		cell.setCellValue("DANH SÁCH HỌC SINH");
		CellStyle capTionstyle = workbook.createCellStyle();
		XSSFFont captionFont = workbook.createFont();
		capTionstyle.setAlignment(HorizontalAlignment.CENTER);
		captionFont.setBold(true);
		captionFont.setFontName("Times New Roman");
		captionFont.setFontHeightInPoints((short) 14);
		capTionstyle.setFont(captionFont);
		cell.setCellStyle(capTionstyle);

		cell = sheet.createRow(3).createCell(0);
		cell.setCellValue("Năm học: 2022-2023");
		CellStyle capTion2style = workbook.createCellStyle();
		XSSFFont caption2Font = workbook.createFont();
		capTion2style.setAlignment(HorizontalAlignment.CENTER);
		caption2Font.setBold(true);
		caption2Font.setFontName("Times New Roman");
		caption2Font.setFontHeightInPoints((short) 14);
		capTion2style.setFont(caption2Font);
		cell.setCellStyle(capTionstyle);

		CellStyle titleStyle = workbook.createCellStyle();
		XSSFFont titleFont = workbook.createFont();
		titleFont.setBold(true);
		titleFont.setFontName("Times New Roman");
		titleFont.setFontHeightInPoints((short) 12);
		titleStyle.setFont(titleFont);

		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setBorderBottom(BorderStyle.THIN);
		titleStyle.setBorderTop(BorderStyle.THIN);
		titleStyle.setBorderLeft(BorderStyle.THIN);
		titleStyle.setBorderRight(BorderStyle.THIN);

		Row row = sheet.createRow(5);
		cell = row.createCell(0);
		cell.setCellValue("STT" );
		cell.setCellStyle(titleStyle);

		cell = row.createCell(1);
		cell.setCellValue("Họ tên");
		cell.setCellStyle(titleStyle);

		cell = row.createCell(2);
		cell.setCellValue("Ngày sinh");
		cell.setCellStyle(titleStyle);

		cell = row.createCell(3);
		cell.setCellValue("Giới tính");
		cell.setCellStyle(titleStyle);

		cell = row.createCell(4);
		cell.setCellValue("Lớp");
		cell.setCellStyle(titleStyle);

		cell = row.createCell(5);
		cell.setCellValue("Dân tộc");
		cell.setCellStyle(titleStyle);

		cell = row.createCell(6);
		cell.setCellValue("Tên cha");
		cell.setCellStyle(titleStyle);

		cell = row.createCell(7);
		cell.setCellValue("Tên mẹ");
		cell.setCellStyle(titleStyle);

		cell = row.createCell(8);
		cell.setCellValue("Chỗ ở hiện nay");
		cell.setCellStyle(titleStyle);

//		Set auto sizing
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		sheet.autoSizeColumn(8);


	}

	// style của data có thể làm như header
	private void writeData() {
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();

		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 12);
		style.setFont(font);

		style.setAlignment(HorizontalAlignment.LEFT);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		
		int cnt = 1;
		int rowPos=6;
		for (Student student : students) {
			Row row = sheet.createRow(rowPos++);

			Cell cell = row.createCell(0);
			cell.setCellValue(cnt);
			cell.setCellStyle(style);

			cell = row.createCell(1);
			cell.setCellValue(student.getName());
			cell.setCellStyle(style);

			cell = row.createCell(2);
			cell.setCellValue(student.getDateOfBirth());
			cell.setCellStyle(style);


			cell = row.createCell(3);
			cell.setCellValue(student.getGender());
			cell.setCellStyle(style);

			cell = row.createCell(4);
			cell.setCellValue(student.getStudentClass());
			cell.setCellStyle(style);

			cell = row.createCell(5);
			cell.setCellValue(student.getEthnic());
			cell.setCellStyle(style);

			cell = row.createCell(6);
			cell.setCellValue(student.getFatherName());
			cell.setCellStyle(style);

			cell = row.createCell(7);
			cell.setCellValue(student.getMotherName());
			cell.setCellStyle(style);

			cell = row.createCell(8);
			cell.setCellValue(student.getCurrentAddress());
			cell.setCellStyle(style);

			cnt++;
		}
//		Set auto sizing
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		sheet.autoSizeColumn(8);
	}

	public void export(HttpServletResponse res) throws IOException {
		writeHeader();
		writeData();

		ServletOutputStream outputStream = res.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
