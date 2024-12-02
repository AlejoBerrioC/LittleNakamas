package com.littlenakamas.servlet;

import com.littlenakamas.bean.Enfant;
import com.littlenakamas.bean.Inscription;
import com.littlenakamas.bean.Parent;
import com.littlenakamas.dao.EnfantDAO;
import com.littlenakamas.dao.InscriptionDAO;
import com.littlenakamas.dao.ParentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/enfant", "/enfantDelete"})
public class EnfantsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getServletPath();

        switch (url) {
            case "/enfant":
                ArrayList<Enfant> enfants = new EnfantDAO().getChildrens();
                ArrayList<Inscription> inscriptions = new ArrayList<>();
                for (Enfant enfant : enfants) {
                    Inscription inscription = new InscriptionDAO().getInscriptionByNumEnf(enfant.numEnf);
                    inscriptions.add(inscription);
                }
                req.setAttribute("enfants", enfants);
                req.setAttribute("dates", inscriptions);

                this.getServletContext().getRequestDispatcher("/childrens.jsp").forward(req, resp);
                break;
            case "/enfantDelete":
                new EnfantDAO().deleteEnfant(Integer.parseInt(req.getParameter("children-number")));
                resp.sendRedirect("enfant");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("enfant-name");
        String lastname = req.getParameter("enfant-lastname");
        int age = Integer.parseInt(req.getParameter("enfant-age"));
        String parentNumber = req.getParameter("parent-number");

        int numEmp = (int) req.getAttribute("employee_id");

        new EnfantDAO().addEnfant(new Enfant(0, name, lastname, age, ParentDAO.getParenByTel(parentNumber)),
                numEmp);
        resp.sendRedirect("enfant");
    }
}
