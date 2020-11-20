package com.capstone.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capstone.beans.User;
import com.capstone.dao.ApplicationDao;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User user = new User(username, password);
        
        ApplicationDao dao = new ApplicationDao();
        int rows = dao.registerUser(user);
        
        String errorMessage = null;
        if(rows==0){
            errorMessage="Sorry, did not register successfully!";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/html/register.jsp").forward(req, resp);
        }
        else{
            errorMessage="User registered successfully!";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/html/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/register.jsp");
        dispatcher.include(req, resp);
    }
}
