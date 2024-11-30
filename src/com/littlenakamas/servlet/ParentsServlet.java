package com.littlenakamas.servlet;

import com.littlenakamas.dao.ParentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/parents")
public class ParentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("parents", new ParentDAO().getParents());
        this.getServletContext().getRequestDispatcher("/parents.jsp").forward(req, resp);
    }
}
