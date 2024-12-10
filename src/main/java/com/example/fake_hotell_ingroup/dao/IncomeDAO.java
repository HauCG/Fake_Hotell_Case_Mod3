package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.model.IncomeStat;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface IncomeDAO {
    List<IncomeStat> findAllIncome() throws SQLException;

    List<IncomeStat> getIncomeByMonth(int month) throws SQLException;

    List<IncomeStat> getIncomeByYear(int year) throws SQLException;

    List<IncomeStat> getIncomeByYearAndMonth(int year, int month) throws SQLException;

    void exportIncomeToPDF(List<IncomeStat> income, String filePath) throws FileNotFoundException;

}
