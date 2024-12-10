package com.example.fake_hotell_ingroup.controller;

import com.example.fake_hotell_ingroup.dao.IncomeDAO;
import com.example.fake_hotell_ingroup.dao.IncomeDAOImpl;
import com.example.fake_hotell_ingroup.model.IncomeStat;
import com.example.fake_hotell_ingroup.service.IncomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


import java.sql.SQLException;


@WebServlet(name = "IncomeController", urlPatterns = "/income_statistics")
public class IncomeController extends HttpServlet {

    private IncomeServiceImpl incomeService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize IncomeDAO and IncomeService
        IncomeDAO incomeDAO = new IncomeDAOImpl();
        incomeService = new IncomeServiceImpl();
        incomeService.setIncomeDAO(incomeDAO);
    }

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String yearParam = request.getParameter("year");
        String monthParam = request.getParameter("month");

        try {
            List<IncomeStat> incomeStats;
            double totalIncome = 0;
            // Kiểm tra valid month
            if (monthParam != null && !monthParam.isEmpty()) {
                int month = Integer.parseInt(monthParam);
                if (month < 1 || month > 12) {
                    // Nếu tháng không hợp lệ, chuyển tới trang lỗi
                    request.setAttribute("errorMessage", "Month must be between 1 and 12.");
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                    return;
                }
            }
            if (yearParam != null && !yearParam.isEmpty() && monthParam != null && !monthParam.isEmpty()) {
                // Xử lý khi cả year và month có giá trị
                int year = Integer.parseInt(yearParam);
                int month = Integer.parseInt(monthParam);
                incomeStats = incomeService.getIncomeByYearAndMonth(year, month);
                totalIncome = incomeStats.stream()
                        .mapToDouble(IncomeStat::getTotal_revenue)
                        .sum();
                request.setAttribute("filter", "year_and_month");
            } else if (yearParam != null && !yearParam.isEmpty()) {
                // Xử lý khi chỉ có year
                int year = Integer.parseInt(yearParam);
                incomeStats = incomeService.getIncomeByYear(year);
                totalIncome = incomeStats.stream()
                        .mapToDouble(IncomeStat::getTotal_revenue)
                        .sum();
                request.setAttribute("filter", "year");
            } else if (monthParam != null && !monthParam.isEmpty()) {
                // Xử lý khi chỉ có month
                int month = Integer.parseInt(monthParam);
                incomeStats = incomeService.getIncomeByMonth(month);
                totalIncome = incomeStats.stream()
                        .mapToDouble(IncomeStat::getTotal_revenue)
                        .sum();
                request.setAttribute("filter", "month");
            } else {
                // Xử lý khi không có filter nào
                incomeStats = incomeService.findAllIncome();
                totalIncome = incomeStats.stream()
                        .mapToDouble(IncomeStat::getTotal_revenue)
                        .sum();
                request.setAttribute("filter", "all");
            }

            request.setAttribute("incomeStats", incomeStats);
            request.setAttribute("totalIncome", totalIncome);
            request.getRequestDispatcher("income/index.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid filter parameter.");
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
        }
    }

}




