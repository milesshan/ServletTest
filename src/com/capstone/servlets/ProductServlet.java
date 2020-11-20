package com.capstone.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ArrayList<Integer> products = new ArrayList<Integer>();
        products.add(Integer.parseInt(req.getParameter("vegetables")));
        products.add(Integer.parseInt(req.getParameter("bakedGoods")));
        products.add(Integer.parseInt(req.getParameter("meats")));
                       
        req.setAttribute("vegetables", products.get(0));
        req.setAttribute("bakedGoods", products.get(1));
        req.setAttribute("meats", products.get(2));
        req.getRequestDispatcher("/html/checkout.jsp").forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {     
        RequestDispatcher dispatcher = req.getRequestDispatcher("/html/products.html");
        dispatcher.include(req, resp);
    }
}
