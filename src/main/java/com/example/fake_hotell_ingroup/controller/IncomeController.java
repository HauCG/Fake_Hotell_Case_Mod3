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
            if (yearParam != null) {
                int year = Integer.parseInt(yearParam);
                List<IncomeStat> incomeStats = incomeService.getIncomeByYear(year);
                request.setAttribute("incomeStats", incomeStats);
                request.setAttribute("filter", "year");
            } else if (monthParam != null) {
                int month = Integer.parseInt(monthParam);
                List<IncomeStat> incomeStats = incomeService.getIncomeByMonth(month);
                request.setAttribute("incomeStats", incomeStats);
                request.setAttribute("filter", "month");
            } else {
                List<IncomeStat> incomeStats = incomeService.findAllIncome();
                request.setAttribute("incomeStats", incomeStats);
                request.setAttribute("filter", "all");
            }

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid filter parameter.");
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
        }
    }
}




