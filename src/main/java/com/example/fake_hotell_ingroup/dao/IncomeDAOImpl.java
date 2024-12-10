package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.model.IncomeStat;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;


public class IncomeDAOImpl implements IncomeDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/total_income";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";

    @Override
    public List<IncomeStat> findAllIncome() throws SQLException {
            String query = "SELECT revenue_id, month, year, total_revenue FROM total_income";
            List<IncomeStat> incomeStats = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Đăng ký driver (không cần thiết nếu dùng JDBC 4.0+)
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found.", e);
        }

            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    IncomeStat incomeStat = new IncomeStat(
                            resultSet.getInt("revenue_id"),
                            resultSet.getInt("month"),
                            resultSet.getInt("year"),
                            resultSet.getDouble("total_revenue")
                    );
                    incomeStats.add(incomeStat);
                }
            }
        return incomeStats;
    }

    @Override
    public List<IncomeStat> getIncomeByMonth(int month) throws SQLException {
        String query = "SELECT revenue_id, month, year, total_revenue FROM total_income WHERE month = ?";
        List<IncomeStat> incomeStats = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, month);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    IncomeStat incomeStat = new IncomeStat(
                            resultSet.getInt("revenue_id"),
                            resultSet.getInt("month"),
                            resultSet.getInt("year"),
                            resultSet.getDouble("total_revenue")
                    );
                    incomeStats.add(incomeStat);
                }
            }
        }
        return incomeStats;
    }

    @Override
    public List<IncomeStat> getIncomeByYear(int year) throws SQLException {
        String query = "SELECT revenue_id, month, year, total_revenue FROM total_income WHERE year = ?";
        List<IncomeStat> incomeStats = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, year);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    IncomeStat incomeStat = new IncomeStat(
                            resultSet.getInt("revenue_id"),
                            resultSet.getInt("month"),
                            resultSet.getInt("year"),
                            resultSet.getDouble("total_revenue")
                    );
                    incomeStats.add(incomeStat);
                }
            }
        }
        return incomeStats;
    }



    @Override
    public List<IncomeStat> getIncomeByYearAndMonth(int year, int month) throws SQLException {
        String query = "SELECT revenue_id, month, year, total_revenue FROM total_income WHERE year = ? and month = ?";
        List<IncomeStat> incomeStats = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, year);
            preparedStatement.setInt(2, month);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    IncomeStat incomeStat = new IncomeStat(
                            resultSet.getInt("revenue_id"),
                            resultSet.getInt("month"),
                            resultSet.getInt("year"),
                            resultSet.getDouble("total_revenue")
                    );
                    incomeStats.add(incomeStat);
                }
            }
        }
        return incomeStats;
    }


    @Override
    public void exportIncomeToPDF(List<IncomeStat> income, String filePath) throws FileNotFoundException {
        // Placeholder: Add logic to export to PDF (e.g., using iText or another library)
        throw new UnsupportedOperationException("Export to PDF not implemented yet.");
    }
}



