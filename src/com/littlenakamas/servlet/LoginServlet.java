package com.littlenakamas.servlet;

import com.littlenakamas.bean.Employe;
import com.littlenakamas.dao.EmployeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeDAO empD = new EmployeDAO();

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastname");
        String password = req.getParameter("password");

        Employe employe = empD.getEmployeByLogin(name, lastName, password);

        if (employe != null) {
            // Set the employe_id to be set on the session
            HttpSession session = req.getSession();
            session.setAttribute("employe_id", employe.numEmp);
            this.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
        } else {
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}
