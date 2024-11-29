package com.littlenakamas.servlet;

import com.littlenakamas.bean.Employe;
import com.littlenakamas.bean.Enfant;
import com.littlenakamas.dao.EmployeDAO;
import com.littlenakamas.dao.EnfantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Envoit des données nécessaire pour affichage de dashboard
        req.setAttribute("test", "test2");
        req.setAttribute("enfants", new EnfantDAO().getChildrens());
        req.setAttribute("nbEmploye", new EmployeDAO().getEmployes().size());

        this.getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
