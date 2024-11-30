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

@WebServlet("/enfant")
public class EnfantsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Enfant> enfants = new EnfantDAO().getChildrens();
        ArrayList<Inscription> inscriptions = new ArrayList<>();
        for (Enfant enfant : enfants){
            Inscription inscription = new InscriptionDAO().getInscriptionByNumEnf(enfant.numEnf);
            inscriptions.add(inscription);
        }
        req.setAttribute("enfants", enfants);
        req.setAttribute("dates", inscriptions);

        this.getServletContext().getRequestDispatcher("/childrens.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("enfant-name");
        String lastname = req.getParameter("enfant-lastname");
        int age = Integer.parseInt(req.getParameter("enfant-age"));
        String parentNumber = req.getParameter("parent-number");

        new EnfantDAO().addEnfant(new Enfant(0, name, lastname, age, ParentDAO.getParenByTel(parentNumber)));
        resp.sendRedirect("enfant");
    }
}
