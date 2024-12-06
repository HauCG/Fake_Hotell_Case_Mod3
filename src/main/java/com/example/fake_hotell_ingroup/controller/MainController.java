package com.example.fake_hotell_ingroup.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = "/Fake_Hotell")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String show = request.getParameter("S");
        if (show == null || show.isEmpty()) {
            show = "WelcomePage";
        }
        switch (show) {
            case "WelcomePage":
                showWelcomePage(request, response);
                break;
            case "LoginPage":
                showLoginPage(request, response);
                break;
            case "RegisterPage":
                showRegisterPage(request, response);
                break;
            case "PasswordRecoveryPage":
                showPasswordRecoveryPage(request, response);
                break;
            case "IntroductionPage":
                showIntroductionPage(request, response);
                break;
            case "other":
                /// other methods
                break;
            default:
                showNotFoundPage(request, response);
                break;
        }
    }


    private void showWelcomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Main_View/WelcomePage.jsp").forward(request, response);
    }

    private void showNotFoundPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Main_View/NotFoundPage.jsp").forward(request, response);
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Authentication_View/LoginPage.jsp").forward(request, response);
    }

    private void showRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Authentication_View/RegisterPage.jsp").forward(request, response);
    }

    private void showPasswordRecoveryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Authentication_View/PasswordRecoveryPage.jsp").forward(request, response);
    }

    private void showIntroductionPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Main_View/IntroductionPage.jsp").forward(request, response);
    }
}

