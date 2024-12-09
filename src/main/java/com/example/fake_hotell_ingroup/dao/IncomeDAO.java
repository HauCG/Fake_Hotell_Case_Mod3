package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.model.IncomeStatistics;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface IncomeDAO {
    List<IncomeStatistics> findAllIncome() throws SQLException;

    IncomeStatistics getIncomeById(int userId) throws SQLException;

    List<IncomeStatistics> getIncomeByYear(int year) throws SQLException;

    void exportIncomeToPDF(List<IncomeStatistics> income, String filePath) throws FileNotFoundException;

    void deleteIncome(int userId) throws SQLException;

    List<IncomeStatistics> searchUsers(String keyword) throws SQLException;


}
