package web;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.entities.Compte;
import metier.session.IBanqueLocal;
//@WebServlet(name="cs", urlPatterns={"*.php"})
public class BanqueServlet extends HttpServlet{
	@EJB
	private IBanqueLocal metier;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action!=null)
		if(action.equals("delete")){
			Long code=Long.parseLong(request.getParameter("code"));
			metier.supprimerCompte(code);
		}
		request.setAttribute("comptes", metier.getAllComptes());
	    request.getRequestDispatcher("Banque.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("verser")){
			Long code=Long.parseLong(request.getParameter("code1"));
			double montant=Double.parseDouble(request.getParameter("montant"));
			metier.verser(montant, code);			
		}else if(action.equals("retirer")){
			Long code=Long.parseLong(request.getParameter("code1"));
			double montant=Double.parseDouble(request.getParameter("montant"));
			metier.retirer(montant, code);
		}else if(action.equals("virement")){
			Long code1=Long.parseLong(request.getParameter("code1"));
			Long code2=Long.parseLong(request.getParameter("code2"));
			double montant=Double.parseDouble(request.getParameter("montant"));
			metier.virement(montant, code1, code2);
		}else if(action.equals("ajouter")){
			metier.addCompte(new Compte(0, new Date(), true));
		}
		request.setAttribute("comptes", metier.getAllComptes());
	    request.getRequestDispatcher("Banque.jsp").forward(request, response);
	}

}
