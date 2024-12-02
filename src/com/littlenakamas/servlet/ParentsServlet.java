package com.littlenakamas.servlet;

import com.littlenakamas.bean.Parent;
import com.littlenakamas.dao.ParentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/parents", "/parentsDelete", "/parentsEdit"})
public class ParentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        switch (url) {
            case "/parents":
                req.setAttribute("parents", new ParentDAO().getParents());
                this.getServletContext().getRequestDispatcher("/parents.jsp").forward(req, resp);
                break;
            case "/parentsDelete":
                new ParentDAO().deleteParent(req.getParameter("parent-number"));
                resp.sendRedirect("parents");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        switch (url) {
            case "/parents":
                String name = req.getParameter("parent-name");
                String lastname = req.getParameter("parent-lastname");
                String number = req.getParameter("parent-number");

                new ParentDAO().addParent(new Parent(number, lastname, name));
                resp.sendRedirect("enfant");
                break;
            case "/parentsEdit":
                new ParentDAO().updateParent(new Parent(req.getParameter("parent-new-number"), req.getParameter("parent-new-lastname"), req.getParameter("parent-new-name")),
                        req.getParameter("parent-old-number"));
                resp.sendRedirect("parents");
        }


    }
}
