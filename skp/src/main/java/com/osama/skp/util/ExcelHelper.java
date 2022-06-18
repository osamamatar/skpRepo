package com.osama.skp.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.osama.skp.domain.EmailSubscriber;
import com.osama.skp.exceptions.AbstractGlopalException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

    static String[] EMAILHEADERs = { "Id","FirstName", "LastName","Email"};
    static String SHEET = "emailSubscribers";
    public static ByteArrayInputStream emailSubscribersToExcel(List<EmailSubscriber> emailSubscribers) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < EMAILHEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(EMAILHEADERs[col]);
            }
            int rowIdx = 1;
            for (EmailSubscriber emailSubscriber : emailSubscribers) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(emailSubscriber.getId());
                row.createCell(1).setCellValue(emailSubscriber.getFirstName());
                row.createCell(2).setCellValue(emailSubscriber.getLastName());
                row.createCell(3).setCellValue(emailSubscriber.getEmail());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new AbstractGlopalException("fail to import data to Excel file");
        }
    }
}
