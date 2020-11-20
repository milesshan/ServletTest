package com.capstone.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capstone.dao.ApplicationDao;

public class CheckoutServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Integer> products = new ArrayList<Integer>();
        products.add(Integer.parseInt(req.getParameter("vegetables")));
        products.add(Integer.parseInt(req.getParameter("bakedGoods")));
        products.add(Integer.parseInt(req.getParameter("meats")));
        
        ApplicationDao dao = new ApplicationDao();
        int rows = dao.submitOrder(products);
        
        req.setAttribute("vegetables", 0);
        req.setAttribute("bakedGoods", 0);
        req.setAttribute("meats", 0);
        
        String errorMessage = null;
        if(rows==0){
            errorMessage="An error occured while submitting your order!";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/html/checkout.jsp").forward(req, resp);
        }
        else{
            errorMessage="Order submitted successfully!";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/html/checkout.jsp").forward(req, resp);
        } 
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {                 
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/checkout.jsp");
        dispatcher.include(req, resp);
    }
}
