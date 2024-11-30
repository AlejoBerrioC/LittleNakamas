package com.littlenakamas.servlet;

import com.littlenakamas.bean.PersonnelAdministratif;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("admin-name");
        String lastname = req.getParameter("admin-lastname");
        String numberTelephone = req.getParameter("admin-number");
        String email = req.getParameter("admin-email");

        new EmployeDAO().addAdministratif(new PersonnelAdministratif(0,lastname,name,numberTelephone,email));
        resp.sendRedirect("admins");
    }
}
