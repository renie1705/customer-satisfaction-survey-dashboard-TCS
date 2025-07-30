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
            String excelPath = "data/customer_feedback.xlsx";

            // Read feedback data from Excel
            List<CustomerFeedback> data = ExcelReader.readExcel(excelPath);

            if (data == null || data.isEmpty()) {
                System.out.println("No customer feedback data found.");
                return;
            }

            // Insert feedback data into storage
            DataInserter.insertFeedback(data);

            // Analyze ratings
            Map<String, Integer> ratingData = DataAnalyzer.getRatingCounts();

            // Generate and display bar chart
            ChartGenerator.showBarChart(ratingData);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
