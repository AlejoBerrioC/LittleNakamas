package com.littlenakamas.servlet;

import com.littlenakamas.bean.Enfant;
import com.littlenakamas.bean.Inscription;
import com.littlenakamas.dao.EnfantDAO;
import com.littlenakamas.dao.InscriptionDAO;

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
}
