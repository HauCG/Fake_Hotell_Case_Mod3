package com.example.fake_hotell_ingroup.model;

import java.sql.Timestamp;
import java.util.Date;

public class IncomeStat {
    private int revenue_id;
    private int month;
    private int year;
    private double total_revenue;

    public IncomeStat(int revenue_id, int month, int year, double total_revenue) {
        this.revenue_id = revenue_id;
        this.month = month;
        this.year = year;
        this.total_revenue = total_revenue;
    }

    public int getRevenue_id() {
        return revenue_id;
    }

    public void setRevenue_id(int revenue_id) {
        this.revenue_id = revenue_id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotal_revenue() {
        return total_revenue;
    }

    public void setTotal_revenue(double total_revenue) {
        this.total_revenue = total_revenue;
    }
}
