package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.model.IncomeStat;

import java.sql.SQLException;
import java.util.List;

public interface incomeService {
    List<IncomeStat> findAllIncome() throws SQLException;

    List<IncomeStat> getIncomeByYear(int year) throws SQLException;

    List<IncomeStat> getIncomeByMonth(int month) throws SQLException;

    List<IncomeStat> getIncomeByYearAndMonth(int year, int month) throws SQLException;
}
