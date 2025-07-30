package com.dashboard.service;

import com.dashboard.model.CustomerFeedback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAnalyzer {
    private static List<CustomerFeedback> cachedData;

    public static void insertData(List<CustomerFeedback> data) {
        cachedData = data;
    }

    public static Map<String, Integer> getRatingCounts() {
        Map<String, Integer> counts = new HashMap<>();
        if (cachedData == null) return counts;

        for (CustomerFeedback feedback : cachedData) {
            String rating = feedback.getOverallSatisfaction();
            counts.put(rating, counts.getOrDefault(rating, 0) + 1);
        }

        return counts;
    }
}
