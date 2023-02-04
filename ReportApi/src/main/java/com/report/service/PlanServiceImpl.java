package com.report.service;

import java.awt.Color;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.report.binding.Plan;
import com.report.binding.SearchRequest;
import com.report.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository prepo;

	@Override
	public List<String> getPlanNames() {
		return prepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		return prepo.getPlanStatus();
	}

	@Override
	public List<Plan> getPlans(SearchRequest request) {
		Plan p = new Plan();
		if (request.getPlanName() != null && !request.getPlanName().equals("")) {
			p.setPlanName(request.getPlanName());
		}
		if (request.getPlanStatus() != null && !request.getPlanStatus().equals("")) {
			p.setPlanStatus(request.getPlanStatus());
		}
		Example<Plan> example = Example.of(p);
		List<Plan> records = prepo.findAll();
		return records;
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Citizen info");

		XSSFRow headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("SSN");
		headerRow.createCell(3).setCellValue("Gender");
		headerRow.createCell(4).setCellValue("Plan Name");
		headerRow.createCell(5).setCellValue("Plan Status");

		List<Plan> records = prepo.findAll();

		int dataRowIndex = 1;
		for (Plan record : records) {

			XSSFRow dataRow = sheet.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(record.getCid());
			dataRow.createCell(1).setCellValue(record.getCname());
			dataRow.createCell(2).setCellValue(record.getSsn());
			dataRow.createCell(3).setCellValue(record.getGender());
			dataRow.createCell(4).setCellValue(record.getPlanName());
			dataRow.createCell(5).setCellValue(record.getPlanStatus());

			dataRowIndex++;
		}
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();

	}

	@Override
	public void exportPdf(HttpServletResponse response) throws Exception {

		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Citizens Plan Info", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f, 1.5f });
		table.setSpacingBefore(10);

		// set table header data
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font f = FontFactory.getFont(FontFactory.HELVETICA);
		f.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ID", f));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", f));
		table.addCell(cell);

		cell.setPhrase(new Phrase("SSN", f));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Gender", f));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Name", f));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan Status", f));
		table.addCell(cell);

		// set table data
		List<Plan> records = prepo.findAll();
		for (Plan record : records) {
			table.addCell(String.valueOf(record.getCid()));
			table.addCell(record.getCname());
			table.addCell(String.valueOf(record.getSsn()));
			table.addCell(record.getGender());
			table.addCell(record.getPlanName());
			table.addCell(record.getPlanStatus());
		}

		document.add(table);
		document.close();
	}

}
