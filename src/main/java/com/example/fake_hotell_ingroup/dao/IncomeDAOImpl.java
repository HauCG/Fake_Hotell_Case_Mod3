package com.example.fake_hotell_ingroup.dao;

import com.example.fake_hotell_ingroup.connection.DatabaseConnection;
import com.example.fake_hotell_ingroup.model.IncomeStatistics;

import javax.swing.text.Document;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class IncomeDAOImpl implements IncomeDAO {
    private final DatabaseConnection databaseConnection= new DatabaseConnection();
    private static final String SELECT_ALL_INCOME = "select * from income";
    private static final String UPDATE_INCOME_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SELECT_INCOME_BY_room_id= "SELECT * FROM income WHERE Id =?";

    @Override
    public List<IncomeStatistics> findAllIncome() throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM booking");
        ResultSet rs = statement.executeQuery();
        List<IncomeStatistics> incomes = new ArrayList<>();
        while (rs.next()) {
            IncomeStatistics income = new IncomeStatistics(
                    rs.getInt("incomeId"),
                    rs.getInt("userId"),
                    rs.getInt("incomeMonth"),
                    rs.getInt("incomeYear"),
                    rs.getDouble("incomeTotal")
            );
            incomes.add(income);
        }
        return incomes;
    }

    @Override
    public IncomeStatistics getIncomeById(int incomeId) throws SQLException {
        IncomeStatistics income = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INCOME_BY_room_id)) {
            preparedStatement.setInt(1, incomeId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int incomeId1 = rs.getInt("incomeId");
                int userId = rs.getInt("userID");
                int incomeMonth = rs.getInt("incomeMonth");
                int incomeYear = rs.getInt("incomeYear");
                double incomeTotal = rs.getDouble("incomeTotal");
                Timestamp incomeCreateTime = rs.getTimestamp("IncomeCreateTime");
                Timestamp incomeUpdateTime = rs.getTimestamp("IncomeUpdateTime");
                income = new IncomeStatistics(incomeId,userId,incomeMonth,incomeYear,incomeTotal);
            }
        } catch (SQLException e) {
            ;
        }
        return income;

    }


    public List<IncomeStatistics> getIncomeByYear(int year) throws SQLException {
        String query = "SELECT MONTH(booking_date) AS month, SUM(total_income) AS total_income " +
                "FROM booking WHERE YEAR(booking_date) = ? " +
                "GROUP BY MONTH(booking_date) ORDER BY month";

        List<IncomeStatistics> stats = new ArrayList<>();
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, year);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int month = rs.getInt("month");
                    double totalIncome = rs.getDouble("total_income");
                    stats.add(new IncomeStatistics(month, totalIncome));
                }
            }
        }
        return stats;
    }

    @Override
    public void exportIncomeToPDF(List<IncomeStatistics> income, String filePath) throws  FileNotFoundException {
//        Document document = new Document();
//        PdfWriter.getInstance(document, new FileOutputStream(filePath));
//
//        document.open();
//        document.add(new Paragraph("Thống kê thu nhập"));
//        document.add(new Paragraph(" "));
//
//        PdfPTable table = new PdfPTable(2);
//        table.addCell("Tháng");
//        table.addCell("Tổng tiền");
//
//        for (IncomeStats stat : stats) {
//            table.addCell(String.valueOf(stat.getMonth()));
//            table.addCell(String.format("%.2f", stat.getTotalIncome()));
//        }
//
//        document.add(table);
//        document.close();
    }



    @Override
    public void deleteIncome(int userId) throws SQLException {

    }

    @Override
    public List<IncomeStatistics> searchUsers(String keyword) throws SQLException {
        return Collections.emptyList();
    }


}
