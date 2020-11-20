package com.capstone.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capstone.dao.ApplicationDao;

public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        ApplicationDao dao= new ApplicationDao();
        boolean isValidUser = dao.validateUser(username, password);
        
        if(isValidUser){           
            req.setAttribute("username", username);
            req.getRequestDispatcher("/html/index.jsp").forward(req, resp);
        }
        else{
            String errorMessage="Invalid Credentials, please login again!";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
        dispatcher.include(req, resp);
    }
}
