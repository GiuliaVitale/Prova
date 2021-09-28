package com.azienda.catalogoProdotti.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.catalogoProdotti.Util.Costanti;
import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.model.Utente;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userInserito=req.getParameter(Costanti.CHIAVE_USR);
			String PwdInserito=req.getParameter(Costanti.CHIAVE_PW);
			
			BusinessLogic businessLogic=(BusinessLogic)getServletContext().getAttribute(Costanti.CHIAVE_CONTEXT);
			
			Utente log=businessLogic.login(userInserito, PwdInserito);
			
			if(log!=null) {
				req.getSession().setAttribute(Costanti.CHIAVE_UTENTE, log);
				req.getRequestDispatcher("/jsp/privata/home.jsp").forward(req, resp);
				
			}
			else {
				req.setAttribute(Costanti.CHIAVE_FALLITO, "Utente inesistente");
				req.getRequestDispatcher("/jsp/pubblica/login.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
