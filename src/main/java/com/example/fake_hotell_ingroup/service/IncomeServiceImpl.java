package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.dao.IncomeDAOImpl;
import com.example.fake_hotell_ingroup.model.IncomeStatistics;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class IncomeServiceImpl implements incomeService{
   private IncomeDAOImpl incomeDao;

    @Override
    public List<IncomeStatistics> findAllIncome() throws SQLException {
        try {
            return incomeDao.findAllIncome();
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi xảy ra
        }
    }

    @Override
    public IncomeStatistics getIncomeById(int userId) throws SQLException {
        return null;
    }

    @Override
    public int getIncomeByYear(int year) throws SQLException {
        return 0;
    }


    @Override
    public List<IncomeStatistics> searchIncome(String keyword) throws SQLException {
        return Collections.emptyList();
    }

    @Override
    public List<IncomeStatistics> getMonthlyIncomeStats(int year) {
        return Collections.emptyList();
    }
}
