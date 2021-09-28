package com.azienda.catalogoProdotti.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.catalogoProdotti.Util.Costanti;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet{


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
			req.getSession().removeAttribute(Costanti.CHIAVE_UTENTE);
			req.getRequestDispatcher("/jsp/pubblica/login.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			String s=e.getMessage();
			req.setAttribute(Costanti.CHIAVE_ERRORE, s);
			req.getRequestDispatcher("/jsp/pubblica/errore.jsp").forward(req, resp);
		}
	}
}
