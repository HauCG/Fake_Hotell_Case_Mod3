package com.example.fake_hotell_ingroup.service;

import com.example.fake_hotell_ingroup.dao.IncomeDAO;
import com.example.fake_hotell_ingroup.model.IncomeStat;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class IncomeServiceImpl implements incomeService{
    private IncomeDAO incomeDAO ;
    @Override
    public List<IncomeStat> findAllIncome() throws SQLException {
        return incomeDAO.findAllIncome();
    }

    @Override
    public List<IncomeStat> getIncomeByYear(int year) throws SQLException {
        return incomeDAO.getIncomeByYear(year);
    }

    @Override
    public List<IncomeStat> getIncomeByMonth(int month) throws SQLException {
        return incomeDAO.getIncomeByMonth(month);
    }

    @Override
    public List<IncomeStat> getIncomeByYearAndMonth(int year, int month) throws SQLException {
        return incomeDAO.getIncomeByYearAndMonth(year, month);
    }
    public void setIncomeDAO(IncomeDAO incomeDAO) {
        this.incomeDAO = incomeDAO;
    }
}
