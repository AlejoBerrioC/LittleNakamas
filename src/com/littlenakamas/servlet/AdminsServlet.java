package com.littlenakamas.servlet;

import com.littlenakamas.dao.EmployeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admins")
public class AdminsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("admins", new EmployeDAO().getAdminis());
        this.getServletContext().getRequestDispatcher("/admins.jsp").forward(req, resp);
    }
}