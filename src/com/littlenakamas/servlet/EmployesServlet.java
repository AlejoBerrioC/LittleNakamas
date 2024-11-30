package com.littlenakamas.servlet;

import com.littlenakamas.dao.EmployeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employees")
public class EmployesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("employees", new EmployeDAO().getEmployes());
        this.getServletContext().getRequestDispatcher("/employees.jsp").forward(req, resp);
    }
}
