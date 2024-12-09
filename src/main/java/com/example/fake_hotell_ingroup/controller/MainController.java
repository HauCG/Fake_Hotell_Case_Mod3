package com.example.fake_hotell_ingroup.controller;

import com.example.fake_hotell_ingroup.model.IncomeStatistics;
import com.example.fake_hotell_ingroup.service.IncomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Year;
import java.util.List;



@WebServlet(name = "Controller", urlPatterns = "/Fake_Hotell")
public class MainController extends HttpServlet {
    private IncomeServiceImpl incomeService = new IncomeServiceImpl();
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showListIncome(request, response);
        } catch (ServletException er) {
            er.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showListIncome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            List<IncomeStatistics> year = incomeService.findAllIncome();
            request.setAttribute("year", year);
            request.getRequestDispatcher("RoomBooking/incomeview_temporary.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Không thể lấy data.");
            request.getRequestDispatcher("RoomBooking/incomeview_temporary.jsp").forward(request, response);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String yearParam = request.getParameter("year");
            int year = (yearParam != null) ? Integer.parseInt(yearParam) : Year.now().getValue();
            try {
                List<IncomeStatistics> incomeStats = incomeService.getMonthlyIncomeStats(year);
                request.setAttribute("incomeStats", incomeStats);
                request.setAttribute("year", year);
                getServletContext().getRequestDispatcher("/incomeview_temporary.jsp").forward(request, response);
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving income statistics");
            }
        }

//        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            String action = req.getParameter("action");
//            String yearParam = req.getParameter("year");
//            int year = (yearParam != null) ? Integer.parseInt(yearParam) : Year.now().getValue();
//
//            if ("export".equals(action)) {
//                try {
//                    List<IncomeStatistics> incomeStats = incomeService.getMonthlyIncomeStats(year);
//                    PDFExporter.exportIncomeStatsToPDF(incomeStats, "C:/exported/income_stats_" + year + ".pdf");
//                    resp.sendRedirect("export_success.jsp");
//                } catch (Exception e) {
//                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error exporting PDF");
//                }
//            }
        }



