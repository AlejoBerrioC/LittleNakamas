package com.littlenakamas.servlet;

import com.littlenakamas.bean.Educatrice;
import com.littlenakamas.dao.EmployeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/teachers", "/teachersDelete"})
public class TeachersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        switch (url) {
            case "/teachers":
                req.setAttribute("teachers", new EmployeDAO().getTeachers());
                this.getServletContext().getRequestDispatcher("/teachers.jsp").forward(req, resp);
                break;
            case "/teachersDelete":
                new EmployeDAO().deleteEmploye(Integer.parseInt(req.getParameter("teacher-number")));
                resp.sendRedirect("teachers");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("educ-name");
        String lastname = req.getParameter("educ-lastname");
        String diploma = req.getParameter("educ-diploma");
        int nbChildrens = Integer.parseInt(req.getParameter("educ-numchildrens"));

        new EmployeDAO().addTeacher(new Educatrice(0, lastname, name, diploma, nbChildrens));
        resp.sendRedirect("teachers");
    }
}
