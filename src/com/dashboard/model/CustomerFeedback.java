package com.dashboard.model;

public class CustomerFeedback {
    private String customerName;
    private String date;
    private String foodQuality;
    private String hygiene;
    private String service;
    private String overallSatisfaction;

    public CustomerFeedback(String customerName, String date, String foodQuality, String hygiene, String service, String overallSatisfaction) {
        this.customerName = customerName;
        this.date = date;
        this.foodQuality = foodQuality;
        this.hygiene = hygiene;
        this.service = service;
        this.overallSatisfaction = overallSatisfaction;
    }

    public String getOverallSatisfaction() {
        return overallSatisfaction;
    }
}
