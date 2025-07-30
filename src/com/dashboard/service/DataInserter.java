package com.dashboard.service;

import com.dashboard.model.CustomerFeedback;

import java.util.List;

public class DataInserter {
    public static void insertFeedback(List<CustomerFeedback> feedbackList) {
        // For now, just print confirmation
        System.out.println("Inserted " + feedbackList.size() + " feedback entries.");
    }
}
