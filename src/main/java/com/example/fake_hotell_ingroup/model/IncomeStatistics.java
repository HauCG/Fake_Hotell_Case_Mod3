package com.example.fake_hotell_ingroup.model;

import java.sql.Timestamp;

public class IncomeStatistics {
    private int incomeId;
    private int userId;
    private int incomeMonth;
    private int incomeYear;
    private double incomeTotal;

    public IncomeStatistics(int incomeId, int userId, int incomeMonth, int incomeYear, double incomeTotal) {
        this.incomeId = incomeId;
        this.userId = userId;
        this.incomeMonth = incomeMonth;
        this.incomeYear = incomeYear;
        this.incomeTotal = incomeTotal;
    }

    public IncomeStatistics(int month, double totalIncome) {
        this.incomeMonth = month;
        this.incomeTotal = totalIncome;
    }

    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(int incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public int getIncomeYear() {
        return incomeYear;
    }

    public void setIncomeYear(int incomeYear) {
        this.incomeYear = incomeYear;
    }

    public double getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(double incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

}
