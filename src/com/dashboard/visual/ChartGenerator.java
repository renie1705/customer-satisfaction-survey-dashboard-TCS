package com.dashboard;

import com.dashboard.model.CustomerFeedback;
import com.dashboard.service.DataAnalyzer;
import com.dashboard.service.DataInserter;
import com.dashboard.util.ExcelReader;
import com.dashboard.visual.ChartGenerator;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            String excelPath = "data/customer_satisfaction_cleaned.xlsx";

            List<CustomerFeedback> data = ExcelReader.readExcel(excelPath);
            if (data == null || data.isEmpty()) {
                System.out.println("No customer feedback data found.");
                return;
            }

            DataInserter.insertFeedback(data);
            DataAnalyzer.insertData(data); // Cache the data

            Map<String, Integer> ratingData = DataAnalyzer.getRatingCounts();
            ChartGenerator.showBarChart(ratingData);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
