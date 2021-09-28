package com.azienda.catalogoProdotti.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.azienda.catalogoProdotti.Util.Costanti;
import com.azienda.catalogoProdotti.businessLogic.BusinessLogic;
import com.azienda.catalogoProdotti.model.Prodotto;

@WebServlet("/prodottoServlet")
public class ProdottoServlet extends HttpServlet{

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
			String operazione=req.getParameter(Costanti.CHIAVE_OPERAZIONI);
			BusinessLogic businessLogic=(BusinessLogic) req.getServletContext().getAttribute(Costanti.CHIAVE_CONTEXT);
			
			String nome=req.getParameter(Costanti.CHIAVE_NOMEPRODOTTO);
			String prezzo=req.getParameter(Costanti.CHIAVE_PREZZOPRODOTTO);
			Float p=null;
			if(!prezzo.isEmpty()) {
				p=Float.parseFloat(prezzo);
			}
			if(operazione.equals(Costanti.VALORE_RICERCA)) {
				try {
					
					List<Prodotto> risultatoRicerca=businessLogic.getProdotti(nome, p);
					req.setAttribute(Costanti.RISULTATO_OPERAZIONE, risultatoRicerca);
					
					req.getRequestDispatcher("jsp/privata/risultatiRicercaProdotti.jsp").forward(req, resp);
					
				} catch (Exception e) {
					e.printStackTrace();
					String x=e.getMessage();
					req.setAttribute(Costanti.CHIAVE_ERRORE, x);
					req.getRequestDispatcher("jsp/privata/esito.jsp").forward(req, resp);

				}
				
			}else if(operazione.equals(Costanti.VALORE_CREAZIONE)){
				
				try {
				String esito="Prodotto registrato";
				businessLogic.creaProdotto(nome, p);
				req.setAttribute(Costanti.RISULTATO_OPERAZIONE, esito);
				req.getRequestDispatcher("jsp/privata/esito.jsp").forward(req, resp);

				
				} catch (Exception e) {
					String esito="Prodotto non registrato";
					req.setAttribute(Costanti.RISULTATO_OPERAZIONE, esito);
					req.getRequestDispatcher("jsp/privata/esito.jsp").forward(req, resp);
					}
			
				
			}else if(operazione.equals(Costanti.VALORE_MODIFICA)){
				List<Prodotto> risultatoRicerca=businessLogic.getProdotti(nome, p);
				req.setAttribute(Costanti.RISULTATO_OPERAZIONE, risultatoRicerca);
				
				req.getRequestDispatcher("jsp/privata/admin/risultatiRicercaAggiornamento.jsp").forward(req, resp);
			
			}
				
			} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
		
		
	

