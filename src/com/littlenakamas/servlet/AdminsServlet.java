package com.littlenakamas.servlet;

import com.littlenakamas.bean.PersonnelAdministratif;
import com.littlenakamas.dao.EmployeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/admins", "/adminsDelete", "/adminsEdit"})
public class AdminsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        switch (url) {
            case "/admins":
                req.setAttribute("admins", new EmployeDAO().getAdminis());
                this.getServletContext().getRequestDispatcher("/admins.jsp").forward(req, resp);
                break;
            case "/adminsDelete":
                new EmployeDAO().deleteEmploye(Integer.parseInt(req.getParameter("admin-number")));
                resp.sendRedirect("admins");
                break;
            default:
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        switch (url) {
            case "/admins":
                String name = req.getParameter("admin-name");
                String lastname = req.getParameter("admin-lastname");
                String numberTelephone = req.getParameter("admin-number");
                String email = req.getParameter("admin-email");

                new EmployeDAO().addAdministratif(new PersonnelAdministratif(0, lastname, name, numberTelephone, email));
                resp.sendRedirect("admins");
                break;
            case "/adminsEdit":
                new EmployeDAO().updateAdminis(new PersonnelAdministratif(Integer.parseInt(req.getParameter("admin-old-number")),
                        req.getParameter("admin-new-name"), req.getParameter("admin-new-lastname"), req.getParameter("admin-new-telephone"),
                        req.getParameter("admin-new-email")), Integer.parseInt(req.getParameter("admin-old-number")));
                resp.sendRedirect("admins");
                break;
            default:
                break;
        }

    }
}
