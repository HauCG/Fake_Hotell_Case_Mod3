package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.model.IncomeStatistics;

import java.sql.SQLException;
import java.util.List;

public interface incomeService {
    List<IncomeStatistics> findAllIncome() throws SQLException;

    IncomeStatistics getIncomeById(int userId) throws SQLException;

    int getIncomeByYear(int year) throws SQLException;

    List<IncomeStatistics> searchIncome(String keyword) throws SQLException;

    List<IncomeStatistics> getMonthlyIncomeStats(int year);
}
