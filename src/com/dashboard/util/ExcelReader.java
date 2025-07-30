package com.dashboard.util;

import com.dashboard.model.CustomerFeedback;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<CustomerFeedback> readExcel(String path) {
        List<CustomerFeedback> feedbackList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            boolean firstRow = true;

            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue; // Skip header
                }

                String customerName = row.getCell(0).getStringCellValue();
                String date = row.getCell(1).getStringCellValue();
                String foodQuality = row.getCell(2).getStringCellValue();
                String hygiene = row.getCell(3).getStringCellValue();
                String service = row.getCell(4).getStringCellValue();
                String overallSatisfaction = row.getCell(5).getStringCellValue();

                feedbackList.add(new CustomerFeedback(customerName, date, foodQuality, hygiene, service, overallSatisfaction));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return feedbackList;
    }
}
